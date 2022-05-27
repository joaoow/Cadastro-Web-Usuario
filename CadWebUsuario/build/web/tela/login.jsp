<%-- 
    Document   : index
    Created on : 30/03/2022, 08:44:36
    Author     : sala305b
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="../UsuarioServlet" method="POST">
            <table style="background-color: #f7f7f7; " cellpadding="4">
                <tr>
                    <td colspan="2">
                        <h2 style="text-align: center;font-family:'Arial'; ">Log in</h2>                     
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="text" id="txtlogin"
                               style="size:30px;width: 260px; font-family:'Arial'; height: 22px;"
                               name="login"
                               placeholder="Username"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="password" id="pwdlogin"
                               style="size:30px;width: 260px; font-family:'Arial'; height: 22px;"
                               name="senha"
                               placeholder="Password"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" style="font-size:18px; color: white; font-family:'Arial'; width: 268px; height: 40px;
                               background-color: #347ab7; " value="login">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input name="Remember me"  type="checkbox" id="chkRemember" value="RM"/> 
                        <label for="chkRemember" style="font-size: 15px; font-family:'Arial';">Remember me</label>
                    </td>
                    <td>
                        <a href="index.html" style="font-size: 15px; color: #347ab7; font-family:'Arial'; ">Forgot Password?</a>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>