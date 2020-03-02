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
<title>Busca de Pessoa Juridica</title>
</head>
<body>
	<form action="pjuridica" method="get">
		<input type="text" placeholder="Nome" name="nome" >
		<input type="submit" value="Buscar">
	</form>
	<h2>Resultados</h2>
	<ul>
		<c:forEach items="${resultado}" var="r">
			<li>${r.psjNome} " " ${r.psjCPF}</li>
		</c:forEach>
	</ul>
</body>
</html>
