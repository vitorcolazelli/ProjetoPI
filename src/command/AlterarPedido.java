package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pedido;
import service.PedidoService;

public class AlterarPedido implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pIdPedido = request.getParameter("idPedido");
		String pValorTotal = request.getParameter("valorTotal");
		String pStatus = request.getParameter("status");
		
		float valorTotal = 0.0f;
		try {
			valorTotal = Float.parseFloat(pValorTotal);
		}catch(NumberFormatException e) {
			
		}
		
		int idPedido = -1;
		try {
			idPedido = Integer.parseInt(pIdPedido);
		} catch (NumberFormatException e) {
		
		}
		
		Pedido pedido = new Pedido();
		pedido.setIdPedido(idPedido);
		pedido.setValorTotal(valorTotal);
		pedido.setStatus(pStatus);
		
		PedidoService cs = new PedidoService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		cs.atualizar(pedido);
		ArrayList<Pedido> lista = (ArrayList<Pedido>) session.getAttribute("lista");
		int pos = busca(pedido, lista);
		lista.remove(pos);
		lista.add(pos,pedido);
		session.setAttribute("lista", lista);
		request.setAttribute("pedido", pedido);
		view = request.getRequestDispatcher("VisualizarPedido.jsp");
		
		 view.forward(request, response);
	}

	public int busca(Pedido pedido, ArrayList<Pedido> lista) {
		Pedido to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getIdPedido() == pedido.getIdPedido()) {

				return i;
			}
		}
		return -1;
	} 
}
