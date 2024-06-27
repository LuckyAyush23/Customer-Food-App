package org.jsp.customerfood.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.customerfood.dao.FoodOrderDao;
import org.jsp.customerfood.dto.FoodOrder;

public class FoodOrderController {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	FoodOrderDao dao = new FoodOrderDao();
	
	System.out.println("Enter option");
	System.out.println("Enter 1 to save the order");
	System.out.println("Enter 2 to update the order");
	System.out.println("Enter 3 to find order by id");
	System.out.println("Enter 4 to find order by customer id");
	System.out.println("Enter 5 to find order by customer phone and password");
	System.out.println("Enter 6 to remove order");
	switch(sc.nextInt()) {
	case 1 : {
		FoodOrder o = new FoodOrder();
		System.out.println("Enter customer id");
		int customer_id = sc.nextInt();
		System.out.println("Enter foodname,cost,address");
		o.setFood_items(sc.next());
		o.setCost(sc.nextDouble());
		o.setAddress(sc.next());
		o = dao.saveFoodOrder(o, customer_id);
		System.out.println("FoodOrder saved with id : "+o.getId());
		break;
	}
	case 2 : {
		FoodOrder o = new FoodOrder();
		System.out.println("Enter id,foodname,cost,address");
		o.setId(sc.nextInt());
		o.setFood_items(sc.next());
		o.setCost(sc.nextDouble());
		o.setAddress(sc.next());
		
		o = dao.updateFoodOrder(o);
		if(o!=null) {
			System.out.println("Food order updated");
		}
		else {
			System.err.println("Cannot update food oreder");
		}
		break;
	}
	case 3:{
		System.out.println("Enter id");
		int id = sc.nextInt();
		FoodOrder o = dao.findOrderById(id);
		if(o!=null) {
			System.out.println(o);
		}
		else {
			System.err.println("order not found");
		}
		break;
	}
	case 4:{
		System.out.println("enter customer id");
		int id = sc.nextInt();
		List<FoodOrder> orders = dao.findOrderByCustomerId(id);
		if(orders!=null) {
			for(FoodOrder o : orders) {
				System.out.println(o);
			}
		}
		else {
			System.err.println("order not found");
		}
		break;
	}
	
	case 5:{
		System.out.println("Enter customer phone and password");
		long phone = sc.nextLong();
		String password = sc.next();
		List<FoodOrder> orders = dao.findOrderByCustomerPhoneAndPassword(phone, password);
		if(orders!=null) {
			for(FoodOrder o : orders) {
				System.out.println(o);
			}
		}
		else {
			System.err.println("order not found");
		}
		break;
	}
	case 6:{
		System.out.println("Enter order id");
		dao.removeOrder(sc.nextInt());
		
	}
}
}}
