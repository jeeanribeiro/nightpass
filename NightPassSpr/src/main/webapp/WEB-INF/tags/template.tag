<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="title" required="true" %>
<%@ attribute name="cssProprio" required="true" %>
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
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.min.js'></script>
<title>${title}</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value="${cssProprio}"/>">
</head>

<body>

	<jsp:doBody/>

  <script src="<c:url value="resources/js/LoginUsuario.js"/>"></script>
</body>
</html>

