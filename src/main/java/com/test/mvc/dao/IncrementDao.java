package com.test.mvc.dao;

import com.test.mvc.model.NumberInfo;

public interface IncrementDao {
   void save(NumberInfo dto);

	NumberInfo find();
}
