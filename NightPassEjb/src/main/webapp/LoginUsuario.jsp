<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Login do Usuario</title>
</head>
<body>

	<h1>${cadastroRealizado}</h1>
	 
	<form action="LoginUsuarioServlet" method="post">
	
	<label>Digite seu email:</label>
	<input type="email" name="email">
	
	<label>Senha:</label>
	<input type="password" name="senha">
	
	<input type="submit" name="Entrar">
		
	</form>
	<p>
	
	<h1>${resultado}</h1>
	
	<h1><a href="CadastroUsuario.jsp">Não possi cadastro click aqui</a></h1>

</body>
</html>