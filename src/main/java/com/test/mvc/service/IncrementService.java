package com.test.mvc.service;

import com.test.mvc.model.NumberInfo;

public interface IncrementService {
   void save(NumberInfo dto);
    NumberInfo find();

}
