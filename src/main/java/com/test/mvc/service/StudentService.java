package com.test.mvc.service;

import java.util.List;

import com.test.mvc.model.Student;

public interface StudentService {
   void save(Student student);

   List<Student> list();
}
