package package1.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Subject {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@ManyToMany
	@JoinTable(name="student_enrolled",
			joinColumns=@JoinColumn(name="subject_id"),
			inverseJoinColumns = @JoinColumn(name = "student_id"))
	public List<Student> enrolledStudents;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacher_id", referencedColumnName = "id")
	public Teacher teacher;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + "]";
	}
	public void setTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		this.teacher = teacher;
		
	}
	
}
