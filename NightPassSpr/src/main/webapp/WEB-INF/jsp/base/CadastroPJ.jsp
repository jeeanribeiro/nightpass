<!-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -->

<!DOCTYPE html>
<html lang='pt'>
<head>
<meta charset='UTF-8'>
<meta charset="ISO-8859-1">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<link rel="apple-touch-icon" sizes="180x180" href="imgs/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="resources/imgs/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="resources/imgs/favicon-16x16.png">
<link rel="manifest" href="resources/imgs/site.webmanifest">
<link rel="stylesheet" href="resources/css/global.css">
<link rel="stylesheet" href="resources/css/CadastroPJ.css">
<title>Cadastro PJ - NightPass</title>
</head>
<body>
	<section id="signUpContainer">
	<h2 class="destaque1"> ${PJCadastrada} </h2> 
		<form id="signUpForm" action="CadastroPJServlet" method="post">
			<input placeholder="Nome" required type="text" name="nome" maxlength="40">
			<input placeholder="CNPJ" required type="tel" name="cnpj" maxlength="14">
			<input placeholder="Telefone Comercial" required type="tel" name="telefoneCom" maxlength="15">
			<input placeholder="Endereço Comercial" required type="text" name="enderecoCom" maxlength="60">
			<input placeholder="Número Comercial" required type="tel" name="numeroCom" maxlength="10">
			<input placeholder="CEP Comercial" required type="tel" name="CepCom" maxlength="8">
			<input placeholder="Bairro Comercial" required type="text" name="bairroCom" maxlength="30">
			<input placeholder="Cidade Comercial" required type="text" name="cidadeCom" maxlength="30">
			<select id="estadoCom" name="estadoCom">
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
			<input placeholder="E-mail" required type="email" name="email" maxlength="100">
			<button type="submit">Cadastrar Pessoa Jurídica</button>
			<button type="button" onclick="window.location.href='PainelPrincipal.jsp'">Voltar para Painel</button>
		</form>
	</section>
</body>
</html>
