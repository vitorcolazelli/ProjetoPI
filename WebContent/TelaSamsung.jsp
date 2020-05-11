<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<body>
<head>
<!-- Bootstrap CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/TelaSamsung.css" rel="stylesheet">
</head>

<c:import url="header.jsp"/>
		<c:import url="Menu.jsp"/>
<div id="main" class="container">
<div id="main" class="containerSamsung">
<div class="TopoSamsung">
<strong>  
<a class="inicioBotao" href="TelaInicial.jsp" title="Voltar à página inicial">Inicio</a>
    <span>></span>          <span>Samsung</span> </strong>  </div>
<h1 class="TituloSamsung"><strong>Samsung</strong></h1>
</div>
	<c:forEach var="produto" items="${lista}">
				<div class="ContainerProdutos">
				<a href="controller.do?command=VisualizarProdutoPagina&idProduto=${produto.idProduto}"><img class="img_produto" height="180px" width="180px" src="data:image/jpg;base64,${produto.base64Image}">
																									<span>${produto.nome}</span>
																									<br>	
																									<span class="spanValor">${produto.valor}</span></a> 
					
				</div>
	</c:forEach>
</div>
<c:import url="footer.jsp"/>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</HTML>
