package com.hebut.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * ����һ��phoneע���ǣ���ָ��Ϊע���ʵ��
 * ָ��ע���ʹ�÷�Χ���ֶ�ǰ������ǰ����ʹ��
 * ע�����Ч�ԣ�����ʱ��Ч
 * ����ע������
 */
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=PhoneValidator.class)//������¶�����һ��Լ��ע��
public @interface Phone {
	//����message����
	String message() default "";
	//����groups����
	Class<?>[] groups() default{};
	//����Payload����
	Class<? extends Payload>[] payload() default{}; 
}
