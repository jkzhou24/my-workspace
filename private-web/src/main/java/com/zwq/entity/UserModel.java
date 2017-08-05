package com.zwq.entity;

import java.io.Serializable;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Scope("prototype")
//@Lazy
@Component
public class UserModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2876321151204996267L;
	private int id;
	private String name;
	private int age;
	
	public UserModel() {
		System.out.println("UserModel实例化");
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		int result = 17;  
		result = result *31 + id;
        result = result * 31 + name.hashCode();  
        result = result * 31 + age;  
        return result; 
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==this) return true;
		if(obj instanceof UserModel)
			return false;
		UserModel other = (UserModel) obj;
		return this.getId() == other.getId();
	}

}
