<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<title>Meus Pedidos</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/Carrinho.css" rel="stylesheet">
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js" type="text/javascript"></script>
	<script>
		$(document).ready(function(){
			var changeval = function () {
			       var p = $(this).text();
			       var nval = new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL', minimumFractionDigits: 2 }).format(p);
			       $(this).text(nval);
			    }
	
			     $('.preco')
			    .each(changeval)
			    .on('change', changeval);
		  });
	</script>
</head>
<body>
	<c:import url="header.jsp" />
	<c:import url="Menu.jsp" />
	<div id="main" class="container">
		<h1 class="titulo">Meus Pedidos</h1>
		<c:choose>
			<c:when test="${not empty listaCarrinho}">
				<table class="table" >
					<thead>
						<tr>
							<th></th>
							<th>Preço</th>
							<th>Quantidade</th>
							<th>Total</th>
						</tr>
					</thead>
					<tbody>
					<c:set var="total" value="${0}"/>
						<c:forEach var="produto" items	="${listaCarrinho}">
							<tr>
							
								<td>
									<a href="controller.do?command=VisualizarProdutoPagina&idProduto=${produto.idProduto}">
										<img class="imgProduto" src="data:image/jpg;base64,${produto.produto.base64Image}">
										<strong class="nome">${produto.produto.nome}</strong>
									</a>
									<a class="text-danger remove" href="">Visualizar Pedido</a>
								</td>
								<td>
									<span class="preco">${produto.produto.valor}</span>
								</td>
								<td>
										<span class="">${produto.quantidade}</span>
								</td>
								<td>
									<span class="preco">${produto.produto.valor*produto.quantidade}</span>
								</td>
								
							</tr>
							<c:set var="total" value="${total + (produto.produto.valor*produto.quantidade)}"/>
						</c:forEach>
					</tbody>
				</table>
			
			</c:when>
			<c:otherwise>
				<div class ="carrinhoVazio">
					<p>Você ainda não possui um pedido</p>
				 	<a class ="btn btn-outline-success Botao-xb btn-vazio" href="TelaInicial.jsp" >Voltar às Compras</a>	
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	<c:import url="footer.jsp" />
</body>
</html>