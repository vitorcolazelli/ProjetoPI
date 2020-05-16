<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/ConcluirPagamento.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/material-design-icons/3.0.1/iconfont/material-icons.min.css"
	integrity="sha256-x8PYmLKD83R9T/sYmJn1j3is/chhJdySyhet/JuHnfY="
	crossorigin="anonymous" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"
	type="text/javascript"></script>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		var changeval = function() {
			var p = $(this).text();
			var nval = new Intl.NumberFormat('pt-BR', {
				style : 'currency',
				currency : 'BRL',
				minimumFractionDigits : 2
			}).format(p);
			$(this).text(nval);
		}

		$('.preco').each(changeval).on('change', changeval);
	});
</script>
</head>
<body>
	<form action="controller.do" method="post">
		<div class="container">
			<div class="principal" align="center">
				<div class="container">
					<a href="TelaInicial.jsp"><img class="imgLogo"
						src="./imagens/logo.png"></a>
					<div class="caminho">
						<a class="linkHead" href="controller.do?command=Carrinho"><span>Carrinho</span></a>
						› <a class="linkHead" href="controller.do?command=CarregarPedido"><span>Frete</span></a>
						› <a class="linkHead"
							href="controller.do?command=CarregarPagamento"><span>Pagamento</span></a>
					</div>
					<div class="Pagamento">
						<div class="Cartao">
							<i class="material-icons icon">credit_card</i> <input
								type="radio" value="2" name="pagamento" id="radio-cartao"
								checked> <span class="CartaoS">Cartão</span>
						</div>

						<div class="Boleto">
							<i class="material-icons icon">receipt</i> <input type="radio"
								value="1" name="pagamento" id="radio-boleto" checked> <span
								class="BoletoS">Boleto</span>
						</div>
						<hr>
					</div>

					<div class="divBtn">
						<a class="text-dark voltar"
							href="controller.do?command=CarregarPedido">‹ Voltar para o
							frete</a>
						<button class="btn btn-danger btn-lg pagto"
							value="FinalizarCompra" name="command" role="button">Finalizar
							Compra</button>
					</div>

				</div>
			</div>
			<div class="itens">
				<c:set var="total" value="${0}" />
				<c:set var="frete" value="${16}" />
				<c:set var="subtotal" value="${0}" />
				<c:forEach var="produto" items="${listaCarrinho}">
				<input type="hidden" name="idPedido" value="${produto.idPedido}" />
					<div class="prod">
						<a class="puxar"> <img class="imgProduto"
							src="data:image/jpg;base64,${produto.produto.base64Image}">
							<strong class="nome">${produto.produto.nome}</strong>
						</a> <span class="preco vlrqtd">${produto.produto.valor*produto.quantidade}</span>

					</div>
					<div class="clear"></div>
					<c:set var="total"
						value="${total + (produto.produto.valor*produto.quantidade)}" />
					<c:set var="subtotal" value="${total + frete}" />
				</c:forEach>
				<hr>
				<div class="separacao">
					<p>
						Subtotal<span class="preco"><c:out value="${total}" /></span>
					</p>
				</div>
				<div class="separacao">
					<p>
						Frete<span class="preco"><c:out value="${frete}" /></span>
					</p>
				</div>
				<hr>
				<div class="separacao">
					<input type="hidden" name="total" class="preco" value="${subtotal}" >
						SubTotal<span class="preco"><c:out value="${subtotal}" /></span>
				</div>
			</div>
		</div>
	</form>
	<div class="clear"></div>
</body>
</HTML>

