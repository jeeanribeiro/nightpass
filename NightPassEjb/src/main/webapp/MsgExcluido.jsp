<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang='pt'>
<head>
<meta charset='UTF-8'>
<meta charset="ISO-8859-1">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<link rel="apple-touch-icon" sizes="180x180" href="imgs/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="imgs/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="imgs/favicon-16x16.png">
<link rel="manifest" href="imgs/site.webmanifest">
<link rel="stylesheet" href="global.css">
<title>Painel Gestor - NightPass</title>
<style>
    @import url('https://fonts.googleapis.com/css?family=Fira+Sans&display=swap');
    body {
        align-items: center;
        backdrop-filter: blur(2px) brightness(50%);
        background-image: url("imgs/background-club.jpg");
        background-size: cover;
        display: flex;
        justify-content: center;
        font-family: 'Fira Sans', sans-serif;
        max-width: 100%;
        margin: 0;
        min-height: 100vh;
        padding: 0;
    }

    h1 {
        background: rgba(255, 255, 255, 0.2);
        color: #fff;
        padding: 50px;
    }
</style>
</head>
<body>
    <h1>${contaexcluida} <br> <button type="button" onclick="window.location.href='LoginUsuario.jsp'">Voltar</button></h1><p><p>
</body>
</html>