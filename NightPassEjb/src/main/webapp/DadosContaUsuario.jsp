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
 

	<h2> ${CadastroAtu} </h2> 
 
	<form action="CadastroUsuarioServlet" method="post">
	
	<label>Nome: </label>
	<input type="text" name="nome" value="${PFisicalog.nome}" maxlength="40">
	<p>
	 
	<label>Sobrenome: </label>
	<input type="text" name="sobrenome" value="${PFisicalog.sobrenome}" maxlength="100">
	<p>
	
	<label>Data de Nascimento: </label>
	
	<input type="date" name="dtNascimento" value="${PFisicalog.getDtNascimentoFmt()}">
	
	<p>
	
	<label>RG nº: </label>
	<input type="text" name="rg" value="${PFisicalog.rg}" maxlength="15">
	<p>
	
	<label>RG - Orgão Emissor: </label>
	<input type="text" name="rgOrgaoEmissor" value="${PFisicalog.rgOrgaoEmissor}" maxlength="15">
	<p>
	 
	<label>RG - Estado: </label>
	<input type="text" name="rgEstado" value="${PFisicalog.rgEstadoEmissor}" maxlength="15">
	<p>

	<label>CPF: </label>
	<input type="number" disabled="disabled" name="cpf" value="${PFisicalog.cpf}" maxlength="11">
	<p>

	<label>SEXO: </label>
	<input type="radio" name="sexo" value="M" ${sexoM}>
	<label for="M"> M </label>
	<input type="radio" name="sexo" value="F" ${sexoF}>
	<label for="F"> F </label>
	<input type="radio" name="sexo" value="O" ${sexoO}>
	<label for="O"> Prefiro não Informar </label>
	<p>

	<label>Tel. Celular: </label>
	<input type="number" name="telCelular" value="${PFisicalog.telCelular}" maxlength="15">
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
	<input type="email" name="email" value="${PFisicalog.email}" maxlength="100">
	<p>

	<label>Senha: </label>
	<input type="text" name="senha" value="${PFisicalog.senha}" maxlength="40">
	<p>

	<input type="submit" name="acao" value="Atualizar Dados">
	
	<input type="submit" name="acao" value="Remover Conta">
	<p>
	
	<button type="button" onclick="window.location.href='PainelPrincipal.jsp'">Voltar para Painel</button>
	
	</form>


</body>
</html>