package com.test.mvc.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.mvc.model.Student;

@Repository
public class StudentDaoImp implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(Student student){
		sessionFactory.getCurrentSession().save(student);
	}

	public List<Student> list() {
		@SuppressWarnings("unchecked")
		TypedQuery<Student> query = sessionFactory.getCurrentSession().createQuery("from Student");
		return query.getResultList();
	}

}
