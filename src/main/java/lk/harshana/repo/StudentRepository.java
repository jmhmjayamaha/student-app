package lk.harshana.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import lk.harshana.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	List<Student> findByFirstName(String firstName);
	List<Student> findByLastName(String lastName);
	Student findByStuNo(String stuNo);

}
