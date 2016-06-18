package com.hebut.annotation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
/**
 * ע��@phone��У������ʵ��������֤�߼�
 * �ǿգ����ұ�������13��15��18��ʼ���ֻ���
 * У��phoneע���string����
 *
 */
public class PhoneValidator implements ConstraintValidator<Phone, String>{
	private String phoneReg="^1[3|5|8]\\d{9}$";
	private Pattern phonePattern = Pattern.compile(phoneReg);
	public void initialize(Phone constraintAnnotation) {
	
	}
	//���鷽��
	public boolean isValid(String value, ConstraintValidatorContext context) {
		//У���߼�
		if(value!=null&&!"".equals(value)){
			Matcher matcher = phonePattern.matcher(value);
			return matcher.matches();//�����Ƿ�ƥ��
		}else{
			return false;
		}
	}

}
