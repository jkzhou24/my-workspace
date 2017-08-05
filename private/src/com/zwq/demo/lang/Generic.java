package com.zwq.demo.lang;

import java.util.Collection;

public class Generic<T> {
	/*public <T> void fromArrayToCollection(T[] a, Collection<T> c){  
        for(T t : a){  
            c.add(t);  
        }  
    }  */
  
  
	public void fromArrayToCollection(T[] a, Collection<T> c){  
        for(T t : a){  
            c.add(t);  
        }  
    }
	
	public static <T> void display(T t) {
        System.out.println(t.getClass());
    }
}
