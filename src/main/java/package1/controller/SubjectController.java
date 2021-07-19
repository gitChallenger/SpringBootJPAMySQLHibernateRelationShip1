package package1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import package1.entity.Subject;
import package1.repository.SubjectRepository;
import package1.service.StudentService;
import package1.service.SubjectService;
import package1.service.TeacherService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping
	public List<Subject> getSubjects(){
		return subjectService.getSubjects();
	}
	
	@PostMapping
	public Subject createSubject(@RequestBody Subject subject) {
		return subjectService.createSubject(subject);
	}
	
	@PostMapping("/{subjectId}/students/{studentId}")
	public Subject addStudent(@PathVariable int subjectId, @PathVariable int studentId) {
		return subjectService.addStudent(subjectId, studentId);
	}
	
	@PostMapping("/{subjectId}/teachers/{teacherId}")
	public Subject assignTeacher(@PathVariable int subjectId, @PathVariable int teacherId) {
		return subjectService.assignTeacher(subjectId, teacherId);
	}
}
