<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Pessoa Jurídica</title>
</head>
<body>

	<H1>Essa Pessoa Jurídica ficará vinculada ao Usuário ${PFisicalog.nome}</H1>
	
	<form action="CadastroPJServlet" method="post">
	
	<label>Nome: </label>
	<input type="text" name="nome" value="" maxlength="40">
	<p>
	 
	<label>CNPJ: </label>
	<input type="number" name="cnpj" value="" maxlength="14">
	<p>

	<label>Tel. Comercial: </label>
	<input type="number" name="telefoneCom" value="" maxlength="15">
	<p>

	<label>Endereço Comercial: </label>
	<input type="text" name="enderecoCom" value="" maxlength="60">
	<p>
	
	<label>Numero: </label>
	<input type="number" name="numeroCom" value="" maxlength="10">
	<p>

	<label>Cep.: </label>
	<input type="number" name="CepCom" value="" maxlength="8">
	<p>
	
	<label>Bairro: </label>
	<input type="text" name="bairroCom" value="" maxlength="30">
	<p>

	<label>Cidade: </label>
	<input type="text" name="cidadeCom" value="" maxlength="30">
	<p>
	
	<label>Estado: </label>
	<input type="text" name="estadoCom" value="" maxlength="30">
	<p>
	
	<label>E-mail: </label>
	<input type="email" name="email" value="" maxlength="100">
	<p>
	
	
	<input type="submit" name="cadastroPJ" value="Cadastrar Pessoa Jurídica">
	
	</form>




</body>
</html>