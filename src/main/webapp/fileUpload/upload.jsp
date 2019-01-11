<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/29 0029
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form action="upload.action" enctype="multipart/form-data" method="post">
    <s:file name="upload"/>
    <s:submit value="上传"/>
</s:form>
<img src ="${pageContext.request.contextPath}/upload/<s:property value='uploadFileName'/>">
<hr>
<img src="${pageContext.request.contextPath}/upload/${uploadFileName}">

</body>
</html>
