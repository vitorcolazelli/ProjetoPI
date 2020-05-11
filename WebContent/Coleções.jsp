<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<body>
<head>
<!-- Bootstrap CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/Coleções.css" rel="stylesheet">
</head>
	<c:import url="header.jsp"/>
	<c:import url="Menu.jsp"/>
	<div class="container-colecao">
	<div class="container">
<br>
<br>
	<h1>Coleções </h1></div>
		<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12" align="center"><a href="controller.do?command=ListarXiaomi"><img class="Logo" src="./imagens/Logo.Xiaomi.jpg" title="Navegue pela nossa coleção Xiaomi" alt="ImagemXiaomi"></a>
			<a href="controller.do?command=ListarApple"><img class="Logo" src="./imagens/Logo.Apple.jpg" title="Navegue pela nossa coleção Apple" alt="ImagemApple"></a>
			<a href="controller.do?command=ListarSamsung"><img class="Logo" src="./imagens/Logo.Samsung.png" title="Navegue pela nossa coleção Samsung" alt="ImagemSamsung"></a>
			<a href="controller.do?command=ListarSmartwatches"><img class="Logo" src="./imagens/Logo.Smartwatch.jpg" title="Navegue pela nossa coleção Smartwatches" alt="ImagemSmartwatch"></a>
			<a href="controller.do?command=ListarFones"><img class="Logo" src="./imagens/Logo.Fones.jpg" title="Navegue pela nossa coleção Fones" alt="ImagemFones"></a>
		</div>
		<div class="clear"></div>
	</div>
	<c:import url="footer.jsp"/>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</HTML>
