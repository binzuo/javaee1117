<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>edit page</title>
</head>
<body>
<h1>edit page</h1>
<form action="/book" method="post">
    <input type="hidden" name="actionB" value="update">
    <input type="hidden" name="id" value="${sessionScope.book.id}">
    <input type="text" name="title" placeholder="TITLE" value="${sessionScope.book.title}"><br>
    <input type="text" name="author" placeholder="AUTHOR" value="${sessionScope.book.author}"><br>
    <input type="text" name="publish" placeholder="PUBLISH" value="${sessionScope.book.publish}"><br>
    <input type="text" name="date" placeholder="DATE" value="${sessionScope.book.date}"><br>
    <input type="text" name="price" placeholder="PRICE" value="${sessionScope.book.price}"><br>
    <input type="text" name="amount" placeholder="AMOUNT" value="${sessionScope.book.amount}"><br>
    <input type="submit" value="SAVE">
</form>
</body>
</html>