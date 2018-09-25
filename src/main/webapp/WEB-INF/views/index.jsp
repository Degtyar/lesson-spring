<%--
  Created by IntelliJ IDEA.
  User: konstantin
  Date: 18.09.2018
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>Spring Security</h1>
<h2>${message}</h2>

<form action="/logout" method="post">
    <input value="Logout" type="submit">
</form>