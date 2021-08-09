<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Create</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h1>Add new product</h1>
    <form action="/?action=create" method="post">
        <table>
            <tr>
                <th>Name</th>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <th>Price</th>
                <td><input type="number" name="price"></td>
            </tr>
            <tr>
                <th>Amount</th>
                <td><input type="number" name="amount"></td>
            </tr>
            <tr>
                <th>Color</th>
                <td><input type="text" name="color"></td>
            </tr>
            <tr>
                <th>Description</th>
                <td><textarea name="description" cols="30" rows="10"></textarea></td>
            </tr>
            <tr>
                <th>Category</th>
                <td><select name="category">
                    <c:forEach var="categories" items="${categories}">
                        <option value="${categories.id}">${categories.name}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <th>
                    <button type="submit" class="btn btn-primary"> Create</button>
                    <a href="/" class="btn btn-warning"> Back </a>
                </th>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
