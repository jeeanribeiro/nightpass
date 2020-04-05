<%@ page language="java" contentType="text/html"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang='pt'>
<head>
<meta charset="ISO-8859-1">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<link rel="apple-touch-icon" sizes="180x180" href="resources/imgs/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="resources/imgs/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="resources/imgs/favicon-16x16.png">
<link rel="manifest" href="resources/imgs/site.webmanifest">
<link rel="stylesheet" href="resources/css/global.css">
<title>Painel Gestor - NightPass</title>
</head>
<body>
	<p>
	<p>
	<div style="color: red">
		<h1>Você está vinculado as empresas: </h1><br>

	</div>
	
	<table>
		<tr style="color: red">
			<th> CNPJ </th>
			<th> NOME </th>
			<th> PERFIL </th>
		</tr>
	
		<c:forEach var="n" items="${usuarioLog.getpJuridicas()}">
		<tr style="color: red">
			<td> ${n.getPsjCnpj()} </td>
			<td> ${n.getPsjNome()} </td>
			<%-- <td> ${n.rgePerfil} </td> --%>

			<td>
			<c:url value="/painelestabelecimento/${n.getPsjCodigo()}" var="action" />
			<form:form action="${action}" method="get">
				<button class="buttonfmt" type="submit">Editar</button>
			</form:form>
			</td>
			
		</tr>	
		
		</c:forEach>

	</table>
	
	<p><button class="buttonfmt" type="button" onclick="window.location.href='CadastroPJ.jsp'">Adicionar Novo</button>
	<c:url value="/carregarListaEstabelecimentos" var="voltar"/>
	<a class="buttonfmt" href="${voltar}">Voltar</a>


	
</body>
</html>