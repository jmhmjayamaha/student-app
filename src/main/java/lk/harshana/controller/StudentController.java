package lk.harshana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lk.harshana.dto.StudentDto;
import lk.harshana.model.Student;
import lk.harshana.service.StudentService;

@RestController
@RequestMapping(value = "/api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void saveStudent(@RequestBody @Validated StudentDto dto) {
		studentService.saveStudent(new Student(dto.getStuNo(), dto.getFirstName(), dto.getLastName(), dto.getGender(),
				dto.getAge(), dto.getAddress(), dto.getEmail()));
	}
}
