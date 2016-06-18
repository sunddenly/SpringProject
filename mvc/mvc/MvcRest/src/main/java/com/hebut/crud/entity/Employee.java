package com.hebut.crud.entity;

import java.util.Date;

import javax.validation.constraints.Past;

import com.hebut.validator.Phone;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class Employee {

	private Integer id;

	@NotEmpty
	private String lastName;

	@Email
	private String email;

	//1 male, 0 female
	private Integer gender;
	private Department department;

	@Past
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birth;

	@NumberFormat(pattern="#,###,###.#")
	private Float salary;

	@Phone(message="电话号码长度必须在{min}和{max}之间,格式必须是13,15,18开始！")
	private String phone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", gender=" + gender +
				", department=" + department +
				", birth=" + birth +
				", salary=" + salary +
				", phone='" + phone + '\'' +
				'}';
	}

	public Employee(Integer id, String lastName, String email, Integer gender,
					Department department, String phone) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.department = department;
		this.phone=phone;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}
}
