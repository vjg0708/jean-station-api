package com.example.app_jeanstation.model;

import jakarta.persistence.*;
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
	@JoinColumn(name = "productId", referencedColumnName = "Product_Id")
	private Product product;

	private Integer quantity;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@Override
	public String toString() {
		return "Order [order_ID=" + order_ID + ", quantity=" + quantity + ", status=" + status + "]";
	}

	public enum OrderStatus {
		PENDING, PLACED, RELEASED
	}
}
