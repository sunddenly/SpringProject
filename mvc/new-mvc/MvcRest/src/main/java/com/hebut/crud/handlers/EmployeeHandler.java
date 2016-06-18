package com.hebut.crud.handlers;

import java.util.Map;

import javax.validation.Valid;

import com.hebut.crud.dao.DepartmentDao;
import com.hebut.crud.dao.EmployeeDao;
import com.hebut.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeHandler {
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private DepartmentDao departmentDao;

	//自动获取某个员工信息放入Model当中，用于后续的更新操作
	//当请求传递了id参数时，下面方法才会执行
	@ModelAttribute
	public void getEmployee(@RequestParam(value="id",required=false) Integer id,
			Map<String, Object> map){
		if(id != null){
			map.put("employee", employeeDao.get(id));
		}
	}
	//加载添加页面
	@RequestMapping(value="/emp", method=RequestMethod.GET)
	public String input(Map<String, Object> map){
		System.out.println("load!");
		map.put("departments", departmentDao.getDepartments());
		map.put("employee", new Employee());
		return "input";
	}

	///添加员工信息操作
	@RequestMapping(value="/emp", method=RequestMethod.POST)
	public String save(@Valid Employee employee, Errors result,
					   Map<String, Object> map){
		System.out.println("add");
		System.out.println("save: " + employee);

		if(result.getErrorCount() > 0){
			System.out.println("出错了!");
			for(FieldError error:result.getFieldErrors()){
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
			}

			//若验证出错, 则转向定制的页面
			map.put("departments", departmentDao.getDepartments());
			return "input";
		}
		employeeDao.save(employee);//保存数据到数据库
		return "redirect:/emps";
	}
	//获取更改页面信息
	@RequestMapping(value="/emp/{id}", method=RequestMethod.GET)
	public String input(@PathVariable("id") Integer id, Map<String, Object> map){
		map.put("employee", employeeDao.get(id));
		map.put("departments", departmentDao.getDepartments());
		return "input";
	}

	//修改员工信息操作
	@RequestMapping(value="/emp", method=RequestMethod.PUT)
	public String update(Employee employee){
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	//删除操作
	@RequestMapping(value="/emp/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id){
		employeeDao.delete(id);
		return "redirect:/emps";
	}


	//列表显示
	@RequestMapping("/emps")
	public String list(Map<String, Object> map){
		map.put("employees", employeeDao.getAll());
		return "list";
	}

    //测试@InitBinder注解，和Validator的LastName字段相冲突
//	@InitBinder
//	public void initBinder(WebDataBinder binder){
//	    //表单中的lastName字段，不会绑定到User对象
//		binder.setDisallowedFields("lastName");
//	}
	
}
