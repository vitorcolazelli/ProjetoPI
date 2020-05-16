<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<style>
	.page-header{
		padding-top: 80px;
	}
	
	.linha{
		padding-top: 40px;
	}
</style>
	<head>
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
	<link href="css/style.css" rel="stylesheet">
	</head>
	<body>
	<c:import url="MenuAdmLista.jsp"/>
		<div class="cadastroletraLogin">
			<div id="main" class="container">
				<h3 class="page-header" align="center">Editar Pedido</h3>
				<br>
				<form action="controller.do " method="post">
					<div class="row">
						<div class="form-group col-md-12 linha">
							<label for="valorTotal">Id Pedido:
							</label> <input value="${pedido.idPedido}" type="text" class="form-control"
								name="idPedido" id="idPedido" disabled  />
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12 linha">
							<label for="valorTotal">Id Cliente:
							</label> <input value="${pedido.cliente_idCliente}" type="text" class="form-control"
								name="idCliente" id="idCliente" disabled  />
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12 linha">
							<label for="valorTotal">Valor Total:
							</label> <input value="${pedido.valorTotal}" type="text" class="form-control preco"
								name="valorTotal" id="valorTotal" maxlength="50" />
						</div>
					</div>
								<div class="row">
						<div class="form-group col-md-12 linha">
							<label for="formaPagamento_idPagamento">Forma de Pagamento:
							</label> <input value="${pedido.formaPagamento_idPagamento}" type="text" class="form-control"
								name="formaPagamento_idPagamento" id="formaPagamento_idPagamento" maxlength="50" />
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12 linha">
							<label for="status">Status:
							</label> <input value="${pedido.status}" type="text" class="form-control"
								name="status" id="status" maxlength="50" />
						</div>
					</div>
					<hr />
					<div class="containerLogin">
						<div id="actions" class="row">
							<div class="md-col-12">
								<button type="submit" class="btn btn-primary" name="command" value="AlterarPedido">Alterar</button>
								<a href="ListarPedidos.jsp" class="btn btn-danger"
									role="button" aria-pressed="true">Cancelar</a>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>
</HTML>