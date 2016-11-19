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
<%=(session.getAttribute("email") != null) ? session.getAttribute("email") : ""%>
<%=session.getAttribute("welcome")%><br>
<a href="/logout">Loug Out</a>

</body>
</html>
