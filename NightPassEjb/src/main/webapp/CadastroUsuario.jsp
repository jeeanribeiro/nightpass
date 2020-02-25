<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<title>Tela de Cadastro de Usuário</title>
</head>

<body>
<%-- 

 TESTE INICIAL 

	<form action="CadastroUsuarioServlet" method="get">
	
	<input type="submit" id="buscar" value="buscar">
	
	</form>
	
	<ul>
	<c:forEach items="${resultado}" var="f">
	
		<li>${f.nome}  " " ${f.cpf} " " ${f.tipoUsuario} " " ${f.PSJ_CODIGO.psjNome} <br> ${f.PSJ_CODIGO.estabelecimento.estDescricao}</li><br>
	
	</c:forEach>
	</ul>



 --%>

	<form action="CadastroUsuarioServlet" method="post">
	
	<label>Nome: </label>
	<input type="text" name="nome" value="" maxlength="40">
	<p>
	 
	<label>Sobrenome: </label>
	<input type="text" name="sobrenome" value="" maxlength="100">
	<p>
	
	<label>Data de Nascimento: </label>
	
	<input type="date" name="dtNascimento" value="">
	<p>
	
	<label>RG nº: </label>
	<input type="text" name="rg" value="" maxlength="15">
	<p>
	
	<label>RG - Orgão Emissor: </label>
	<input type="text" name="rgOrgaoEmissor" value="" maxlength="15">
	<p>
	 
	<label>RG - Estado: </label>
	<input type="text" name="rgEstado" value="" maxlength="15">
	<p>

	<label>CPF: </label>
	<input type="number" name="cpf" value="" maxlength="11">
	<p>

	<label>SEXO: </label>
	<input type="radio" name="sexo" value="M">
	<label for="M"> M </label>
	<input type="radio" name="sexo" value="F">
	<label for="M"> F </label>
	<input type="radio" name="sexo" value="O">
	<label for="O"> Prefiro não Informar </label>
	<p>

	<label>Tel. Celular: </label>
	<input type="number" name="telCelular" value="" maxlength="15">
	<p>

	<!-- 

	<label>Tipo Usuario: </label>
	<input type="radio" name="tipoUsuario" value="Consumidor">
	<label for="Consumidor"> Consumidor </label>
	<input type="radio" name="tipoUsuario" value="Gestor PJ">
	<label for="Gestor PJ"> Gestor PJ </label>
	<p>

	 -->

	<label>E-mail: </label>
	<input type="email" name="email" value="" maxlength="100">
	<p>

	<label>Senha: </label>
	<input type="text" name="senha" value="" maxlength="40">
	<p>

	
	<input type="submit" name="cadUsuario" value="Cadastrar Usuário">
	
	</form>



</body>
</html>