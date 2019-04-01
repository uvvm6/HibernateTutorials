package javatech.hibernate.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javatech.hibernate.entity.UserProfile;

public class MainOrmExecutor {
	private static SessionFactory factory; 
	public static void main(String[] args) {

		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) { 
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex); 
		}

		MainOrmExecutor ME = new MainOrmExecutor();

		/* Add few employee records in database */
		Integer empID1 = ME.addNewProfile("Zara", "Ali", 1000);
		Integer empID2 = ME.addNewProfile("Daisy", "Das", 5000);
		Integer empID3 = ME.addNewProfile("John", "Paul", 10000);

		/* List down all the employees */
		ME.getAllProfile();

		/* Update employee's records */
		ME.updateProfile(empID1, 5000);

		/* Delete an employee from the database */
		ME.deleteProfile(empID2);

		/* List down new list of the employees */
		ME.getAllProfile();
	}

	/* Method to CREATE an employee in the database */
	public Integer addNewProfile(String fname, String lname, int salary){
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;

		try {
			tx = session.beginTransaction();
			UserProfile employee = new UserProfile();
			employeeID = (Integer) session.save(employee); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		return employeeID;
	}

	/* Method to  READ all the employees */
	public void getAllProfile( ){
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List employees = session.createQuery("FROM UserProfile").list(); 
			for (Iterator iterator = employees.iterator(); iterator.hasNext();){
				UserProfile employee = (UserProfile) iterator.next(); 
				System.out.print("First Name: " + employee); 
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}

	/* Method to UPDATE salary for an employee */
	public void updateProfile(Integer EmployeeID, int salary ){
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			UserProfile employee = (UserProfile)session.get(UserProfile.class, EmployeeID); 
//			employee.setSalary( salary );
			session.update(employee); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}

	/* Method to DELETE an employee from the records */
	public void deleteProfile(Integer EmployeeID){
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			UserProfile employee = (UserProfile)session.get(UserProfile.class, EmployeeID); 
			session.delete(employee); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}
}
