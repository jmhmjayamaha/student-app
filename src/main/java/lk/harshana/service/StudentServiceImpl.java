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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentByFirstName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentByLastName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentByStuId(String stuId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveStudent(Student student) {
		if(studentRepository.findByStuNo(student.getStuNo()) == null ) {
			studentRepository.save(student);
		} else {
			
		}
	}

	@Override
	public void updateStudent(int id, Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteStudent(String stuId) {
		// TODO Auto-generated method stub
		return false;
	}

}
