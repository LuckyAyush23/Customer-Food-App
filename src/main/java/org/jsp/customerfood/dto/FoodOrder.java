package org.jsp.customerfood.dto;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class FoodOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String food_items;
	@Column(nullable = false)
	private double cost;
	@CreationTimestamp
	private LocalDateTime ordered_time;
	@UpdateTimestamp
	private LocalDateTime delivery_time;
	@Column(nullable =false)
	private String address;
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFood_items() {
		return food_items;
	}
	public void setFood_items(String food_items) {
		this.food_items = food_items;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public LocalDateTime getOrdered_time() {
		return ordered_time;
	}
	public void setOrdered_time(LocalDateTime ordered_time) {
		this.ordered_time = ordered_time;
	}
	public LocalDateTime getDelivery_time() {
		return delivery_time;
	}
	public void setDelivery_time(LocalDateTime delivery_time) {
		this.delivery_time = delivery_time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "FoodOrder [id=" + id + ", food_items=" + food_items + ", cost=" + cost + ", ordered_time="
				+ ordered_time + ", delivery_time=" + delivery_time + ", address=" + address + "]";
	}
	
	
}
