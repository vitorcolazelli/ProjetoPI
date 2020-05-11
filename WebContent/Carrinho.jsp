<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Darkcell ! - Explosão de Preços Baixo</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/Carrinho.css" rel="stylesheet">
</head>
<body>
	<c:import url="header.jsp" />
	<c:import url="Menu.jsp" />
	<div id="main" class="container">
		<h1 class="titulo">Seu Carrinho</h1>
		<c:choose>
			<c:when test="${not empty lista}">
				<c:forEach var="produto" items="${lista}">
					<div>
						<img class="imgProduto" src="data:image/jpg;base64,${produto.base64Image}">
						<strong>${produto.nome}</strong>
						<p class="valor">${produto.valor}</p>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<p>Seu carrinho está vazio no momento.</p>
				<p>Continue navegando <a href="Coleções.jsp">aqui</a></p>	
			</c:otherwise>
		</c:choose>
	</div>
	<c:import url="footer.jsp" />
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</HTML>