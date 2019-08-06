package com.zwq.demo;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;

/*
 * @description:
 * @author: zwq
 * @date: 2018/12/10 19:20
 */
public class LdapPageQueryTool {
    public static void main(String[] args) throws Exception {
        String ldapURL = "ldap://10.154.7.9:389";
        String baseDN = "cn=002,cn=ispusers,DC=ETCISP,DC=COM,DC=CN";
        String user = "cn=domainreg@ethionet.et,cn=002,cn=ispusers,DC=ETCISP,DC=COM,DC=CN";
        String password = "test@123";
        int pageSize = 100; //设定LDAP每次分页所取的笔数

        // LDAP连线相关设定
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapURL);
        env.put(Context.SECURITY_PRINCIPAL, user);
        env.put(Context.SECURITY_CREDENTIALS, password);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.REFERRAL, "follow");
        env.put("java.naming.ldap.version", "3");

        LdapContext ctx = new InitialLdapContext(env, null);


        byte[] cookie = null;
        ctx.setRequestControls(new Control[]{new PagedResultsControl(
                pageSize, Control.CRITICAL)});

        do {
            // 设定LDAP 人员查询条件
            String searchFilter = "(objectClass=person)";
            SearchControls searchCtls = new SearchControls();
            searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

            // 进行LDAP 资料查询与资料处理
            NamingEnumeration<SearchResult> results = ctx.search(
                    baseDN, searchFilter, searchCtls);
            while (results != null && results.hasMore()) {
                SearchResult resultUser = (SearchResult) results.next();
                NamingEnumeration userAttrs = resultUser.getAttributes().getAll();
                while (userAttrs.hasMore()) {
                    Attribute attr = (Attribute) userAttrs.next();
                    String attrId = attr.getID();
                    String attrValue = (String) attr.get();

                    if (attrId.equalsIgnoreCase("cn")) {
                        System.out.println(attrValue);
                        LdapPageQueryTool.writeFile(attrValue);
                    }

                }
            }

            //================================================ ==
            // 换页处理开始
            //================================================ ==

            // 此分页资料处理完毕，底下先取出cookie，
            // 如果cookie不为null，则表示还有下一页的资料
            Control[] controls = ctx.getResponseControls();
            if (controls != null) {
                for (int i = 0; i < controls.length; i++) {
                    if (controls[i] instanceof PagedResultsResponseControl) {
                        PagedResultsResponseControl prrc =
                                (PagedResultsResponseControl) controls[i];
                        cookie = prrc.getCookie();
                    }
                }
            }

            // 将cookie资讯提供给InitialLdapContext，让它在接下来的查询中进行换页
            ctx.setRequestControls(new Control[]{new PagedResultsControl(
                    pageSize, cookie, Control.CRITICAL)});

            //================================================ ==
            // 换页处理结束
            //================================================ ==
        } while (cookie != null);

        ctx.close();
    }

    public static void writeFile(String content) {
        try {
            File file = new File("C:/result.txt");
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
