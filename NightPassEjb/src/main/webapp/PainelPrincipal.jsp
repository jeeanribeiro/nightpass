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

<h1>Ol�  ${PFisicalog.nome}</h1>



	<h1>Neste painel haver� informa��es para o usu�rio consumidor como suas fotos,
	sugest�es de estabelecimentos, op��es de busca de estabelecimentos, etc.</h1>
	<p>
	<p>

	
	<form action="CadastroUsuarioServlet" method="post">
	<input type="hidden" name="acao" value="conta">
	<h1><button type="submit">Acesse sua conta</button></h1> 
	</form>
	
	
	<p><p>
	<h1>neste mesmo painel haver� um bot�o para caso queira o usu�rio
		pule para outro painel destinado aos gestores onde ele poder� cadastrar
		uma pessoa jur�dica e ter� acesso as funcionalidades de pessoa
		jur�dica / estabelecimentos
		<button type="button" onclick="window.location.href='PainelGestorPJ.jsp'">Acesse aqui</button> </h1>


</body>
</html>