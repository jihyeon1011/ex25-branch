package com.cjh.ex25_branch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjh.ex25_branch.domain.Student;
import com.cjh.ex25_branch.service.StudentService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;

//	list화면: 학생의 전체목록 보기	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
//		화면의 경로와 이름		
		return "student/list";
	}

//	form화면: 한명의 학생을 등록하기 위한 빈 입력화면
	@GetMapping("/new")
	public String createform(Model model) {
		model.addAttribute("student", new Student());
		return "student/form";
	}

//	form화면 [저장버튼] 클릭: 한명의 학생을 등록처리	
	@PostMapping
	public String create(@ModelAttribute Student student) {
		studentService.createStudent(student);
		return "redirect:/students";
	}

//	list화면 [수정버튼] 클릭 -> form화면 : 한명의 학생의 정보를 보여줌
	@GetMapping("/{id}/edit")
	public String updateForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudent(id));
		return "student/form";
	}

//	[수정처리]
	@PostMapping("/{id}")
	public String update(@PathVariable Long id, @ModelAttribute Student student) {
		student.setId(id);
		studentService.updateStudent(student);
		return "redirect:/students";
	}

// [삭제처리]
	@PostMapping("/{id}/delete")
	public String delete(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "redirect:/students";
	}

}
