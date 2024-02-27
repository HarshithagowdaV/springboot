package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.StudentDto;
import com.example.demo.repository.StudentRepositoy;

@Component
public class StudentDao {

	@Autowired
	StudentRepositoy studentRepositoy;
	
	public String insertStudent(StudentDto studentDto) {
		studentRepositoy.save(studentDto);
		return "data inserted";
	}
	
	public Optional<StudentDto> fetchStudentById(int id){
		return studentRepositoy.findById(id);
	}
		
		public List<StudentDto> fetchAllStudent() {
			 List<StudentDto> list = studentRepositoy.findAll();
			return list;
		}
}
