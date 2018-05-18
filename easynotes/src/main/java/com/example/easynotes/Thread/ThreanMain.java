package com.example.easynotes.Thread;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.example.easynotes.Utils.HibernateUtils;
import com.example.easynotes.controller.PostController;
import com.example.easynotes.model.Todo;

@SuppressWarnings("unchecked")
public class ThreanMain {
	private static final Logger logger = LogManager
			.getLogger(PostController.class);

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();

		// Todo clazz = new Todo();
		// clazz.setTitle("Mai Van Bao");
		// clazz.setCompleted(true);
		// clazz.setCreatedAt(new Date());
		// clazz.setUpdatedAt(new Date());
		// session.save(clazz);
		// session.getTransaction().commit();
		//
		// Query<Todo> q = session.createQuery("From Todo ");
		//
		// List<Todo> resultList = q.list();

		// String sql = "Select e from Todo e order by e.title";

		// Tạo đối tượng Query.
		// Query<Todo> query = session.createQuery(sql);

		// List<Todo> employees =
		// session.createCriteria(Todo.class.getName()).list();

		StringBuilder query = new StringBuilder();
		query.append("SELECT t FROM Todo t");
		Query<Todo> q = session.createQuery(query.toString());
		List<Todo> employees = q.list();
		// Thực hiện truy vấn.
		// List<Todo> employees = query.list();
		logger.info(employees.toString());
		for (Todo next : employees) {
			System.out.println("Clazz name: " + next.getTitle());
		}
	}
}