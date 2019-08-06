package com.zwq.demo;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.Hashtable;

/*
 * @description:
 * @author: zwq
 * @date: 2018/12/10 20:54
 */
public class Range {



        public static void main (String[] args) {



            Hashtable env = new Hashtable();

            String adminName = "cn=Manager,dc=zzbk,dc=com";

            String adminPassword = "secret";




            env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");

                    //set security credentials, note using simple cleartext authentication


                    env.put(Context.SECURITY_AUTHENTICATION,"simple");

            env.put(Context.SECURITY_PRINCIPAL,adminName);

            env.put(Context.SECURITY_CREDENTIALS,adminPassword);



            //connect to my domain controller

            env.put(Context.PROVIDER_URL,"ldap://127.0.0.1:389");



            try {



                // Create the initial directory context

                LdapContext ctx = new InitialLdapContext(env,null);



                // Create the search controls

                SearchControls searchCtls = new SearchControls();



                //Specify the search scope

                searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);



                //specify the LDAP search filter

                String searchFilter = "(objectClass=person)";



                //Specify the Base for the search

                String searchBase = "cn=users,dc=zzbk,dc=com";



                //initialize counter to total the group members and range values

                int totalResults = 0;

                int Start = 0;

                int Step = 10;

                int Finish = 9;

                boolean Finished = false;

                String Range;



                //loop through the query until we have all the results

                while (!Finished) {



                    //Specify the attributes to return

                    Range = Start + "-" + Finish;

                    String returnedAtts[]={"member;Range=" + Range};

                    searchCtls.setReturningAttributes(returnedAtts);



                    //Search for objects using the filter

                    NamingEnumeration answer = ctx.search(searchBase,
                            searchFilter, searchCtls);



                    //Loop through the search results

                    while (answer.hasMoreElements()) {

                        SearchResult sr = (SearchResult)answer.next();



                        System.out.println(">>>" + sr.getName());



                        //Print out the members



                        Attributes attrs = sr.getAttributes();

                        if (attrs != null) {



                            try {

                                for (NamingEnumeration ae =
                                     attrs.getAll();ae.hasMore();) {

                                    Attribute attr = (Attribute)ae.next();



                                    //check if we are finished

                                    if (attr.getID().endsWith("*")) {

                                        Finished=true;

                                    }



                                    System.out.println("Attribute: " +
                                            attr.getID());

                                    for (NamingEnumeration e =
                                         attr.getAll();e.hasMore();totalResults++) {



                                        System.out.println("   " + totalResults + ". " + e.next());

                                    }

                                }



                            }

                            catch (NamingException e)   {

                                System.err.println("Problem printing attributes: " + e);

                            }



                            Start = Start + Step;

                            Finish = Finish + Step;



                        }

                    }

                }



                System.out.println("Total members" + totalResults);

                ctx.close();



            }

            catch (NamingException e) {

                System.err.println("Problem searching directory: " + e);

            }

        }



}


