<%@ page language="java" contentType="text/html"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:template 
title="NightPass"
cssProprio="/resources/css/PainelAgenda.css"
jsProprio="/resources/js/Agenda.js">
	
	<section id="signUpContainer">
	
	<h1 class="destaque1">${msg}</h1>
	
	<span class="principal"> Você está na agenda --> ${EstabelecimentoAtu.PSJ_CODIGO.psjNome} </span><br><br>

		<table>
			<tr style="color: red">
				<th>DATA / ABERTURA</th>
				<th>DESCRIÇÃO</th>
				<th>PRESENÇA</th>
			</tr>

			<c:forEach var="n" items="${ListaPessoaAgenda}">

				<tr style="color: red">
					<td><fmt:formatDate pattern="dd/MM/YYYY HH:mm"
							value="${n.agenda.ageData}" /></td>
					<td>${n.agenda.ageDetalhes}</td>
					<td>

						<div class="dropdown">
							<button class="dropbtn">${n.presenca.status}</button>
							<div class="dropdown-content">

							<c:url value="/presenca" var="action" />
							
							<form:form modelAttribute="Presenca"
							action="${action}" method="POST">
							<input type="hidden" name="Estcodigo" value="${n.agenda.getEstabelecimentoAge().estcodigo}"/>
							<input type="hidden" name="status" value="QUERO IR"/>
							<input type="hidden" name="preAgenda.ageCodigo" value="${n.agenda.ageCodigo}"/>
							<input type="hidden" name="preCodigo" value="${n.presenca.preCodigo}"/>
							<input type="hidden" name="prePressoaFisica.codigo" value="${n.presenca.prePessoaFisica.codigo}"/>
							<input type="submit" value="QUERO IR">
							</form:form>

							<form:form modelAttribute="Presenca"
							action="${action}" method="POST">
							<input type="hidden" name="Estcodigo" value="${n.agenda.getEstabelecimentoAge().estcodigo}"/>
							<input type="hidden" name="status" value="NÃO QUERO IR"/>
							<input type="hidden" name="preAgenda.ageCodigo" value="${n.agenda.ageCodigo}"/>
							<input type="hidden" name="preCodigo" value="${n.presenca.preCodigo}"/>
							<input type="hidden" name="prePressoaFisica.codigo" value="${n.presenca.prePessoaFisica.codigo}"/>
							<input type="submit" value="NÃO QUERO IR">
							</form:form>

							</div>
						</div>

					</td>

				</tr>

			</c:forEach>

		</table>
	</section>
	

</tags:template>