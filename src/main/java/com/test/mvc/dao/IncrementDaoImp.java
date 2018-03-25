package com.test.mvc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.mvc.model.NumberInfo;

@Repository
public class IncrementDaoImp implements IncrementDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(NumberInfo dto){
		NumberInfo info =find();
		Integer val = info.getCounter();
		val++;
		info.setCounter(val);
		sessionFactory.getCurrentSession().saveOrUpdate(dto);
	}

	@Override
	public NumberInfo find() {
		Query q=sessionFactory.getCurrentSession().createQuery("from NumberInfo n");
		List<NumberInfo> infoList =q.list();
		return infoList.get(0);
	}

}
