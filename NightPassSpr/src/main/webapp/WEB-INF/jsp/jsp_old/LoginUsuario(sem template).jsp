<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang='pt'>
<head>
<meta charset='UTF-8'>
<meta charset="ISO-8859-1">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<meta http-equiv='X-UA-Compatible' content='ie=edge'>
<link rel="apple-touch-icon" sizes="180x180" href="<c:url value="/resources/imgs/apple-touch-icon.png"/>">
<link rel="icon" type="image/png" sizes="32x32" href="<c:url value="/resources/imgs/favicon-32x32.png"/>">
<link rel="icon" type="image/png" sizes="16x16" href="<c:url value="/resources/imgs/favicon-16x16.png"/>">
<link rel="manifest" href="<c:url value="/resources/imgs/site.webmanifest"/>">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/global.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/LoginUsuario.css"/>">
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.min.js'></script>
<title>Login - NightPass</title>
</head>
<body>
  <section id='loginContainer'>
    <h1 class='logo'>NightPass</h1>
	<c:url value="/logar" var="action" />
	<form:form action="${action }" method="post" commandName="pessoaFisica" id='loginForm'>
	<form:input
		  path="email"
          type='text'
          name="email"
          value='paula@uol.com'
          id='login'
          placeholder='E-mail'
          pattern='/\d{3}\.\d{3}\.\d{3}\-|[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4})\w+/' />
    <form:input path="senha" type='password' name="senha"
     id='password' placeholder='Senha' minlength='8' value="paulapaula"/>
    <input type="submit" name="Entrar" value="Entrar">
    </form:form>
      <p>N�o possui uma conta?
        <a href="CadastroUsuario.jsp">Cadastre-se aqui!</a>
      </p>
  </section>
  <script src="<c:url value="resources/js/LoginUsuario.js"/>"></script>
</body>
</html>
