<%--
  Created by IntelliJ IDEA.
  User: vladkim
  Date: 17.01.2021
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script
            src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
            crossorigin="anonymous"></script>
    <title>Title</title>
</head>
<body>
<div align="center">
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
                <td><a href="/Crud/Edit">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
    <form method="post" action="${pageContext.request.contextPath}/Edit">
        <input placeholder="Id" id="id"><br>
        <input placeholder="Name" name="Name" id="name"><br>
        <input placeholder="Surname" name="Surname" id="surname"><br>
        <input placeholder="Age" name="Age" id="age"><br>
        <p><input type="submit" value="Edit">
    </form>
</div>
</body>
</html>
