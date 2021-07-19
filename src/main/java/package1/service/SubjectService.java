package package1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import package1.entity.Student;
import package1.entity.Subject;
import package1.entity.Teacher;
import package1.repository.StudentRepository;
import package1.repository.SubjectRepository;
import package1.repository.TeacherRepository;


@Service
public class SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	
	public List<Subject> getSubjects(){
		return subjectRepository.findAll();
	}
	
	public Subject createSubject(Subject subject) {
		return subjectRepository.save(subject);
	}
	
	

	public Subject addStudent(int subjectId, int studentId) {
		Subject subject = subjectRepository.findById(subjectId).get();
		Student student = studentRepository.findById(studentId).get();
		subject.enrolledStudents.add(student);
		return subjectRepository.save(subject);
	}
	
	
	public Subject assignTeacher(int subjectId, int teacherId) {
		Subject existingSubject = subjectRepository.findById(subjectId).get();
		Teacher existingTeacher = teacherRepository.findById(teacherId).get();
		existingSubject.setTeacher(existingTeacher);
		return subjectRepository.save(existingSubject);
	}

	
}
