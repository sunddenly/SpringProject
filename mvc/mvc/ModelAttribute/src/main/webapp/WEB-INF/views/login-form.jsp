<%@ page import="java.util.*" contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<!-- 导入JSP 核心标签-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="base" value="/"/>
<html>
    <head>
        <title>Login Form</title>
        <link rel="stylesheet" type="text/css" href="${base}statics/css/styles.css">
    </head>
    <body>
         <h6>${message}</h6>
         <form method="post" action="${base}user/update.do">
             <div>
                 <h2>更新 </h2>
                 <p><label>用户</label><input type="text" name="name"/></p>
                 <p><label>电话</label><input type="text" name="phone"/></p>
                 <h3><input type="submit" value="更新"/></h3>
             </div>
         </form>
    </body>
</html>