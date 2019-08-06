package com.zwq.demo;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.util.Properties;

/*
 * @description:
 * @author: zwq
 * @date: 2018/12/10 18:07
 */
public class LDAPTest {
    //public static String BASE_DN = "cn=002,cn=ispusers,DC=ETCISP,DC=COM,DC=CN";
    public static String BASE_DN = "cn=users,dc=zzbk,dc=com";

    public static DirContext getContext() throws Exception {
        String ldapURL = "ldap://127.0.0.1:389";
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "cn=Manager,dc=zzbk,dc=com");
        env.put(Context.SECURITY_CREDENTIALS, "secret");
        env.put(Context.PROVIDER_URL, ldapURL);
        env.put(Context.REFERRAL, "follow");
        env.put("java.naming.ldap.version", "3");

        return new InitialDirContext(env);
    }

    public static void getUserList(DirContext cnt) throws Exception {
        //获取的用户属性
        String[] atts = {"uid", "cn", "mobile", "modifyTimestamp", "belongOU", "Userstatus", "Gender"};
        String filter = "objectClass=person";

        NamingEnumeration<SearchResult> resultUsers = LDAPTest.getSearchResultNamingEnumeration(cnt, atts, filter);

        while (resultUsers != null && resultUsers.hasMore()) {
            SearchResult resultUser = (SearchResult) resultUsers.next();
            NamingEnumeration userAttrs = resultUser.getAttributes().getAll();
            while (userAttrs.hasMore()) {
                Attribute attr = (Attribute) userAttrs.next();
                String attrId = attr.getID();
                String attrValue = (String) attr.get();

                System.out.println(attrId + ":" + attrValue);

            }

        }
    }

    public static NamingEnumeration<SearchResult> getSearchResultNamingEnumeration(DirContext cnt, String[] atts, String filter) throws NamingException {
        NamingEnumeration<SearchResult> namingEnum = null;
        SearchControls searchCons = new SearchControls();
        searchCons.setSearchScope(SearchControls.SUBTREE_SCOPE);
        searchCons.setCountLimit(0);
        searchCons.setTimeLimit(0);
        searchCons.setReturningAttributes(atts);

        namingEnum = cnt.search(LDAPTest.BASE_DN, filter, searchCons);
        return namingEnum;
    }

    public static void main(String[] args) throws Exception {
        DirContext dc = LDAPTest.getContext();
        System.out.println(dc.toString());
        LDAPTest.getUserList(dc);
    }
}
