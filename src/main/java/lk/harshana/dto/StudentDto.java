package lk.harshana.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class StudentDto {

	@NotNull
	private String stuNo;
	
	@NotNull
	private String firstName;
	private String lastName;
	
	@NotNull
	private String gender;
	
	@Max(30)
	@Min(20)
	private int age;
	private String address;
	
	@NotNull
	private String email;

	public StudentDto(){}
	
	public StudentDto(String stuNo, String firstName, String lastName, String gender, int age, String address,
			String email) {
		super();
		this.stuNo = stuNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.email = email;
	}

	public String getStuNo() {
		return stuNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
