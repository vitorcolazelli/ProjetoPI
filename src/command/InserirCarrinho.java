package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Carrinho;
import service.CarrinhoService;


public class InserirCarrinho implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pQuantidade = request.getParameter("quantidade");
		String pSubtotal = request.getParameter("subTotal");
		String pFk_produtoId = request.getParameter("idProduto");
		String pFk_clienteId = request.getParameter("idCliente");
		
		
		Carrinho carrinho = new Carrinho();
		carrinho.
		
		ClienteService cs = new ClienteService();
		cs.criar(cliente);
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ArrayList<Cliente> lista = new ArrayList<>();
		lista.add(cliente);
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("TelaInicial.jsp");
		request.setAttribute("msg", "Cadastro Efetuado com sucesso");
		view.forward(request, response);
	}
}