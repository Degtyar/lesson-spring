<%--
  Created by IntelliJ IDEA.
  User: kostyadegtyar
  Date: 21.09.2018
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Company-edit</title>
</head>
<body>
<form:form method="post" action="/company-save/" modelAttribute="company">
    <p>
    <div style="...">Id</div>
    <form:input path="id"/>
    </p>
    <p>
    <div style="...">Name</div>
    <form:input path="name"/>
    </p>
    <p>
        <button type="submit">Save</button>
    </p>
</form:form>

</body>
</html>
