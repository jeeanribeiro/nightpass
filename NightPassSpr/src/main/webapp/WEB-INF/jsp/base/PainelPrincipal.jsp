<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang='pt-br'>
<head>
<meta charset="ISO-8859-1">
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<link rel="apple-touch-icon" sizes="180x180" href="resources/imgs/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="resources/imgs/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="resources/imgs/favicon-16x16.png">
<link rel="manifest" href="resources/imgs/site.webmanifest">
<link rel="stylesheet" href="resources/css/global.css">
<link rel="stylesheet" href="resources/css/PainelPrincipal.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
<title>NightPass</title>
</head>
<body>
  <header>
    <nav>
      <div class='logo'>NightPass</div>
      <div class='logo'>Olá  ${usuarioLog.nome} </div>

	  		<c:url value="/cadastrousuario/dadosConta" var="conta" />
	  		<form:form action="${conta}" method="get">
		    <h1><input class='profile' type="submit" value="sua conta"></h1>
		    </form:form>
            
      <!-- Neste Formulário é aberto o painel de Gestor e carregadas as PJ vinculadas 
      ao gestor -->
      
      
     <c:url value="/buscarTodasPJGestor" var="action" />
	 <form:form action="${action }" method="get">
      
     <h1><input class='profile' type="submit" value="Acesso Gestor"></h1>
      
     </form:form>
      
      <div id='navMenu'>
        <a class='sign-out' href='/NightPassSpr/signout'><i class="fas fa-power-off"></i></a>
      </div>
    </nav>
  </header>

<section id='establishmentList'>

<c:forEach items="${estabelecimentos}" var="l" >

	<!-- Inicio bloco de estabelecimento -->
	
	<%--Inicia a variável fachada que contem a foto padrão de estabelecimento --%>
	<c:set var="fachada" value="resources/imgs/EstabelecimentoSemFoto.jpg"/>
	
    <div class='establishment'>
      
      <c:set var="codigoest" value="${l.estcodigo}"/>
            
      <div class="establishment-image-button">
      
      	<%--Atualmente apenas a primeira fotografia do estabelecimento é carregada --%>
      	<c:forEach items="${l.getGaleriaEst()}" var="g" end="0">
			<c:set var="fachada" value="data:image/jpg;base64,${g.getGaeFotoExibivel()}"/>
		</c:forEach>
		<img class='establishment-image' src="${fachada}" alt="" width="300" height="255"/>

      <button class="establishment-goto"><i class="fas fa-location-arrow"></i>Rotas</button>
      </div>
      
      
      <div class="establishment-info">
        <h4 class="establishment-title">${l.getPSJ_CODIGO().getPsjNome()}</h3>
        <p class="establishment-description">${l.getEstDescricao()}</p>
        <div class="establishment-time-distance">
          <span class="establishment-time-range"><i class="far fa-clock"></i>
          <fmt:formatDate pattern = "HH:mm" value = "${l.estAbertura.getTime()}" />
           - 
          <fmt:formatDate pattern = "HH:mm" value = "${l.estFechamento.getTime()}" />
          </span>
          <span class="establishment-distance"><i class="fas fa-map-marker-alt"></i>7.2km</span>
        </div>
      </div>
    </div>
	<!-- Fim bloco de estabelecimento -->

</c:forEach>
    
</section>
</body>
</html>
