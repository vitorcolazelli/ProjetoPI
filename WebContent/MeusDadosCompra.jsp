<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
  		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/MeusDadosCompra.css" rel="stylesheet">
</head>
<body>
	<c:import url="header.jsp" />
	<c:import url="Menu.jsp" />
<div class="cadastroletraLogin">
	<div class="container">
	<br>
		<h3 class="page-header" align="center"> <strong></strong></h3>
		<br>
		<form action="controller.do " method="post">
			<h3><strong>Informações do Usuário</strong></h3>
			<br>
			<input type="hidden" name="idCliente" value="${cliente.idCliente}"/>
			<div class="row">
				<div class="form-group col-md-12 linha">
					<label for="nome">Nome:
					</label> <input value="${cliente.nome}" type="text" class="form-control"
						name="nome" id="nome" maxlength="50" />
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="email">E-mail:
					</label> <input value="${cliente.email}" type="text" class="form-control"
						name="email" id="email" maxlength="50" />
				</div>
				<div class="form-group col-md-6">
					<label for="senha">Senha:
					</label> <input value="${cliente.senha}" type="text" class="form-control"
						name="senha" id="senha" maxlength="100" />
				</div>
				</div>
				<div class="row">
				<div class="form-group col-md-6">
					<label for="cpf">CPF: </label>
					<input value="${cliente.cpf}" type="text" class="form-control"
						name="cpf" id="cpf" maxlength="100" />
				</div>
					<div class="form-group col-md-6">
					<label for="fone">Telefone: </label>
					<input value="${cliente.fone}" type="text" class="form-control"
						name="fone" id="fone" maxlength="100" />
				</div>
			</div>
			<hr />
			<div class="containerLogin">
				<div id="actions" class="row">
					<div class="md-col-12">
						<button type="submit" class="btn btn-primary" name="command" value="AlterarMeusDadosCompra">Alterar</button>
						<a href="controller.do?command=CarregarPedido" class="btn btn-danger"
							role="button" aria-pressed="true">Cancelar</a>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
		<c:import url="footer.jsp"/>
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
</body>
</HTML>

