package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pedido;
import service.PedidoService;

public class FinalizarCompra implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pIdPedido = request.getParameter("idPedido");
		int idCliente = (Integer)request.getSession().getAttribute("idCliente");
		String idFormaPagamento = request.getParameter("pagamento");	
		String valorTotal = request.getParameter("total");
		
		int idPedido = -1;
		try {
			idPedido = Integer.parseInt(pIdPedido);
		} catch (NumberFormatException e) {
		
		}
		
		int pagamento = -1;
		try {
			pagamento = Integer.parseInt(idFormaPagamento);
		} catch (NumberFormatException e) {
		
		}
		
		double total = 0.0;
		try {
			total = Double.parseDouble(valorTotal);
		} catch (NumberFormatException e) {
		
		}
		
		
		Pedido pedido = new Pedido();
		pedido.setIdPedido(idPedido);
		pedido.setCliente_idCliente(idCliente);
		pedido.setFormaPagamento_idPagamento(pagamento);
		pedido.setValorTotal(total);
		
		PedidoService cs = new PedidoService();
		RequestDispatcher view = null;
		
		cs.atualizar(pedido);
		request.setAttribute("pedido", pedido);
		view = request.getRequestDispatcher("CompraFinalizada.jsp");
		
		 view.forward(request, response);
	}
}
