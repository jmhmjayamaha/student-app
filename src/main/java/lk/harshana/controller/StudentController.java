package lk.harshana.controller;

import java.util.AbstractMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@RequestMapping(method=RequestMethod.GET, value="/search")
	public List<Student> searchStudent(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName
			,@RequestParam("stuNo") String stuNo ) {
		
		
		return null;
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/{stuNo}")
	@ResponseStatus(value=HttpStatus.CREATED)
	public void updateStudent(@PathVariable("stuNo")String stuNo, @RequestBody @Validated StudentDto dto) {
		studentService.updateStudent(stuNo, new Student(stuNo, dto.getFirstName(), dto.getLastName(), dto.getGender(),
				dto.getAge(), dto.getAddress(), dto.getEmail()));
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{stuNo}")
	@ResponseStatus(value=HttpStatus.OK)
	public AbstractMap.SimpleEntry<String, String> deleteStudent(@PathVariable("stuNo")String stuNo) {
		if(studentService.deleteStudent(stuNo)) {
			return new AbstractMap.SimpleEntry<String, String>("status", "deleted");
		} 
		return new AbstractMap.SimpleEntry<String, String>("status", "Not Deleted");
	}
}
