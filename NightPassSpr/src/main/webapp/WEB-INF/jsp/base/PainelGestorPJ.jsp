<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<tags:template
title="NightPass - Principal"
cssProprio="/resources/css/CatalogoEst.css"
jsProprio="/resources/js/CatalogoEst.js">


      <div class="baseprincipal">

            <div class="topo">

                <div class="LogoNPass">NigthPass</div>

                <!-- Button to Open the Modal -->

                <button type="button" class="HeadMenuRight"
                data-toggle="modal" data-target="#mdlogin">login</button>

            </div>

		<div class="corpo">
	
			<div class="boxListaPJ">
	
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
		
					<td>
					<c:url value="/painelestabelecimento/${n.getPsjCodigo()}" var="action" />
					<form:form action="${action}" method="get">
						<button class="buttonfmt" type="submit">Editar</button>
					</form:form>
					</td>
		
				</tr>
		
				</c:forEach>
		
			</table>
		
			<br>
			<c:url value="/cadastropj" var="voltar"/>
			<a class="buttonfmt" href="${voltar}">Adicionar Novo</a>
			<c:url value="/" var="voltar"/>
			<a class="buttonfmt" href="${voltar}">Voltar</a>
			
			</div>
	
		</div>

</div>

</tags:template>