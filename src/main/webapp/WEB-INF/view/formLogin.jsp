<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkentrada"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="${ linkentrada }" method="post">
        Login: <input type="text" name="login" id="">
        Senha: <input type="password" name="senha">
        <input type="submit" value="Enviar">
    	<input type="hidden" name="acao" value="Login">
    </form>
</body>
</html>