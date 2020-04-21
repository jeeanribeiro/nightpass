<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<tags:template 
title="NightPass"
cssProprio="/resources/css/CadastroPJ.css"
jsProprio="Ajustar">

	<c:url value="${action}" var="urlfinal" />
	
    <section id="signUpContainer">
	<h1 class="destaque1">${msg}</h1>
		<form:form  modelAttribute="pJuridicaNova" action="${urlfinal}" method="post" id="signUpForm">
	
			<input placeholder="Nome" required type="text" name="psjNome" maxlength="40">
			<input placeholder="CNPJ" required type="tel" name="psjCnpj" maxlength="14">
			<input placeholder="Telefone Comercial" required type="tel" name="psjTelComercial" maxlength="15">
			<input placeholder="Endereço Comercial" required type="text" name="psjEnderecoCom" maxlength="60">
			<input placeholder="Número Comercial" required type="tel" name="psjNumeroCom" maxlength="10">
			<input placeholder="CEP Comercial" required type="tel" name="psjCepCom" maxlength="8">
			<input placeholder="Bairro Comercial" required type="text" name="psjBairroCom" maxlength="30">
			<input placeholder="Cidade Comercial" required type="text" name="psjCidadeCom" maxlength="30">
			<select id="estadoCom" name="psjEstadoCom">
				<option value="AC">AC</option>
				<option value="AL">AL</option>
				<option value="AP">AP</option>
				<option value="AM">AM</option>
				<option value="BA">BA</option>
				<option value="CE">CE</option>
				<option value="DF">DF</option>
				<option value="ES">ES</option>
				<option value="GO">GO</option>
				<option value="MA">MA</option>
				<option value="MT">MT</option>
				<option value="MS">MS</option>
				<option value="MG">MG</option>
				<option value="PA">PA</option>
				<option value="PB">PB</option>
				<option value="PR">PR</option>
				<option value="PE">PE</option>
				<option value="PI">PI</option>
				<option value="RJ">RJ</option>
				<option value="RN">RN</option>
				<option value="RS">RS</option>
				<option value="RO">RO</option>
				<option value="RR">RR</option>
				<option value="SC">SC</option>
				<option value="SP">SP</option>
				<option value="SE">SE</option>
				<option value="TO">TO</option>
			</select>
			<input placeholder="E-mail" required type="email" name="psjEmail" maxlength="100">
			<button type="submit">Cadastrar Pessoa Jurídica</button>

			<c:url value="/buscarTodasPJGestor" var="voltar" />
			<button type="button" onclick="window.location.href='${voltar}'">Voltar
				para Painel</button>


		</form:form>
		
		
	</section>
	
</tags:template>