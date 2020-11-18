<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="title" required="true" %>
<%@ attribute name="cssProprio" required="true" %>
<%@ attribute name="jsProprio" required="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang='pt'>
<head>
<meta charset="ISO-8859-1">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<meta http-equiv='X-UA-Compatible' content='ie=edge'>
<link rel="apple-touch-icon" sizes="180x180" href="<c:url value="/resources/imgs/apple-touch-icon.png"/>">
<link rel="icon" type="image/png" sizes="32x32" href="<c:url value="/resources/imgs/favicon-32x32.png"/>">
<link rel="icon" type="image/png" sizes="16x16" href="<c:url value="/resources/imgs/favicon-16x16.png"/>">
<link rel="manifest" href="<c:url value="/resources/imgs/site.webmanifest"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/global.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/generico.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/CatalogoEst.css"/>">

    <!--CDN versions of jQuery and Popper.js (deve estar antes dos cods Bootstrap -->

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>


<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.min.js'></script>
<title>${title}</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value="${cssProprio}"/>">
</head>

<body>

	<jsp:doBody/>
	
	<script type="text/javascript" src="<c:url value="${jsProprio}"/>"></script>

		<!--SCRIPTS PARA EXECUÇÃO DO BOOTSTRAP-->
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	
</body>
</html>
