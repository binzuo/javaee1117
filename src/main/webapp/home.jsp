<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/17 0017
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>home page</title>
</head>
<body>
<c:if test="${sessionScope.email eq null}">
    <c:redirect url="index.jsp"/>
</c:if>
<h1>Home Page</h1>
<h1><b>南无地藏菩萨摩诃萨</b></h1>
<h1><b>南无阿弥陀佛</b></h1>
<h1><b>南无本师释迦牟尼佛</b></h1>
<h1><b>南无药师琉璃光如来</b></h1>
<h1><b>南无观世音菩萨摩诃萨</b></h1>
<h1><b>南无大势至菩萨摩诃萨</b></h1>
<h1><b>南无月光遍照菩萨摩诃萨</b></h1>
<h1><b>南无日光遍照菩萨摩诃萨</b></h1>
<form action="/book" method="post">
    <input type="hidden" name="actionB" value="register">
    <input type="text" name="title" placeholder="TITLE" value="title"><br>
    <input type="text" name="author" placeholder="AUTHOR" value="author..."><br>
    <input type="text" name="publish" placeholder="PUBLISH" value="publish..."><br>
    <input type="text" name="date" placeholder="DATE" value="2016-11-1"><br>
    <input type="text" name="price" placeholder="PRICE" value="50.00"><br>
    <input type="text" name="amount" placeholder="AMOUNT" value="10"><br>
    <input type="submit" value="ADD">
</form>
<h2>Books Lists</h2>
<table border="1" cellspacing="0">
    <c:choose>
        <c:when test="${sessionScope.books[0] eq null}">
            NO RECORD.
        </c:when>
        <c:otherwise>
            <tr>
                <th>ID</th>
                <th>TITLE</th>
                <th>AUTHOR</th>
                <th>PUBLISH</th>
                <th>DATE</th>
                <th>PRICE</th>
                <th>AMOUNT</th>
                <th colspan="2">OPERATION</th>
            </tr>
        </c:otherwise>
    </c:choose>
    <c:forEach var="book" items="${sessionScope.books}" varStatus="vs">
        <tr>
            <td>${vs.count}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.publish}</td>
            <td>${book.date}</td>
            <td>${book.price}</td>
            <td>${book.amount}</td>
            <td><a href="">MODIFY</a></td>
            <td><a href="">REMOVE</a></td>
        </tr>
    </c:forEach>

</table>
<%=(session.getAttribute("email") != null) ? session.getAttribute("email") : ""%>
<%=session.getAttribute("welcome")%><br>
<a href="/user?actionA=logout">Loug Out</a>

</body>
</html>
