<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorator="layouts/default">
<head>
    <meta charset="UTF-8"/>
    <title>Lecture List</title>
    <link rel="stylesheet" th:href="@{/css/bootstrap.min.css}" />
</head>
<body>
<div class="container">
    <h1>Lecture List</h1>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Title</th>
            <th>Date</th>
            <th>Additional Materials</th>
        </tr>
        </thead>
        <tbody>
        <tr th:each="lecture : ${lectures}">
            <td th:text="${lecture.title}"></td>

                <ul>
                    <li th:each="material : ${lecture.additionalMaterials}" th:text="${material}"></li>
                </ul>
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
