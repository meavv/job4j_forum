<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создание новой темы</title>
</head>
<form name='new' action="<c:url value='/new'/>" method='POST'>
    <table>
        <tr>
            <td><input type='text' name='id' value="${id}"></td>
        </tr>
        <tr>
            <td>name:</td>
            <td><input type='text' name='name' value="${post.name}"></td>
        </tr>
        <tr>
            <td>description:</td>
            <td><input type='text' name='description' value="${post.description}"/></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="submit" /></td>
        </tr>
    </table>
</form>
<body>
</body>
</html>
