<%--
  Created by IntelliJ IDEA.
  User: kostyadegtyar
  Date: 25/09/2018
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Profile-view</title>
</head>
<body>
<c:set var="user" value="${user}"/>
<table width="100%" cellspacing="10" cellpadding="10" border="1" style="...">
    <tr>
        <th colspan="5" align="center">
            USER
        </th>
    </tr>
    <tr>
        <td>ID</td>
        <td>${user.id}</td>
    </tr>
    <tr>
        <td>NAME</td>
        <td>${user.login}</td>
    </tr>
    <tr>
        <td>EMAIL</td>
        <td>${user.email}</td>
    </tr>
</table>
</body>
</html>
