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
  <form action="/login" method="post">
    <input type="text" name="email" placeholder="EMAIL">eamil<br>
    <input type="password" name="password" placeholder="PASSWORD"><br>
    <input type="submit" value="Login">
  </form>
  <%
    if (session.getAttribute("您好：")!=null){
      out.println(session.getAttribute("您好："));
    }else {
      out.println();
    }
  %>
  </body>
</html>
