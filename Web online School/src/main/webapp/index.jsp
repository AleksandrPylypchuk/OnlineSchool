<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Список курсів</title>
</head>
<body>
<nav>
    <ul>
        <li><a href="/">Головна</a></li>
        <li><a href="/courses">Курси</a></li>
        <li><a href="/students">Студенти</a></li>
        <li><a href="/teachers">Викладачі</a></li>
    </ul>
</nav>
<h1>Список курсів</h1>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Назва курсу</th>
        <th>Викладач</th>
    </tr>
    </thead>
    <tbody>
    <tr th:each="course : ${courses}">
        <td><a th:href="@{/courses/{id}/details(id=${course.id})} th:text="${course.id}"></a></td>
        <td th:text="${course.name}"></td>
        <td th:text="${course.teacherName}"></td>
    </tr>
    </tbody>
</table>
</body>
</html>
