<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Users</title>
</head>
<body>
<div align="center">
    <h2>All users</h2>

    <table border="1" cellpadding="5">
        <tr>
            <th>Name</th>
            <th>Lastname</th>
            <th>age</th>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>${user.lastName}</td>
                <td>${user.age}</td>
                <td>
                    <a href="/users/edit?id=1">Edit</a>

                    <a href="/users/delete?id=3">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <h3><a href="/users/add">Add user</a></h3>
</div>
</body>
</html>