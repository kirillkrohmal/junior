<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Пользователи</title>
</head>

<body>

<table border="1">

    <td>id:</td>
    <td>login:</td>
    <td>columns:</td>

    <c:forEach items="${hall}" var="hall" varStatus="status">
        <tr>
            <input type="hidden" value="id"/>
            <td>"${hall.id}"</td>
            <td>"${hall.rows}"</td>
            <td>"${hall.columns}"</td>
        </tr>
    </c:forEach>

</table

><ul>
    <li><a href="<%=request.getContextPath()%>/create">Добавить пользователя</a></li>
</ul>
</body>

</html>
