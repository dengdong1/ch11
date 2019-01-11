<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/29 0029
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:actionerror/>
<s:fielderror></s:fielderror>
上传多个文件：
<hr>
<s:form action="/fileupload/uploadArray.action" enctype="multipart/form-data" method="post">
    <s:file name="upload"/>
    <s:file name="upload"/>
    <s:file name="upload"/>
    <s:submit value="上传"/>
</s:form>

<s:iterator value="uploadFileName">
    <img src="${pageContext.request.contextPath}/upload/<s:property/>">
</s:iterator>

</body>
</html>
