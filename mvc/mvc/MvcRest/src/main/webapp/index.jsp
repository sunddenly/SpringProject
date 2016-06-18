<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#testJson").click(function(){
			var url = this.href;
			var args = {};
			$.post(url, args, function(data){
				for(var i = 0; i < data.length; i++){
					var id = data[i].id;
					var lastName = data[i].lastName;
					
					alert(id + ": " + lastName);
				}
			});
			return false;
		});
	})
</script>
</head>
<body>
    <h3>首页</h3>
	REST Employee CRUD
	<hr/>
    <a href="emps">List All Employees</a><br/><br/>
	Spring MVC JSON
	<hr/>
	测试服务端返回的JSON：<a href="testJson" id="testJson">Test Json</a>
	<br><br>
	测试HttpMessageConverter：
	<fieldset>上传文件：<br/>
		<form action="rsponseBody" method="POST" enctype="multipart/form-data">
			File: <input type="file" name="file"/>
			Desc: <input type="text" name="desc"/>
			<input type="submit" value="Submit"/>
		</form>
		<br/>
		下载文件：<a href="responseEntity">TestResponseEntity</a>
	</fieldset>
	<br/><br/>

	Spring MVC 国际化
	<hr/>
	<a href="i18n1">I18N PAGE</a><br/><br/>
	Spring MVC 上传下载
	<hr/>
	<fieldset>上传/下载表单<br/>
		<form action="fileUpload" method="POST" enctype="multipart/form-data">
			File: <input type="file" name="file"/>
			Desc: <input type="text" name="desc"/>
			<input type="submit" value="Submit"/>
		</form>
	</fieldset>
	<br><br>
	Spring MVC 异常处理
	<hr/>
	<a href="handlerException?i=10">Test ExceptionHandlerExceptionResolver</a>
	
	<br><br>
	<a href="responseStatusExceptionResolver?i=10">Test ResponseStatusExceptionResolver</a>
	
	<br><br>
	<a href="defaultHandlerExceptionResolver">Test DefaultHandlerExceptionResolver</a>
	
	<br><br>
	<a href="simpleMappingExceptionResolver?i=2">Test SimpleMappingExceptionResolver</a>
</body>
</html>