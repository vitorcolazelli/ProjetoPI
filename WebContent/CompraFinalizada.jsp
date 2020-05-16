<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/ConcluirPagamento.css" rel="stylesheet">
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
	<div class="container">
		<div class="principal" align="center">
			<div class="container">
				<a href="TelaInicial.jsp"><img class="imgLogo" src="./imagens/logo.png"></a>
				<div class="Pagamento">
				
				</div>
				<div class="divBtn">
					<a class="text-dark voltar" href="TelaInicial.jsp">‹ Voltar para a Loja</a>
					<a class="btn btn-danger btn-lg pagto" href="controller.do?command=Pedidos" role="button">Meus Pedidos</a>
				</div>
			</div>
		</div>
		<div class="itens">
		</div>
	</div>
	<div class="clear"></div>
</body>
</HTML>

