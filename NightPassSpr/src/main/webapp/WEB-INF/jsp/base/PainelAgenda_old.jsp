<%@ page language="java" contentType="text/html"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:template
title="NightPass"
cssProprio="/resources/css/PainelEstabelecimento.css"
jsProprio="/resources/js/Agenda.js">

	<section id="signUpContainer">

	<h1 class="destaque1">${msg}</h1>

	<span class="principal"> Voc� est� na agenda --> ${EstabelecimentoAtu.PSJ_CODIGO.psjNome} </span><br><br>

		<table>
			<tr style="color: red">
				<th>DATA / ABERTURA</th>
				<th>DESCRI��O</th>
				<th>PRESEN�A</th>
			</tr>

			<c:forEach var="n" items="${AgendaAtu}">

				<tr style="color: red">
					<td><fmt:formatDate pattern="dd/MM/YYYY HH:mm"
							value="${n.ageData}" /></td>
					<td>${n.ageDetalhes}</td>

					<%-- Realiza a busca para ver se a pessoa logada j� marcou presen�a --%>

					<!-- Por padr�o o bot�o � para marcar presen�a -->
					<c:url value="/presenca/${n.ageCodigo}" var="marcar" />

					<c:set var="selNaoInformado" value="selected" />

					<c:forEach var="p" items="${ListaPresenca}">
						<c:if test="${p.preAgenda.ageCodigo == n.ageCodigo}">
							<td hidden="true" id="statusPresenca">${p.status}</td>
						</c:if>
					</c:forEach>

					<td>
							<select name="selPresenca" id="selPresenca">
								<option value="VOU" id="statusVou"> VOU </option>
								<option value="N�O VOU" id="statusNaoVou">N�O VOU </option>
								<option value="N�O INFORMADO" id="statusNaoInformado">N�O INFORMADO </option>
							</select>
					<td>
						 <form:form action="${marcar}" method="get">
							<button class="buttonfmt" type="submit">Marcar</button>
						</form:form>
					</td>

				</tr>

			</c:forEach>

		</table>

	</section>

</tags:template>