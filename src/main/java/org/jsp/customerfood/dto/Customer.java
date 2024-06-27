package org.jsp.customerfood.dto;

import java.util.List;

import javax.persistence.*;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private long phone;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private int age;
	@Column(nullable = false)
	private char gender;
	@Column(nullable = false)
	private String password;
	@OneToMany(mappedBy = "customer")
	private List<FoodOrder> foodorders;
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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<FoodOrder> getFoodorders() {
		return foodorders;
	}
	public void setFoodorders(List<FoodOrder> foodorders) {
		this.foodorders = foodorders;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", age=" + age
				+ ", gender=" + gender + ", password=" + password + "]";
	}
    
	
}
