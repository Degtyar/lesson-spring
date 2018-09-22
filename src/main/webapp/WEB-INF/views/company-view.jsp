<%--
  Created by IntelliJ IDEA.
  User: kostyadegtyar
  Date: 21.09.2018
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Company-view</title>
</head>
<body>
<c:set var="company" value="${company}"/>
<table width="100%" cellspacing="10" cellpadding="10" border="1" style="...">
    <tr>
        <th colspan="5" align="center">
            COMPANY
        </th>
    </tr>
    <tr>
        <td>ID</td>
        <td>${company.id}</td>
    </tr>
    <tr>
        <td>NAME</td>
        <td>${company.name}</td>
    </tr>
</table>
</body>
</html>