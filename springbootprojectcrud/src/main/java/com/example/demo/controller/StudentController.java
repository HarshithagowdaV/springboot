package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.CourseDto;

import com.example.demo.dto.StudentDto;
import com.example.demo.service.CourseService;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StudentController {
 @Autowired
 StudentService studentService;
 
 @Autowired
 CourseService courseService;
 
 @RequestMapping("/student")
 public String studenthtml() { 
 return "Student";
 }
 
 @PostMapping("/si")
 @ResponseBody
 public String insertStudent(@ModelAttribute StudentDto studentDto) {
	 System.out.println(studentDto);
	 String cn=studentDto.getCoursename();
	CourseDto courseDto= courseService.fetchCourse(cn);
	studentDto.setCourseDto(courseDto);
	System.out.println(studentDto);
	 
	  return studentService.insertStudent(studentDto);
 }
    
      @GetMapping("/fsid")
      public String studentfetch(@RequestParam int id, ModelMap map) {
         StudentDto studentDto=studentService.fetchStudentById(id);
        map.put("object", studentDto);
         return "fetchsid.html";
      }
      
       @GetMapping("/fsall")
       public String fetchAllStudent(ModelMap map) {
           List<StudentDto> list=studentService.fetchAllStudent();
           map.put("objects", list);
           return "fetchallstudent.html";
       }
       
      
  
  	
  	
      
}
