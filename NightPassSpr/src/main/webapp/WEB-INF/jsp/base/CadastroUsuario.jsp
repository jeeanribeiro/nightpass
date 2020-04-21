<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<tags:template 
title="NightPass"
cssProprio="/resources/css/CadastroUsuario.css"
jsProprio="CadastroUsuario.js">

  <section id='signUpContainer'>
  
    <h1 class="destaque1">${msg}</h1>

 	<c:url value="${action}" var="urlfinal"/>

    <form:form  modelAttribute="NovoUsuario" action="${urlfinal}" method="post" id="signUpForm">
    
      <form:input path="nome" required="true" type="text" name="nome" value="${usuarioLog.nome}" placeholder="Nome" maxlength="40"/>
      <form:input path="sobrenome" value="${usuarioLog.sobrenome}" required="true" type="text" name="sobrenome" placeholder="Sobrenome" maxlength="100"/>
      <input name="dataNasc"  
      value="<fmt:formatDate pattern="yyyy-MM-dd" value ="${usuarioLog.dataNasc.getTime()}"/>" required type="date" placeholder="Data de nascimento"/>
      <form:input path="rg" value="${usuarioLog.rg}" required="true" type="tel" name="rg" placeholder="RG" maxlength="15"/>
      <form:input path="rgOrgaoEmissor" value="${usuarioLog.rgOrgaoEmissor}" required="true" type="text" name="rgOrgaoEmissor" id="rgEmitter" placeholder="Orgão emissor" maxlength="15"/>
      <form:select path="rgEstadoEmissor" id="rgEstado" name="rgEstadoEmissor" placeholder="RG Estado">
      	<form:option  value="${usuarioLog.rgEstadoEmissor}" itemlable="${usuarioLog.rgEstadoEmissor}" selected="true" />
      	<form:option  value="AC" itemlable="AC"/>
        <form:option  value="AL" itemlable="AL" />
        <form:option  value="AP" itemlable="AP" />
        <form:option  value="AM" itemlable="AM" />
        <form:option  value="BA" itemlable="BA" />
        <form:option  value="CE" itemlable="CE" />
        <form:option  value="DF" itemlable="DF" />
        <form:option  value="ES" itemlable="ES" />
        <form:option  value="GO" itemlable="GO" />
        <form:option  value="MA" itemlable="MA" />
        <form:option  value="MT" itemlable="MT" />
        <form:option  value="MS" itemlable="MS" />
        <form:option  value="MG" itemlable="MG" />
        <form:option  value="PA" itemlable="PA" />
        <form:option  value="PB" itemlable="PB" />
        <form:option  value="PR" itemlable="PR" />
        <form:option  value="PE" itemlable="PE" />
        <form:option  value="PI" itemlable="PI" />
        <form:option  value="RJ" itemlable="RJ" />
        <form:option  value="RN" itemlable="RN" />
        <form:option  value="RS" itemlable="RS"/>
        <form:option  value="RO" itemlable="RO"/>
        <form:option  value="RR" itemlable="RR"/>
        <form:option  value="SC" itemlable="SC"/>
        <form:option  value="SP" itemlable="SP"/>
        <form:option  value="SE" itemlable="SE"/>
        <form:option  value="TO" itemlable="TO"/>
      </form:select>
      <input required type="tel" name="cpf" value="${usuarioLog.cpf}" placeholder="CPF" maxlength="11">
      <form:select path="sexo" id="sexo" name="sexo" placeholder="Sexo">
       <form:option value="${usuarioLog.sexo}" itemlable="${usuarioLog.sexo}" selected="true" />
       <form:option value="M" itemlable="Masculino"/>
       <form:option value="F" itemlable="Feminino"/>
       <form:option value="O" itemlable="Outros"/>
      </form:select>
      <form:input path="email" value="${usuarioLog.email}" required="true" type="email" name="email" placeholder="E-mail" maxlength="100"/>
      <input required type="tel" value="${usuarioLog.telCelular}" name="telCelular" placeholder="Número do celular" maxlength="15">
      <form:input path="senha" required="true" type="password" name="senha" placeholder="Senha" minlength="8" maxlength="40"/>
      <input required type="password" name="confirmarSenha" placeholder="Confirmar senha" minlength="8" maxlength="40">
      <button type="submit">${btnNome}</button>
    </form:form>
  </section>
  
</tags:template>