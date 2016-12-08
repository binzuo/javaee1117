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
    <script src="JQuery/jquery-3.1.1.js"></script>
    <script>
      $(function () {
        $('#email').blur(function () {
          var email = $(this).val();
          $.ajax({
            url: '/user',
            type: 'post',
            data: {'actionA': 'emailWhetherExisted', 'email': email},
            dataType: 'json',
            success: function (result) {
              if (result ==true) {
                $('#hint').text('欢迎您').css('color', 'blue');
              } else {
                $('#hint').text('电子邮件未注册').css('color', 'red');
              }
            }
          });
        });
      });
    </script>
  </head>
  <body>
  <a href="signup.jsp">Sign Up</a>
  <form action="/user" method="post">
    <input type="hidden" name="actionA" value="login">
    <input id="email" type="text" name="email" placeholder="EMAIL" value="18310996173xiaozuo@gmail.com">
    <small id="hint"></small><br>
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
