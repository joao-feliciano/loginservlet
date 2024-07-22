<%--
  Created by IntelliJ IDEA.
  User: a898199
  Date: 7/21/2024
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Books</title>
</head>
<body>
<h2>List of Books</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Price</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.price}</td>
            <td>
                <a href="editBook.jsp?id=${book.id}">Edit</a>
                <a href="deleteBook?id=${book.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="addBook.jsp">Add New Book</a>
</body>
</html>