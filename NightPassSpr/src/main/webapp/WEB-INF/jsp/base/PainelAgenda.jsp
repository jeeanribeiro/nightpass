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
	
	<h1 class="destaque1">${msg}</h1>

	<span class="principal"> Você está na agenda --> ${EstabelecimentoAtu.PSJ_CODIGO.psjNome} </span><br><br>

		<table>
			<tr style="color: red">
				<th>DATA / ABERTURA</th>
				<th>DESCRIÇÃO</th>
				<th>PRESENÇA</th>
			</tr>

			<c:forEach var="n" items="${PresencaVer}">

				<tr style="color: red">
					<td><fmt:formatDate pattern="dd/MM/YYYY HH:mm"
							value="${n.preAgenda.ageData}" /></td>
					<td>${n.preAgenda.ageDetalhes}</td>
					<td>

						<div class="dropdown">
							<button class="dropbtn">${n.status}</button>
							<div class="dropdown-content">

							<c:url value="/presenca" var="action" />
							
							<form action="${action}" name="formbt" method="POST">
							<input type="hidden" name="status" value="QUERO IR"/>
							<input type="hidden" name="precodigo" value="${n.preCodigo}"/>
							<input type="submit" name="btnstatus" value="QUERO IR">
							</form>

							<form action="${action}" name="formbt" method="POST">
							<input type="hidden" name="status" value="NÃO QUERO IR"/>
							<input type="hidden" name="precodigo" value="${n.preCodigo}"/>
							<input type="submit" name="btnstatus" value="NÃO QUERO IR">
							</form>

							</div>
						</div>

					</td>

				</tr>

			</c:forEach>

		</table>

</tags:template>