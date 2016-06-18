package com.hebut.verify;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.hebut.annotation.Phone;

public class User {
	@NotEmpty(message="�û�������Ϊ��")
	private String username;
	@NotEmpty(message="���벻��Ϊ��")
	@Size(min=6,max=10,message="����λ��������{min}-{max}֮��")
	private String password;
	@Phone(message="�绰�����ʽ������13,15,18��ʼ��")
	private String telePhone;
	
	public User() {
		super();
	}
	
	public User(String username, String password, String telePhone) {
		super();
		this.username = username;
		this.password = password;
		this.telePhone = telePhone;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelePhone() {
		return telePhone;
	}
	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}
	
}
