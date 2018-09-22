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
    <title>Category-view</title>
</head>
<body>
    <c:set var="cotegory" value="${category}"/>
    <table width="100%" cellspacing="10" cellpadding="10" border="1" style="...">
        <tr>
            <th colspan="5" align="center">
                CATEGORY
            </th>
        </tr>
        <tr>
            <td>ID</td>
            <td>${cotegory.id}</td>
        </tr>
        <tr>
            <td>NAME</td>
            <td>${cotegory.name}</td>
        </tr>
    </table>
</body>
</html>
