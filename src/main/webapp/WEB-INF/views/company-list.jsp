<%--
  Created by IntelliJ IDEA.
  User: konstantin
  Date: 21.09.2018
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Company-list</title>
</head>
<body>
<table width="100%" cellspacing="10" cellpadding="10" border="1" style="...">
    <tr>
        <th colspan="5" align="center">
            COMPANIES
        </th>
    </tr>
    <tr>
        <th width="60" nowrap="nowrap" align="center">№</th>
        <th width="60" nowrap="nowrap" align="center">ID</th>
        <th width="150" nowrap="nowrap" align="center">NAME</th>
        <th width="80" nowrap="nowrap" align="center">VIEW</th>
        <th width="80" nowrap="nowrap" align="center">EDIT</th>
        <th width="80" nowrap="nowrap" align="center">DELETE</th>
    </tr>
    <c:forEach var="company" items="${companies}" varStatus="status">
        <tr>
            <td align="center" nowrap="nowrap">${status.index + 1}</td>
            <td align="center">${company.id}</td>
            <td align="center">${company.name}</td>
            <td align="center" nowrap="nowrap">
                <a href="/company-view/${company.id}">view</a>
            </td>
            <td align="center" nowrap="nowrap">
                <a href="/company-edit/${company.id}">edit</a>
            </td>
            <td align="center" nowrap="nowrap">
                <a href="/company-delete/${company.id}">remove</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
