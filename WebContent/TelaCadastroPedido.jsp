<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<style>
.cadastroletra {
	padding-top: 95px;
}
</style>

<head>
<!-- Bootstrap CSS -->
<link href="css/TelaCadastroProduto.css" rel="stylesheet">
</head>
<body>
	<c:import url="MenuAdmLista.jsp" />
	<div class="cadastroletra">
		<div id="main" class="container">
			<h1 class="page-header">Cadastro de Produtos</h1>
			<form enctype="multipart/form-data" action="controller.do"
				method="post">
				<div class="row">
					<div class="form-group col-md-12">
						<label for="valorTotal">Valor: </label> <input type="text"
							class="form-control" name=valorTotal id="valorTotal" required
							maxlength="50" placeholder="Valor total do pedido" />
					</div>
				</div>

				<button type="submit" class="botao" name="command"
					value="CriarPedido">Cadastrar</button>
				<a href="ListarPedidos.jsp" class="btn btn-link">Cancelar</a>
			</form>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
</body>
</HTML>