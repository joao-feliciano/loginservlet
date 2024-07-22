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
    <title>Delete Book</title>
</head>
<body>
<h2>Delete Book</h2>
<p>Are you sure you want to delete the book "${book.title}" by ${book.author}?</p>
<form action="deleteBook" method="post">
    <input type="hidden" name="id" value="${param.id}">
    <input type="submit" value="Delete">
</form>
<a href="books">Back to List</a>
</body>
</html>