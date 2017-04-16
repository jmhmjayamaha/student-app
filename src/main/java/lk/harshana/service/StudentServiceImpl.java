package lk.harshana.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.harshana.model.Student;
import lk.harshana.repo.StudentRepository;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudents() {
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public List<Student> getStudentByFirstName(String name) {
		return studentRepository.findByFirstName(name);
	}

	@Override
	public List<Student> getStudentByLastName(String name) {
		return studentRepository.findByLastName(name);
	}

	@Override
	public Student getStudentByStuId(String stuId) {
		return studentRepository.findByStuNo(stuId);
	}

	@Override
	public void saveStudent(Student student) {
		if(studentRepository.findByStuNo(student.getStuNo()) == null ) {
			studentRepository.save(student);
		} else {
			
		}
	}

	@Override
	public void updateStudent(String stuNo, Student student) {
		Student stu = studentRepository.findByStuNo(stuNo);
		if(stu != null) {
			student.setId(stu.getId());
			studentRepository.save(student);
		} else {
			// throw an error
		}
		
	}

	@Override
	public boolean deleteStudent(String stuId) {
		Student student = studentRepository.findByStuNo(stuId);
		if( student != null ) {
			studentRepository.delete(student);
			return true;
		}
		return false;
	}

}
