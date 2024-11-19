package com.example.app_jeanstation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
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

	public enum getOrderStatus
	{
		PENDING ,PLACED , RELEASED
	}
	

	@Override
	public String toString()
	{
		return "Order [order_ID=" + order_ID + ", quantity=" + quantity + ", status=" + status + "]";
	}

}
