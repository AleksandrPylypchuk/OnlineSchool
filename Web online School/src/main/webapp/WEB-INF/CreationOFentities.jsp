<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Створення студента</title>
</head>
<body>
<h1>Створення студента</h1>

<form method="post" th:action="@{/students}" th:object="${student}">
    <div>
        <label for="name">Ім'я:</label>
        <input type="text" id="name" name="name" th:field="*{name}">
    </div>

    <div>
        <label for="surname">Прізвище:</label>
        <input type="text" id="surname" name="surname" th:field="*{surname}">
    </div>

    <div>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" th:field="*{email}">
    </div>

    <button type="submit">Створити студента</button>
</form>

</body>
</html>
