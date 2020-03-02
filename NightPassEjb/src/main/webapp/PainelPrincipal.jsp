<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Painel Principal</title>
</head>
<body>

<h1>Olá  ${PFisicalog.nome}</h1>



	<h1>Neste painel haverá informações para o usuário consumidor como suas fotos,
	sugestões de estabelecimentos, opções de busca de estabelecimentos, etc.</h1>
	<p>
	<p>

	
	<form action="CadastroUsuarioServlet" method="post">
	<input type="hidden" name="acao" value="conta">
	<h1><button type="submit">Acesse sua conta</button></h1> 
	</form>
	
	
	<p><p>
	<h1>neste mesmo painel haverá um botão para caso queira o usuário
		pule para outro painel destinado aos gestores onde ele poderá cadastrar
		uma pessoa jurídica e terá acesso as funcionalidades de pessoa
		jurídica / estabelecimentos
		<button type="button" onclick="window.location.href='PainelGestorPJ.jsp'">Acesse aqui</button> </h1>


</body>
</html>