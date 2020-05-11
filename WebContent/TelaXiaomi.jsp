<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Darkcell! - Explosão de Preços Baixo</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/TelaXiaomi.css" rel="stylesheet">
</head>
<body>
	<c:import url="header.jsp"/>
	<c:import url="Menu.jsp"/>
	<div id="main" class="container">
		<div id="main" class="containerXiaomi">
			<div class="TopoXiaomi">
				<strong>
					<a class="inicioBotao" href="TelaInicial.jsp" title="Voltar à página inicial">Inicio</a>
    				<span> > </span><span>Xiaomi</span>
    			</strong>  
    		</div>
			<h1 class="TituloXiaomi"><strong>Xiaomi</strong></h1>
		</div>
		<hr>
		<div class="ListaProdutos">
			<c:forEach var="produto" items="${lista}">
				<div class="ContainerProdutos">
				<a href="controller.do?command=VisualizarProdutoPagina&idProduto=${produto.idProduto}"><img class="img_produto" height="180px" width="180px" src="data:image/jpg;base64,${produto.base64Image}">
				<span>${produto.nome}</span>
				<br>
				<span class="spanValor">${produto.valor}</span></a>
					
				</div>
			</c:forEach>
		</div>
	</div>
	<c:import url="footer.jsp"/>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</HTML>
