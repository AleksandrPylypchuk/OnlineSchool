<!DOCTYPE html>
<html>
<head>
  <title>Список студентів</title>
</head>
<body>
<h1>Список студентів</h1>
<table>
  <thead>
  <tr>
    <th>Ім'я</th>
    <th>Прізвище</th>
    <th>Група</th>
  </tr>
  </thead>
  <tbody>
  <tr th:each="student : ${students}">
    <td th:text="${student.firstName}"></td>
    <td th:text="${student.lastName}"></td>
    <td th:text="${student.group}"></td>
  </tr>
  </tbody>
</table>
</body>
</html>
