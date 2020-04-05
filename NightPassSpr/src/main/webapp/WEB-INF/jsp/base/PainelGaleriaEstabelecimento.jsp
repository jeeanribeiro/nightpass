<%@ page language="java" contentType="text/html"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<tags:template 
title="NightPass - Galeria do Estabelecimento"
cssProprio="ajustar">

<%-- 	<img src="data:image/jpg;base64,${Fotog.getGaeFotoExibivel()}"/>
	<img src="data:image/jpg;base64,${Fotog.getGaeFotoExibivel()}"/>
 --%>	
 	
<%-- 		<c:forEach items="${teste22}" var="r" end="0">
		
		<img src="data:image/jpg;base64,${r.getGaeFotoExibivel()}"/>
		<h1>----------</h1>
		
		</c:forEach>
	
		<c:forEach items="${teste45}" var="r" end="0">
		
		<img src="data:image/jpg;base64,${r.getGaeFotoExibivel()}"/>
		<h1>----------</h1>
		
		</c:forEach> --%>

	<c:forEach items="${estabelecimento}" var="r">
		<h1 class="fontepadrao">----------</h1>
		<h1 class="fontepadrao">${r.getEstcodigo()}</h1>
		<h1 class="fontepadrao">${r.getEstDescricao()}</h1>
		<c:forEach items="${galeria}" var="g">
			<c:set var="est" value="${r.getEstcodigo()}" />
			<c:if test="${est == g.getGae_est_codigo().getEstcodigo()}">
				<c:set var="tipo" value="${g.getTga_codigo().getTgacodigo()}" />
				<c:if test="${tipo==1}">
					<h1 class="fontepadrao">-.-.-.-.-.-.-.-.-.-</h1>
					<h1 class="fontepadrao">${g.getGae_est_codigo().getEstcodigo()}</h1>
					<img src="data:image/jpg;base64,${g.getGaeFotoExibivel()}" />
					<h1 class="fontepadrao">-.-.-.-.-.-.-.-.-.-</h1>
				</c:if>
			</c:if>
		</c:forEach>
	</c:forEach>

</tags:template>