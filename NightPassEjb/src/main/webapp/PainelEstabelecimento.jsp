<%@ page language="java" contentType="text/html"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang='pt'>
<head>
<meta charset="ISO-8859-1">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<meta http-equiv='X-UA-Compatible' content='ie=edge'>
<link rel="apple-touch-icon" sizes="180x180" href="resources/imgs/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="resources/imgs/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="resources/imgs/favicon-16x16.png">
<link rel="manifest" href="resources/imgs/site.webmanifest">
<link rel='stylesheet' href='resources/css/global.css'>
<link rel="stylesheet" href="resources/css/PainelEstabelecimento.css">
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.min.js'></script>
<title>Painel Estabelecimento</title>
</head>
<body>

	<header>
	
	<c:if test="${statusEstab=='inexiste'}">
	<h1 class='titulopadrao'>Não Existe estabelecimento cadastrado</h1>
	</c:if>
		
	</header>
	
	<section id="signUpContainer">
	<h2 class="destaque1"> ${PJCadastrada} </h2>
		
		<form id="CadEstabelecimento" action="AdmEstabelecimentoServlet" method="post">
	
			<label class="fontepadrao">Horário de Abertura:</label>
			<input placeholder="" required type="time" name="estabertura" 
			value="<fmt:formatDate pattern = "HH:mm" value = "${estabelecimentopj.estAbertura.getTime()}" />">
			<br>

			<label class="fontepadrao textolongo">Horário de Fechamento:</label>
			<input placeholder="" required type="time" name="estfechamento"
			value="<fmt:formatDate pattern = "HH:mm" value = "${estabelecimentopj.estFechamento.getTime()}" />">
			<br>

			<label class="fontepadrao">Descrição do Estabelecimento:</label><br>
			<textarea name="estdescricao" rows="25" cols="80" maxlength="4000">${estabelecimentopj.estDescricao}</textarea><br>
			
			<input type="hidden" name="acao" value="alterar">
			<button type="submit">Atualizar</button>
			<button type="button" onclick="window.location.href='PainelGestorPJ.jsp'">Voltar</button>
		</form>
	</section>
	
			<input placeholder="CNPJ" required type="tel" name="cnpj" maxlength="14">
			<select id="estadoCom" name="estadoCom">
				<option value="RO">RO</option>
				<option value="SE">SE</option>
				<option value="TO">TO</option>
			</select>
			<input placeholder="E-mail" required type="email" name="email" maxlength="100">
	
</body>
</html>
