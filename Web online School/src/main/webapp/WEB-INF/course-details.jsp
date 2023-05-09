<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Деталі курсу</title>
</head>
<body>
<h1>Деталі курсу</h1>
<table>
    <tbody>
    <tr>
        <td>ID:</td>
        <td th:text="${course.id}"></td>
    </tr>
    <tr>
        <td>Назва курсу:</td>
        <td th:text="${course.name}"></td>
    </tr>
    <tr>
        <td>Викладач:</td>
        <td th:text="${course.teacherName}"></td>
    </tr>
    <tr>
        <td>Опис курсу:</td>
        <td th:text="${course.description}"></td>
    </tr>
    </tbody>
</table>
<br>
<a href="/courses">Return for Course</a>
</body>
</html>

