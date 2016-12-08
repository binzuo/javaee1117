<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>signup</title>
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
                            $('#hint').text('电子邮件已注册，请直接登录。').css('color', 'red');
                        } else {
                            $('#hint').text('符合要求').css('color', 'blue');
                        }
                    }
                });
            });
        });
    </script>
</head>
<body>
<form action="/user" method="post">
    <input type="hidden" name="actionA" value="register">
    <input id="email" type="text" name="email" placeholder="EMAIL" value="18310996173xiaozuo@gmail.com">
    <small id="hint"></small><br>
    <input type="password" name="password" placeholder="PASSEORD" value="xinabcd3388725"><br>
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
