<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Пользователи</title>
</head>

<body>
<form action="<%=request.getContextPath()%>/create" method="post">
    <table>
        <tr>
            <td>Login:</td>
            <td>
                <label>
                    <input type="text" name="rows">
                </label>
            </td>
        <tr>
            <td><input type="submit" align="center" value="Submit"></td>
        </tr>

    </table>
</form>

</body>

</html>
