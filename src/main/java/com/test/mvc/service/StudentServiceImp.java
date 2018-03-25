package com.test.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.mvc.dao.StudentDao;
import com.test.mvc.model.Student;

@Service
public class StudentServiceImp implements StudentService {

   @Autowired
   private StudentDao studentDao;

   @Transactional
   public void save(Student student) {
      studentDao.save(student);
   }

   @Transactional(readOnly = true)
   public List<Student> list() {
      return studentDao.list();
   }



}
