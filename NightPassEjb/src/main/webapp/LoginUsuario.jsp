<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang='pt'>
<head>
<meta charset='UTF-8'>
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<meta http-equiv='X-UA-Compatible' content='ie=edge'>
<link rel="apple-touch-icon" sizes="180x180" href="imgs/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="imgs/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="imgs/favicon-16x16.png">
<link rel="manifest" href="imgs/site.webmanifest">
<link rel='stylesheet' href='global.css'>
<link rel='stylesheet' href='LoginUsuario.css'>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.min.js'></script>
<title>Login - NightPass</title>
</head>
<body>
  <section id='loginContainer'>
      <h1 class='logo'>NightPass</h1>
      <form action='LoginUsuarioServlet' method='post' id='loginForm'>
        <input 
          type='text' 
          name='login' 
          id='login' 
          placeholder='E-mail ou CPF'
          pattern='/\d{3}\.\d{3}\.\d{3}\-|[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4})\w+/'
        >
        <input type='password' name='senha' id='password' placeholder='Senha' minlength='8'>
        <button type='submit' id='signIn'>Entrar</button>
      </form>
      <p>Não possui uma conta?
        <a href='CadastroUsuario.jsp'>Cadastre-se aqui!</a>
      </p>
  </section>
  <script src='LoginUsuario.js'></script>
</body>
</html>
