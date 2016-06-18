package com.hebut.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //测试Spring IOC是否可以依赖Controller
//	@Autowired
//	private HelloWorld helloWorld;
	
	public UserService() {
		System.out.println("UserService Constructor...");
	}
	
}
