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
            <td>
                <label hidden id="id">
                    <input type="text" name="id">
                </label>
            </td>

            <td>
                <label for="rows">Rows:</label>
                <input id="rows" type="text" name="rows">
            </td>

            <td>
                <label for="columns">Columns:</label>
                <input id="columns" type="text" name="columns">
            </td>

            <input type="submit" value="Save" class="save"/>

    </table>
</form>

</body>

</html>
