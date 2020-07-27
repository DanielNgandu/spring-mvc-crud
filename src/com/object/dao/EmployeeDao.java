package com.object.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.form.models.Employee;
import com.hibernate.util.HibernateUtil;

public class EmployeeDao {

	 public void saveEmployee(Employee employee) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            session.save(employee);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }
	    public List < Employee > getEmployees() {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            return session.createQuery("from Employee", Employee.class).getResultList();
	        }
	    }
	    
	    //get employee by id
//	    public  Employee getEmployeesById(Employee employee) {
//	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//	            return session.get(Employee.class, employee.)
//	        }
//	    }
	}
