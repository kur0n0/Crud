<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
</head>
<body>
<div align="center">
    <h1>List of users</h1>
    <table>
        <tr>
            <th>id</th>>
            <th>Name</th>
            <th>Age</th>
            <th>Surname</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${allUsers}" var="user">
            <tr>
                <td><c:out value="${user.getId()}"/></td>
                <td><c:out value="${user.getName()}" /></td>
                <td><c:out value="${user.getAge()}"/></td>
                <td><c:out value="${user.getSurname()}"/></td>
                <td><a href="/Crud/Delete?id=<c:out value='${user.getId()}'/>">Delete</a></td>
                <td><a href="/Crud/Edit?id=<c:out value='${user.getId()}'/>">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<p><a href="${pageContext.request.contextPath}/AllUsers">All users</a></p>
<p><a href="${pageContext.request.contextPath}/Add">Add user</a></p>
<%--    <form method="post" action="${pageContext.request.contextPath}/Edit">--%>
<%--        <input placeholder="Id" id="id"><br>--%>
<%--        <input placeholder="Name" name="Name" id="name"><br>--%>
<%--        <input placeholder="Surname" name="Surname" id="surname"><br>--%>
<%--        <input placeholder="Age" name="Age" id="age"><br>--%>
<%--        <p><input type="submit" value="Edit"></p>--%>
<%--    </form>--%>
</body>
</html>