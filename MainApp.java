package com.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

public class MainApp {
	public static void main(String[] args) {
		org.hibernate.Transaction txn;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			txn = session.beginTransaction();
			Department dept = new Department(1456,"Training");
			Employee e1 = new Employee(202324,"Priya",dept);
			Employee e2 = new Employee(202325,"Raju",dept);
			Employee e3 = new Employee(202326,"Shalini",dept);
			Set<Employee> s1 = new HashSet<Employee>();
			s1.add(e1);
			s1.add(e2);
			s1.add(e3);
			dept.setEmp(s1);
			session.save(dept);
			session.save(e1);
			session.save(e2);
			session.save(e3);
			txn.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
}
}
