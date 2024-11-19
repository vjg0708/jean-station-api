package com.example.app_jeanstation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="OrderDetails")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long order_ID;
	
	@ManyToOne
	private Product product;
	private Integer quantity;
	
	
	@Enumerated(EnumType.STRING)
	private getOrderStatus status;

	public enum getOrderStatus{
		
		PENDING ,PLACED , RELEASED
	}
	
	public Long getOrder_ID() {
		return order_ID;
	}
	public void setOrder_ID(Long order_ID) {
		this.order_ID = order_ID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public getOrderStatus getStatus() {
		return status;
	}
	public void setStatus(getOrderStatus status) {
		this.status = status;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Order [order_ID=" + order_ID + ", quantity=" + quantity + ", status=" + status + "]";
	}
	public Order(Long order_ID, int quantity, getOrderStatus status) {
		super();
		this.order_ID = order_ID;
		this.quantity = quantity;
		this.status = status;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
