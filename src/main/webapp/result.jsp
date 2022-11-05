<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="lastResultHandler" scope="application" class="com.example.weblab2.utils.LastResultHandler"/>

<html>
<head>
    <title>Результат</title>

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/table.css">
    <link rel="stylesheet" href="css/animation.css">
</head>
<body>
<h1 style="text-align: center">Результат выстрела</h1>

<table class="styled-table" id="result-table">
    <thead>
    <tr>
        <th>X</th>
        <th>Y</th>
        <th>R</th>
        <th>Результат</th>
        <th>Текущее время</th>
        <th>Время выполнения (µs)</th>
    </tr>
    </thead>
    <tbody>
    <%=lastResultHandler.formatShoot()%>
    </tbody>
</table>

<div style="text-align: center;
            margin-top: 20px;">
    <a href="index.jsp">Отправить еще один запрос</a>
</div>
</body>
</html>
