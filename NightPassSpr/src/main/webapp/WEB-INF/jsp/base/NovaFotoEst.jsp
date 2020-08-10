<%@ page language="java" contentType="text/html"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<tags:template
title="NightPass - Galeria do Estabelecimento"
cssProprio="/resources/css/NovaFotoEst.css"
jsProprio="/resources/js/NovaFotoEst.js">

<%--

	<H1>oalha</H1>

	<p><label class="fileinput" for="file" style="cursor: pointer;">Upload Image</label></p>
	<input type="file"  accept=".jpeg, .jpg" name="image"
			id="file" onchange="loadFile(event)" style="display: none"/>

	<c:url value="GravaNovaFoto" var="GrvaNovaFoto"/>
		<br>
		<form action="GravaNovaFoto" method="POST"
		enctype="multipart/form-data">

		<input type="file" name="gaefoto"/>

		<p><button class="buttonfmt" type="submit">Enviar</button>
		</form>

	<p><img id="output" width="200" /></p> --%>

	<c:url value="GravaNovaFoto" var="GrvaNovaFoto"/>

		<form:form modelAttribute="galeriaEst" action="GravaNovaFoto" method="POST"
		enctype="multipart/form-data">

		<br>
		<label class="fontelabel">Selecione qual o local da Foto </label>
		<form:select path="gae_tga_codigo.tgacodigo" required="true">
		<form:options items="${tipoGaleria}" itemValue="tgacodigo" itemLabel="tganome"/>
		</form:select>

		<br><br>
		<label class="fontelabel">Selecione a Foto </label>
		<input type="file" onchange="loadFile(event)" name="uploadfoto"/>
		<button class="buttonfmt" type="submit">  Enviar</button>

		</form:form>

		<br><br>
		<p><img class='uploadFoto' id="uploadfoto" /></p>

</tags:template>