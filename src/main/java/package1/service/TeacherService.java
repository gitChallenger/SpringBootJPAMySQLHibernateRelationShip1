package package1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import package1.entity.Teacher;
import package1.repository.TeacherRepository;

@Service
public class TeacherService {
	@Autowired
	private TeacherRepository teacherRepository;
	
	public List<Teacher> getTeachers(){
		return teacherRepository.findAll();
	}
	
	public Teacher createStudent(Teacher teacher) {
		return teacherRepository.save(teacher);
	}
}
