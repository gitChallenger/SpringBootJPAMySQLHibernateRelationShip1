package package1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import package1.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
