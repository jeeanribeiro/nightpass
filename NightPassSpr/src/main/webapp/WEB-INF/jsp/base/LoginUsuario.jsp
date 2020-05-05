<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<tags:template 
title="NightPass"
cssProprio="/resources/css/LoginUsuario.css"
jsProprio="LoginUsuario.js">

  <section id='loginContainer'>
  
  	<h1 class="destaque1">${msg}</h1>
    <h1 class='logo'>NightPass</h1>
	<c:url value="/logar" var="action" />
	<form:form action="${action }" method="post" commandName="pessoaFisica" id='loginForm'>

	<form:input
		  path="email"
          type='text' 
          name="email" 
          value='jerson@uol.com'
          id='login' 
          placeholder='E-mail'
          pattern='/\d{3}\.\d{3}\.\d{3}\-|[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4})\w+/' />
    
    <form:input path="senha" type='password' name="senha"
     id='password' placeholder='Senha' minlength='8' value="senhajerson"/>

    <input type="submit" name="Entrar" value="Entrar">

	
	<br>
	<input style='display:inline-flex' type="checkbox" name="baseimagens" checked>
	<span style='color:red'>Usar Base Imagens Local Eclipse<br>(para efeito de desenvolvimento)</span>
	
                
    </form:form>
      
      <p>Não possui uma conta?
      <c:url value="/cadastrousuario" var="action" />
      <a href="${action}">Cadastre-se aqui!</a>
      </p>
      
  </section>

</tags:template>
