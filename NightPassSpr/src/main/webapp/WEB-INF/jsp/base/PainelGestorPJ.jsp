<%@ page language="java" contentType="text/html"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

	<form action="AdmEstabelecimentoServlet" method="post">		

	<select id="pJuridicaSel" name="pJuridicaSel">
	
		<c:forEach var="n" items="${PFisicalog.pfGestor}">
			
			<option value='${n.getpJuridica().getPsjCodigo()}'> 
			Cnpj: ${n.getpJuridica().getPsjCnpj()} -
			${n.getpJuridica().getPsjNome()} - ${n.rgePerfil} </option>
			
		</c:forEach>

	</select>
	<input type="hidden" name="acao" value="buscar">
	<button type="submit">Adm Estabelecimento</button>
	<p><button type="button" onclick="window.location.href='CadastroPJ.jsp'">Adicionar Novo</button>
	
	</form>


	</div>
	
	
</body>
</html>