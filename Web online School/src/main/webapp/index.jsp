<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Список курсів</title>
</head>
<body>
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
        <td th:text="${course.id}"></td>
        <td th:text="${course.name}"></td>
        <td th:text="${course.teacherName}"></td>
    </tr>
    </tbody>
</table>
</body>
</html>
