package org.jsp.customerfood.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.customerfood.dto.Customer;

import net.bytebuddy.asm.Advice.Return;

public class CustomerDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
	EntityManager manager = factory.createEntityManager();

    public Customer saveCustomer(Customer c) {
    EntityTransaction transaction = manager.getTransaction();
    manager.persist(c);
    transaction.begin();
    transaction.commit();
    return c;
    }
    
    public Customer updateCustomer(Customer c) {
    	EntityTransaction transaction = manager.getTransaction();
    	Customer dbCustomer = manager.find(Customer.class,c.getId());
    	if(dbCustomer!=null) {
    		dbCustomer.setName(c.getName());
        	dbCustomer.setPhone(c.getPhone());
        	dbCustomer.setEmail(c.getEmail());
        	dbCustomer.setAge(c.getAge());
        	dbCustomer.setGender(c.getGender());
        	dbCustomer.setPassword(c.getPassword());
        	transaction.begin();
        	transaction.commit();
        	return dbCustomer;
    	}
    	return null;
    }
    
    public Customer findCustomerById(int id) {
        return manager.find(Customer.class, id);    	
    }
    
    public Customer verifyCustomerByPhoneAndPassword(long phone,String password) {
    	Query q = manager.createQuery("select c from Customer c where c.phone=?1 and c.password=?2");
    q.setParameter(1, phone);
    q.setParameter(2, password);
    return (Customer)q.getSingleResult();
     }
    
    public Customer verifyCustomerByEmailAndPassword(String email,String password) {
    	Query q = manager.createQuery("select c from Customer c where c.email=?1 and c.password=?2");
    q.setParameter(1, email);
    q.setParameter(2, password);
    return (Customer)q.getSingleResult();
     }
    
    
}
