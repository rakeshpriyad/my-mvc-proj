package com.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.mvc.dao.IncrementDao;
import com.test.mvc.model.NumberInfo;

@Service
public class IncrementServiceImp implements IncrementService {

	@Autowired
	private IncrementDao incrementDao;

	@Transactional
	public void save(NumberInfo dto) {
		incrementDao.save(dto);
	}

	@Override
	public NumberInfo find() {
		return incrementDao.find();
	}
}
