package com.hebut.converters;

import com.hebut.crud.entity.Department;
import com.hebut.crud.entity.Employee;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class EmployeeConverter implements Converter<String, Employee> {
	//@Override
	public Employee convert(String source) {
		if(source != null){
			String [] vals = source.split("-");
			//GG-gg@atguigu.com-0-105-18823451366
			if(vals != null && vals.length ==5){
				String lastName = vals[0];
				String email = vals[1];
				String phone = vals[4];
				Integer gender = Integer.parseInt(vals[2]);
				Department department = new Department();
				department.setId(Integer.parseInt(vals[3]));
				
				Employee employee = new Employee(null, lastName, email, gender, department,phone);
				System.out.println(source + "--convert--" + employee);
				return employee;
			}
		}
		return null;
	}
}
