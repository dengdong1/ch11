<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!-- 导入Struts 2标签库 -->
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<!-- 访问地址http://localhost:8001/Helloworld/helloWorld.jsp -->

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>login</title>
</head>
<body>
<h1>login</h1>
<hr/>
<div>
    <s:form action="/interceptor/login.action" method="post">
        <s:textfield name="user.userName" label="请输入您的用户名1"/>
        <s:textfield name="user.passWord" label="请输入您的密码"></s:textfield>
        <s:submit value="提交22"/>
    </s:form>
</div>
</body>
</html>