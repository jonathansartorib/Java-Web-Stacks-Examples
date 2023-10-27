package com.sistemaclienteservidor6.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sistemaclienteservidor6.entity.Student;

public class StudentInsert {
	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Student tempStudent = new Student("Gabriel", "Pato", "gabrielpato@gmail.com");
			
			session.beginTransaction();

			System.out.println("Inserindo registro.");
			session.save(tempStudent);

			session.getTransaction().commit();

		} finally {

			factory.close();

		} // end try finally

	}
}
