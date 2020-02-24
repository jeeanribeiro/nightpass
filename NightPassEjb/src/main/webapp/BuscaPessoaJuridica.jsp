<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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