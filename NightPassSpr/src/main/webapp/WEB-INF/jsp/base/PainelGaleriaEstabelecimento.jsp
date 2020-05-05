<%@ page language="java" contentType="text/html"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<tags:template 
title="NightPass - Galeria do Estabelecimento"
cssProprio="/resources/css/PainelGaleriaEstabelecimento.css"
jsProprio="Ajustar">
	
	<c:url value="NovaFoto" var="NovaFoto"/>	
	<form action="${NovaFoto}" method="GET">
	<p><button class="buttonfmt" type="submit">Adicionar Novo</button>
	</form>
	
	<c:forEach items="${galeriaEstAtu}" var="r">
		<h1 class="fontelabel">_________________________________________________________</h1><br>
		<h1 class="fontelabel">${r.getGae_tga_codigo().getTganome()}</h1><p>
		<%--
		<img class='establishment-image' src="data:image/jpg;base64,${r.getGaeFotoExibivel()}" alt=""/>
		 --%>
		
	</c:forEach>

</tags:template>