package lk.harshana.service;

import java.util.List;

import lk.harshana.model.Student;

public interface StudentService {

	List<Student> getAllStudents();
	List<Student> getStudentByFirstName(String name);
	List<Student> getStudentByLastName(String name);
	Student getStudentByStuId(String stuId);
	void saveStudent(Student student);
	void updateStudent(String stuNo, Student student);
	boolean deleteStudent(String stuId);
	
}
