<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang='pt'>
<head>
<meta charset='UTF-8'>
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<link rel="apple-touch-icon" sizes="180x180" href="imgs/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="imgs/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="imgs/favicon-16x16.png">
<link rel="manifest" href="imgs/site.webmanifest">
<link rel="stylesheet" href="global.css">
<title>Perfil Usuário - NightPass</title>
</head>
<body>
	<h2> ${CadastroAtu}</h2> 
	<form action="CadastroUsuarioServlet" method="post">
		<label>Nome: </label>
		<input type="text" name="nome" value="${PFisicalog.nome}" maxlength="40">

		<label>Sobrenome: </label>
		<input type="text" name="sobrenome" value="${PFisicalog.sobrenome}" maxlength="100">

		<label>Data de Nascimento: </label>
		<input type="date" name="dtNascimento" value="${PFisicalog.getDtNascimentoFmt()}">

		<label>RG n�: </label>
		<input type="text" name="rg" value="${PFisicalog.rg}" maxlength="15">

		<label>RG - Org�o Emissor: </label>
		<input type="text" name="rgOrgaoEmissor" value="${PFisicalog.rgOrgaoEmissor}" maxlength="15">

		<label>RG - Estado: </label>
		<input type="text" name="rgEstado" value="${PFisicalog.rgEstadoEmissor}" maxlength="15">

		<label>CPF: </label>
		<input type="number" disabled="disabled" name="cpf" value="${PFisicalog.cpf}" maxlength="11">

		<label>Sexo: </label>
		<input type="radio" name="sexo" value="M" ${sexoM}>
		<label for="M"> M </label>
		<input type="radio" name="sexo" value="F" ${sexoF}>
		<label for="F"> F </label>
		<input type="radio" name="sexo" value="O" ${sexoO}>
		<label for="O">Outro</label>

		<label>Telefone Celular: </label>
		<input type="number" name="telCelular" value="${PFisicalog.telCelular}" maxlength="15">

		<label>E-mail: </label>
		<input type="email" name="email" value="${PFisicalog.email}" maxlength="100">

		<label>Senha: </label>
		<input type="text" name="senha" value="${PFisicalog.senha}" maxlength="40">

		<input type="submit" name="acao" value="Atualizar Dados">
		<input type="submit" name="acao" value="Remover Conta">
		<button type="button" onclick="window.location.href='PainelPrincipal.jsp'">Voltar para Painel</button>
	</form>
</body>
</html>