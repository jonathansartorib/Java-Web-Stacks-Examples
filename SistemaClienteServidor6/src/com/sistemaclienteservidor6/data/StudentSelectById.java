package com.sistemaclienteservidor6.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sistemaclienteservidor6.entity.Student;

public class StudentSelectById {
	//adicione _ao main para rodar o tesetjdbc
	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 1;
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\n\nSeleciona o registro pelo ID: " + studentId);
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("Dados: " + myStudent);
			
			session.getTransaction().commit();
			
		} finally {
			
			factory.close();
			
		}//end try finally
		
	}//end main

}//end StudentSelectById


