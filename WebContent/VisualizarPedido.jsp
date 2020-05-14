<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<style>
	.page-header{
		padding-top: 80px;
	}
	
	.linha{
		padding-top: 40px;
	}
</style>
<head>
<!-- Bootstrap CSS -->
</head>
<body>
<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog"
	aria-labelledby="modalLabel">

	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">

				<button type="button" class="close" data-dismiss="modal"
					aria-label="Fechar">
					<span aria-hidden="true">&times;</span>

				</button>
				<h4 class="modal-title" id="modalLabel">Excluir Pedido</h4>
			</div>
			<div class="modal-body">Deseja realmente excluir este Pedido?
			</div>
			<div class="modal-footer">
				<form action="controller.do" method="post">
					<input type="hidden" name="idPedido" id="id_excluir" />
					<button type="submit" class="btn btn-primary" name="command"
						value="ExcluirPedido">Sim</button>

					<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>

				</form>
			</div>
		</div>
	</div>
</div>
<c:import url="MenuAdmLista.jsp"/>
<div id="main" class="container">
	<h3 class="page-header" align="center">Visualizar Informações do Pedido</h3>
	<br>
	<form action="controller.do" method="post">
		<div class="row">
			<div class="form-group col-md-12 linha">
				<p>
					<strong>Id: </strong> <br> ${pedido.idPedido}
				</p>
			</div>
			</div>
				<div class="row">
			<div class="form-group col-md-12">
				<p>
					<strong>Valor Total: </strong> <br> ${pedido.valorTotal}
				</p>
			</div>
			</div>
			<hr />
			<div class="containerLogin">
				<div id="actions" class="row">
					<div class="md-col-12">
						<a class="btn btn-primary btn-sm"
							href="controller.do?command=EditarPedido&idPedido=${pedido.idPedido}">Editar</a>
						<button id="btn${pedido.idPedido}%>" type="button"
							class="btn btn-danger btn-sm" data-toggle="modal"
							data-target="#delete-modal" data-cliente="${pedido.idPedido }">Excluir</button>

						<a href="controller.do?command=ListarPedido" class="btn btn-light btn-sm"
							role="button" aria-pressed="true">Voltar</a>
					</div>
				</div>
			</div>
	</form>
</div>
<script src="js/jquery.min.js"></script>
<script type="text/javascript">
	$("#delete-modal").on('show.bs.modal', function(event) {
		var button = $(event.relatedTarget); //botao que disparou a modal
		var recipient = button.data('administrador');
		$("#id_excluir").val(recipient);
	});
</script>
</body>
</HTML>