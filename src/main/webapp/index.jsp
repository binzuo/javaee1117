<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/17 0017
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index page</title>
  </head>
  <body>
  <a href="signup.jsp">Sign Up</a>
  <form action="/user" method="post">
    <input type="hidden" name="actionA" value="login">
    <input type="text" name="email" placeholder="EMAIL" value="18310996173xiaozuo@gmail.com">eamil<br>
    <input type="password" name="password" placeholder="PASSWORD" value="xinabcd3388725"><br>
    <input type="submit" value="Login">
  </form>
  <%
    if (request.getAttribute("message")!=null){
      out.println(request.getAttribute("message"));
    }else {
      out.println();
    }
  %>

  </body>
</html>
