package com.zwq.entity;

import java.io.Serializable;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Scope("prototype")
//@Lazy
@Component
public class OrderModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2876321151204996267L;
	private int orderId;
	private int userId;
	private String orderName;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int id) {
		this.orderId = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String name) {
		this.orderName = name;
	}
	
	@Override
	public int hashCode() {
		int result = 17;  
		result = result *31 + orderId;
        result = result * 31 + userId;  
        result = result * 31 + orderName.hashCode();  
        return result; 
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==this) return true;
		if(obj instanceof OrderModel)
			return false;
		OrderModel other = (OrderModel) obj;
		return this.getOrderId() == other.getOrderId();
	}

}
