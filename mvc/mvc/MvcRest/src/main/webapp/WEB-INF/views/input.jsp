<%@page import="java.util.HashMap" import="java.util.Map"
         language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- 将字符串转为对象5 -->
		<fieldset>
			测试类型转换器：GG-gg@atguigu.com-0-105-18823451366 <---> employee
			<form action="testConversionServiceConverer" method="POST">
				<!-- lastname-email-gender-department.id 例如: GG-gg@atguigu.com-0-105 -->
				Employee: <input type="text" name="employee"/>
				<input type="submit" value="Submit"/>
			</form>
		</fieldset><br/>

		<fieldset>添加员工页面：
			<form:form action="${pageContext.request.contextPath }/emp" method="post"
					   modelAttribute="employee">
				<form:errors path="*"></form:errors><br/>
			   <!--若为修改页面，不能包含LastName内容-->
				<c:if test="${employee.id == null }">
					<!-- path 属性对应 html 表单标签的 name 属性值 -->
					LastName: <form:input path="lastName"/>
					<%--<form:errors path="lastName"></form:errors>--%>
				</c:if>
				<!--若传递的employee的id不为空，表示修改页面，添加页面不需要显示完整的emplyee信息-->
				<c:if test="${employee.id != null }">
					<form:hidden path="id"/>
					<input type="hidden" name="_method" value="PUT"/>
					<%-- 对于 _method 不能使用 form:hidden 标签,
						因为 modelAttribute 对应的 bean 中没有 _method 这个属性
					   <form:hidden path="_method" value="PUT"/>
					--%>
				</c:if>

				<br>
				Email: <form:input path="email"/><br/>
				<form:errors path="email"/>
				<%
					Map<String, String> genders = new HashMap();
					genders.put("1", "Male");
					genders.put("0", "Female");
					request.setAttribute("genders", genders);
				%>
				Gender:<br/>

				<form:radiobuttons path="gender" items="${genders }" delimiter="<br>"/><br/>
				Department:
				<form:select path="department.id" items="${departments }"
							 itemLabel="departmentName" itemValue="id"/><br/>

				Birth: <form:input path="birth"/><br/>
				<form:errors path="birth"/>

				Salary: <form:input path="salary"/><br/>

				Phone: <form:input path="phone"/><br/>
				<form:errors path="phone"/>
				<input type="submit" value="Submit"/>
			</form:form>
		</fieldset>
	</body>
</html>