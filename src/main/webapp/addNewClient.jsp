<%--
  Created by IntelliJ IDEA.
  User: Lucas
  Date: 07/07/2024
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Adding a New User</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f9;
      display: flex;
      align-items: center;
      justify-content: center;
      height: 100vh;
    }

    .container {
      border: 1px solid #ccc;
      border-radius: 8px;
      width: 25vw;
      height: 50vh;
      display: flex;
      flex-direction: column;
      align-items: center;
      padding: 20px;
    }

    input, button {
      width: 100%;
      padding: 10px;
      margin: 5px 0;
      box-sizing: border-box;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    button {
      color: white;
      background-color: blue;
      cursor: pointer;
    }

    label {
      margin-top: 10px;
    }
  </style>
</head>
<body>
<div class="container">
  <form action="addNewClient" method="post" style="width: 100%;">
    <h1 style="padding: 5px; text-align: center;">Add a New User</h1>
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required />
    <br/>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required />
    <br/>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required />
    <br/>
    <button type="submit">Add</button>
  </form>
</div>
</body>
</html>
