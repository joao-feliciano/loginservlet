<%--
  Created by IntelliJ IDEA.
  User: a898199
  Date: 7/21/2024
  Time: 8:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Book</title>
</head>
<body>
<h2>Edit Book</h2>
<form action="editBook" method="post">
    <input type="hidden" name="id" value="${param.id}">
    <label>Title:</label>
    <input type="text" name="title" value="${book.title}" required><br>
    <label>Author:</label>
    <input type="text" name="author" value="${book.author}" required><br>
    <label>Price:</label>
    <input type="number" step="0.01" name="price" value="${book.price}" required><br>
    <input type="submit" value="Update Book">
</form>
<a href="books">Back to List</a>
</body>
</html>
