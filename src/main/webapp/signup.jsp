<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/17 0017
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>signup</title>
</head>
<body>
<form action="/user" method="post">
    <input type="hidden" name="actionA" value="register">
    <input type="text" name="email" placeholder="EMAIL" value="18310996173xiaozuo@gmail.com">email<br>
    <input type="password" name="password" placeholder="PASSEORD" value="xinabcd3388725">password<br>
    <select name="cities" multiple="multiple" >
        <option  value="Beijing" >Beijing</option>
        <option  value="Hengshui" selected="selected">Hengshui</option>
        <option  value="Qinhuangdao" >Qinhuangdao</option>
        <option  value="Xingtai">Xingtai</option>
    </select><br>
    <input type="checkbox" name="hobbies" value="Fofa">Fofa<br>
    <input type="checkbox" name="hobbies" value="Java" checked="checked">Java<br>
    <input type="checkbox" name="hobbies" value="English">English<br>
    <input type="checkbox" name="hobbies" value="Sky">Sky<br>
    <input type="submit" value="Sign Up">
</form>
</body>
</html>
