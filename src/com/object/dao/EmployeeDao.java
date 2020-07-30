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
	    
	    //get employee by object
	    public  Employee getEmployee(Employee employee) {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            return session.createQuery("from Employee e WHERE e.id="+employee.getId(), Employee.class).getSingleResult();
	        }
	    }
	    
	    //get employee by id
	    public  Employee getEmployeesById(Long employeeId) {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            return session.get(Employee.class,employeeId);
	        }
	    }
	}
