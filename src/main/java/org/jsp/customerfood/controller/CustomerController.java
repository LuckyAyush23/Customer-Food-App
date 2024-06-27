package org.jsp.customerfood.controller;

import java.util.Scanner;

import org.jsp.customerfood.dao.CustomerDao;
import org.jsp.customerfood.dto.Customer;

public class CustomerController {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	CustomerDao dao = new CustomerDao();
	
	System.out.println("Enter option");
	System.out.println("Enter 1 for save the customer");
	System.out.println("Enter 2 for update the customer");
	System.out.println("Enter 3 for find the customer by id");
	System.out.println("Enter 4 for verify the customer by phone and password");
	System.out.println("Enter 5 for verify the customer by email and password");
	
	switch(sc.nextInt()) {
	case 1 : {
		Customer c = new Customer();
		System.out.println("Enter name,phone,email,age,gender,password");
		c.setName(sc.next());
		c.setPhone(sc.nextLong());
		c.setEmail(sc.next());
		c.setAge(sc.nextInt());
		c.setGender(sc.next().charAt(0));
		c.setPassword(sc.next());
		c = dao.saveCustomer(c);
		System.out.println("Customer is saved with id : "+c.getId());
		break;
	}
	case 2 : {
		Customer c = new Customer();
		System.out.println("Enter id,name,phone,email,age,gender,password");
		c.setId(sc.nextInt());
		c.setName(sc.next());
		c.setPhone(sc.nextLong());
		c.setEmail(sc.next());
		c.setAge(sc.nextInt());
		c.setGender(sc.next().charAt(0));
		c.setPassword(sc.next());
		c = dao.updateCustomer(c);
		if(c!=null) {
			System.out.println("Customer details updated");
		}
		else {
			System.err.println("Customer id no found");
		}
		break;
	}
	case 3 : {
		System.out.println("Enter id");
		Customer c = dao.findCustomerById(sc.nextInt());
		if(c!=null) {
			System.out.println("Cutomer found");
			System.out.println(c);
		}
		else {
			System.err.println("invalid id");
		}
		break;
	}
	
	case 4:{
		System.out.println("Enter phone and password");
		long phone = sc.nextLong();
		String password = sc.next();
		Customer c = dao.verifyCustomerByPhoneAndPassword(phone, password);
		if(c!=null) {
			System.out.println("Customer verified");
		}
		else {
			System.err.println("Customer not verified");
		}
		break;
	}
	case 5:{
		System.out.println("Enter email and password");
		String email = sc.next();
		String password = sc.next();
		Customer c = dao.verifyCustomerByEmailAndPassword(email, password);
		if(c!=null) {
			System.out.println("Customer verified");
		}
		else {
			System.err.println("Customer not verified");
		}
		break;
	}
	
	}
}
}
