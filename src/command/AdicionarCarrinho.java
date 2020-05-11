package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ItemPedido;
import model.Pedido;
import service.PedidoService;
import service.ProdutoService;

public class AdicionarCarrinho implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idCliente = (Integer)request.getSession().getAttribute("idCliente");
		int idProduto = Integer.parseInt(request.getParameter("idProduto"));
		
		PedidoService ps = new PedidoService();
		Pedido carrinho = ps.listarPedidosCarrinho(idCliente);
		
		ps.inserirCarrinho(carrinho.getIdPedido(), idProduto);
		
		new Carrinho().executar(request, response);
	}
}
