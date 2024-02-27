package com.example.demo.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.CourseDto;
import com.example.demo.repository.CourseRepository;

@Component
public class CourseDao {
	@Autowired 
	CourseRepository courseRepository;
	
	public String insertCourse(CourseDto courseDto) {
		courseRepository.save(courseDto);
		return "inserted";
	}
	public CourseDto fetchCourse(String Coursename) {
		Optional<CourseDto> co=courseRepository.findById(Coursename);
		return co.get();
	}
}
