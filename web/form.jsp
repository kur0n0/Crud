<%--
  Created by IntelliJ IDEA.
  User: vladkim
  Date: 26.01.2021
  Time: 00:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <c:if test="${user != null}">
    <form action="Update" method="post">
        </c:if>
        <c:if test="${user == null}">
        <form action="Insert" method="post">
            </c:if>
            <table>
                <caption>
                    <h2>
                        <c:if test="${user != null}">
                            Edit user
                        </c:if>
                        <c:if test="${user == null}">
                            Add New user
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${user != null}">
                    <input type="hidden" name="id" value="<c:out value='${user.getId()}' />" />
                </c:if>
                <tr>
                    <th>Name </th>
                    <td>
                        <input type="text" name="Name"
                               value="<c:out value='${user.getName()}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Surname </th>
                    <td>
                        <input type="text" name="Surname"
                               value="<c:out value='${user.getSurname()}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Age </th>
                    <td>
                        <input type="text" name="Age"
                               value="<c:out value='${user.getAge()}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <input type="submit" />
                    </td>
                </tr>
            </table>
        </form>
</body>
</html>
