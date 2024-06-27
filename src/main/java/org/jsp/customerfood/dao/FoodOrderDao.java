package org.jsp.customerfood.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.customerfood.dto.Customer;
import org.jsp.customerfood.dto.FoodOrder;

public class FoodOrderDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
	EntityManager manager = factory.createEntityManager();
    
	public FoodOrder saveFoodOrder(FoodOrder o,int customer_id) {
		EntityTransaction transaction = manager.getTransaction();
		Customer c = manager.find(Customer.class, customer_id);
		if(c!=null) {
        c.getFoodorders().add(o);
        o.setCustomer(c);
		manager.persist(o);
		transaction.begin();
		transaction.commit();
		return o;
		}
		return null;
	}
	
	public FoodOrder updateFoodOrder(FoodOrder o) {
		EntityTransaction transaction = manager.getTransaction();
		FoodOrder foDatabase = manager.find(FoodOrder.class, o.getId());
		if(foDatabase!=null) {
			foDatabase.setFood_items(o.getFood_items());
			foDatabase.setCost(o.getCost());
			foDatabase.setAddress(o.getAddress());
			transaction.begin();
			transaction.commit();
			return foDatabase;
		}
		return null;
	}

	public FoodOrder findOrderById(int id) {
		return manager.find(FoodOrder.class, id);
	}
	
	public List<FoodOrder> findOrderByCustomerId(int customer_id){
		Query q = manager.createQuery("select c.foodorders from Customer c where c.id=?1");
		q.setParameter(1,customer_id);
		return q.getResultList();
	}
	
	public List<FoodOrder> findOrderByCustomerPhoneAndPassword(long phone,String password){
		Query q = manager.createQuery("select c.foodorders from Customer c where c.phone=?1 and c.password=?2");
		
		q.setParameter(1,phone);
		q.setParameter(2, password);
		return q.getResultList();
	}

	public void removeOrder(int id) {
		EntityTransaction transaction = manager.getTransaction();
		FoodOrder o = manager.find(FoodOrder.class, id);
		if(o != null) {
			manager.remove(o);
			transaction.begin();
			transaction.commit();
			System.out.println("Order successfully removed");
		}
		else {
			System.out.println("Order id not found");
		}
	}

}

