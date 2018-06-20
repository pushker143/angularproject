package com.dao;

import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.bean.Employee;
import com.util.HibernateUtil;

public class EmployeeDAO {
	public ArrayList<Employee> listEmployees() {
		ArrayList<Employee> empList=null;
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			empList=(ArrayList<Employee>) session.createQuery("FROM Employee order by EMPID").list(); 
		} catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		return empList;
	}
	
	public boolean insertEmployee(Employee emp) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=null;
		Integer empID=null;
		try {
			tx=session.beginTransaction();
			empID=(Integer) session.save(emp);
			tx.commit();
		} catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		if(empID==null) return false;
		else return true;
	}
	
	public boolean updateEmployee(Employee emp) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.update(emp);
			tx.commit();
			return true;
		} catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		return false;
	}
	
	public Employee deleteEmployee(int emp) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Employee employee=(Employee)session.get(Employee.class,emp);
			session.delete(employee);
			tx.commit();
			return employee;
		} catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		return null;
	}
	
	public Employee fetchEmployee(int emp) {
		Employee empl=null;
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			empl=(Employee)session.get(Employee.class,emp);
			return empl;
		} catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		return null;
	}
}