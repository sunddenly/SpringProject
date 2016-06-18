<%@ page import="java.util.*"
         contentType="text/html;charset=UTF-8"
         language="java"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
Index<br/>
${dept.name}
<br/>
会话：${sessionScope.user.name}<br/>
Model：user:${requestScope.user.name}  ^^^ name:${name}<br/>
Model：abc:${requestScope.abc.name}  ^^^ name:${name}

</body>
</html>