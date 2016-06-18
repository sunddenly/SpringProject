package com.hebut.verify;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class EmpController {
	
	@RequestMapping("/toUpdateEmp")
	public String toUpdate(Model model){
		System.out.println("----------Update");
		//�����ݿ��м���ԭ����������Ϣ
		Emp emp = new Emp();
		emp.setAge(45);
		emp.setName("����");
		emp.setSex("M");
		emp.setDescr("���ݳ��ᣬ���������");
		emp.setCity("bj");
		emp.setFavor("3");
		emp.setFavs(new String[]{"a","b"});
		emp.setCities(new String[]{"bj","sh"});
		model.addAttribute("emp",emp);
		return "updateEmp";//����updateEmp.jsp
	}
	//����ϲ������ѡ��
	@ModelAttribute("cityMap")
	private Map<String, Object> getCities() {
		System.out.println("-----------getCities");
		Map<String,Object> cityMap = new HashMap<String,Object>();
		cityMap.put("bj","����");
		cityMap.put("tj","���");
		cityMap.put("sh","�Ϻ�");
		cityMap.put("gz","����");
		return cityMap;
	}
}
