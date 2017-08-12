package com.zwq.entity;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

//@Scope("prototype")
//@Lazy
//@XmlRootElement
@Component
public class UserModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2876321151204996267L;
	private int id;
	private String name;
	private int age;
	private List<OrderModel> orders;
	
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
	
	public List<OrderModel> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderModel> orders) {
		this.orders = orders;
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
