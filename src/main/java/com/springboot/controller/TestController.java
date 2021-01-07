package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bean.Student;
import com.springboot.service.StudentService;

@RestController
public class TestController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping( value = "/querystudent", method = RequestMethod.GET)
	public Student queryStudentBySno(String sno) {
		return this.studentService.queryStudentBySno(sno);
	}

	@RequestMapping("/")
    public String index() {
	    Student student =studentService.queryStudentBySno("1");
        student.setName(student.getName()+"1");
        student.setSex(student.getSex()+"2");
        studentService.update(student);
        return "aaaaaa";
    }
}
