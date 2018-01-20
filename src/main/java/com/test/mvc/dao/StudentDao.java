package com.test.mvc.dao;

import java.util.List;

import com.test.mvc.model.Student;

public interface StudentDao {
   void save(Student student);
   List<Student> list();
}
