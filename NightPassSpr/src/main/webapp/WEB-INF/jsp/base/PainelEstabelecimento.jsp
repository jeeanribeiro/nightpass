<%@ page language="java" contentType="text/html"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:template
title="NightPass"
cssProprio="/resources/css/PainelEstabelecimento.css"
jsProprio="Ajustar">

	<section id="signUpContainer">

	<h1 class="destaque1">${msg}</h1>

	<span class="principal"> ${pJuridicaAtual.psjNome} </span><br><br>

		<c:url value="/painelestabelecimento" var="action" />

		<form:form modelAttribute="estabelecimento" id="CadEstabelecimento" action="${action}" method="post">

			<input name="estcodigo" value="${estabelecimento.estcodigo}" type="hidden"/>

			<label class="fontelabel">Horário de Abertura: </label>
			<input name="estAbertura" placeholder="" required type="time"
			value="<fmt:formatDate pattern="HH:mm" value = "${estabelecimento.estAbertura.getTime()}"/>">

			<label class="fontelabel">&nbsp;&nbsp; Horário de Fechamento: </label>
			<input name="estFechamento" placeholder="" required type="time"
			value="<fmt:formatDate pattern="HH:mm" value = "${estabelecimento.estFechamento.getTime()}"/>">

			<br>
			<label class="fontelabel"> Tipo de Estabelecimento: </label>
			<form:select path="tes_codigo.codigo" required="true" placeholder="Tipo Estabelecimento">
			<form:options items="${tpEstabelecimento}" itemValue="codigo" itemLabel="nome"/>
			</form:select>

			<br>
			<label class="fontelabel">Descrição do Estabelecimento:</label><br>
			<textarea name="estDescricao" rows="15" cols="80" maxlength="4000">${estabelecimento.estDescricao}</textarea>

			<br>
			<label class="fontelabel">Estilo de Musicas:</label><br>

				<c:forEach var="n" items="${estabelecimentoGenMusical}">

					<span class="padraodestaque">${n.nome}</span>

				</c:forEach>


			<br><br>
			<c:url value="/abreGaleria" var="voltar"/>
			<a class="buttonfmt" href="${voltar}">Galeria Estabelecimento</a>


			<br><br>
			<button class="buttonfmt" type="submit">Atualizar</button>

			<c:url value="/buscarTodasPJGestor" var="voltar"/>
			<a class="buttonfmt" href="${voltar}">Voltar</a>

		</form:form>

	</section>

</tags:template>