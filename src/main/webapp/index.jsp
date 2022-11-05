<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.weblab2.utils.StorageFormatter" %>

<jsp:useBean id="hitStorage" scope="application" class="com.example.weblab2.utils.HitStorage"/>
<%@ taglib uri="WEB-INF/mytags.tld" prefix="m" %>

<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/table.css">
    <link rel="stylesheet" href="css/animation.css">

    <title>Лабораторная работа №2</title>
</head>

<body>
<!-- Шапка с ФИО, номером группы и вариантом -->
<header>
    <img src="img/itmo-logo.png" alt="ИТМО" style="width: 200px; height: 75px;">
    <h1>Шевчук Дмитрий</h1>
    <h2>P32312</h2>
    <h2>Вариант 66631212</h2>
</header>

<div class="main-app-div">
    <!-- Канвас для отрисовки фигур и точек -->
    <div class="main-app-div__element">
        <canvas class="bg-default" width="400" height="400" id="graph"></canvas>
    </div>

    <div class="main-app-div__element">

        <!-- Форма со значениями X, Y, R -->
        <form method="get" id="main-form" class="main-form" onsubmit="drawDot()"
              action="${pageContext.request.contextPath}/main">

            <!-- Переменная X -->
            <div class="x-button-press">
                <p class="variable-name">Значение X:</p>
                <input type="hidden" name="x" id="x-hidden-value">
                <div class="checkbox-picker">
                    <input type="checkbox" id="checkbox1" value="-4" onclick="setCheckedOnlyOneCheckbox(this.id)">
                    <label for="checkbox1">-4</label>
                </div>
                <div class="checkbox-picker">
                    <input type="checkbox" id="checkbox2" value="-3" onclick="setCheckedOnlyOneCheckbox(this.id)">
                    <label for="checkbox2">-3</label>
                </div>
                <div class="checkbox-picker">
                    <input type="checkbox" id="checkbox3" value="-2" onclick="setCheckedOnlyOneCheckbox(this.id)">
                    <label for="checkbox3">-2</label>
                </div>
                <div class="checkbox-picker">
                    <input type="checkbox" id="checkbox4" value="-1" onclick="setCheckedOnlyOneCheckbox(this.id)">
                    <label for="checkbox4">-1</label>
                </div>
                <div class="checkbox-picker">
                    <input type="checkbox" id="checkbox5" value="0" onclick="setCheckedOnlyOneCheckbox(this.id)">
                    <label for="checkbox5">0</label>
                </div>
                <div class="checkbox-picker">
                    <input type="checkbox" id="checkbox6" value="1" onclick="setCheckedOnlyOneCheckbox(this.id)">
                    <label for="checkbox6">1</label>
                </div>
                <div class="checkbox-picker">
                    <input type="checkbox" id="checkbox7" value="2" onclick="setCheckedOnlyOneCheckbox(this.id)">
                    <label for="checkbox7">2</label>
                </div>
                <div class="checkbox-picker">
                    <input type="checkbox" id="checkbox8" value="3" onclick="setCheckedOnlyOneCheckbox(this.id)">
                    <label for="checkbox8">3</label>
                </div>
                <div class="checkbox-picker">
                    <input type="checkbox" id="checkbox9" value="4" onclick="setCheckedOnlyOneCheckbox(this.id)">
                    <label for="checkbox9">4</label>
                </div>
            </div>

            <!-- Переменная Y -->
            <div class="y-text-input">
                <p class="variable-name">Значение Y:</p>
                <label>
                    <input type="text" name="y" id="y-value" placeholder="(-5 ... 5)">
                </label>
            </div>

            <!-- Переменная R -->
            <div class="r-checkbox-pick">
                <p class="variable-name">Значение R:</p>
                <label>
                    <input type="radio" id="radio1" name="r" value="1" onclick="isFormReadyToSent()">
                    1
                </label>
                <label>
                    <input type="radio" id="radio2" name="r" value="1.5" onclick="isFormReadyToSent()">
                    1.5
                </label>
                <label>
                    <input type="radio" id="radio3" name="r" value="2" onclick="isFormReadyToSent()">
                    2
                </label>
                <label>
                    <input type="radio" id="radio4" name="r" value="2.5" onclick="isFormReadyToSent()">
                    2.5
                </label>
                <label>
                    <input type="radio" id="radio5" name="r" value="3" onclick="isFormReadyToSent()">
                    3
                </label>
            </div>

            <div class="main-form-action-buttons">
                <button id="check-button" type="submit" disabled>Проверить</button>
                <button id="clear-form-button" type="reset">Очистить поля</button>
            </div>
        </form>

    </div>
</div>

<!-- Таблица с результатами -->
<div class="table-div">
    <h2 style="text-align: center">Таблица результатов</h2>
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
        <%=StorageFormatter.getRows(hitStorage)%>
        </tbody>
    </table>

    <!-- Кнопка для очистки данных -->
    <form action="${pageContext.request.contextPath}/main" style="text-align: center;
                                                                  margin-top: 10px;
                                                                  padding-bottom: 10px">
        <input type="hidden" name="q" value="history"/>
        <button type="submit">Очистить историю</button>
    </form>

</div>

<div>
    <m:today/>
</div>

<script src="js/script.js"></script>
<script src="js/canvas.js"></script>
<script src="js/validation.js"></script>
<script src="js/form_event_listener.js"></script>
<script src="js/key_listener.js"></script>

<!-- Скрипт для отрисовки попаданий на канвасе -->
<script>drawDots(<%=StorageFormatter.getJson(hitStorage)%>)</script>

</body>
</html>