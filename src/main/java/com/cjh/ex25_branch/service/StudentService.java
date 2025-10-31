package com.cjh.ex25_branch.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjh.ex25_branch.domain.Student;
import com.cjh.ex25_branch.mapper.StudentMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {

	private final StudentMapper studentMapper;

	public List<Student> getAllStudents() {
//		매퍼 오브젝트에게 값을 요청		
		return studentMapper.findAll();
	}

	public Student getStudent(Long id) {

		return studentMapper.findById(id);
	}

	@Transactional
	public void createStudent(Student student) {
		studentMapper.insert(student);
	}

	@Transactional
	public void updateStudent(Student student) {
		studentMapper.update(student);
		
	}

	@Transactional
	public void deleteStudent(Long id) {
		studentMapper.delete(id);
		
	}

//	public String getMyString() {
//		return "test";
//	}
//
//	public Integer getMyInteger() {
//		return 99;
//	}
//
//	public MyStudent getStudent() {
////		자바방식		
//		MyStudent myStduent = new MyStudent();
//		myStduent.setName("홍길동");
//		myStduent.setAge(10);
//		return myStduent;
//	}
//
//	public String getStudentName() {
//
//		MyStudent myStudent2 = new MyStudent();
//		myStudent2.setName("일지매222");
//		myStudent2.setAge(20);
//
//		return myStudent2.getName();
//	}

}
