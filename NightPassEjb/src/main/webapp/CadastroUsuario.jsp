<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt">
<head>
<meta charset="UTF-8">
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="apple-touch-icon" sizes="180x180" href="resources/imgs/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="resources/imgs/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="resources/imgs/favicon-16x16.png">
<link rel="manifest" href="resources/imgs/site.webmanifest">
<link rel="stylesheet" href="resources/css/global.css">
<link rel="stylesheet" href="resources/css/CadastroUsuario.css">
<title>Cadastro - NightPass</title>
</head>
<body>
  <section id='signUpContainer'>
    <form action="CadastroUsuarioServlet" method="post" id="signUpForm">
      <input required type="text" name="nome" placeholder="Nome" maxlength="40">
      <input required type="text" name="sobrenome" placeholder="Sobrenome" maxlength="100">
      <input required type="date" name="dtNascimento" placeholder="Data de nascimento">
      <input required type="tel" name="rg" placeholder="RG" maxlength="15">
      <input required type="text" name="rgOrgaoEmissor" id="rgEmitter" placeholder="Org�o emissor" maxlength="15">
      <select id="rgEstado" name="rgEstado">
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
      <input required type="tel" name="cpf" placeholder="CPF" maxlength="11">
      <select id="sexo" name="sexo">
        <option value="M">Masculino</option>
        <option value="F">Feminino</option>
        <option value="O">Outros</option>
      </select>
      <input required type="email" name="email" placeholder="E-mail" maxlength="100">
      <input required type="tel" name="telCelular" placeholder="N�mero do celular" maxlength="15">
      <input required type="password" name="senha" placeholder="Senha" minlength="8" maxlength="40">
      <input required type="password" name="confirmarSenha" placeholder="Confirmar senha" minlength="8" maxlength="40">
      <input type="hidden" name="acao" value="cadUsuario">
      <button type="submit">Cadastrar</button>
    </form>
  </section>
  <script src="resources/js/CadastroUsuario.js"></script>
</body>
</html>
