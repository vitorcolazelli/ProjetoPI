package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Produto;
import service.ProdutoService;

public class ExcluirProduto implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String pIdProduto = request.getParameter("idProduto");
		int idProduto = 1;
		
		try {
			idProduto = Integer.parseInt(pIdProduto);
		}catch (NumberFormatException e) {
			
		}
		
		Produto produto = new Produto();
		produto.setIdProduto(idProduto);
		
		ProdutoService ps = new ProdutoService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		 
		ps.excluir(produto.getIdProduto());
		ArrayList<Produto> lista = (ArrayList<Produto>) session.getAttribute("lista");
		lista.remove(busca(produto, lista));
		session.setAttribute("lista", lista);
		
		view = request.getRequestDispatcher("ListarProdutos.jsp");
	
		view.forward(request, response);
	}

	public int busca(Produto produto, ArrayList<Produto> lista) {
		Produto to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getIdProduto() == produto.getIdProduto()) {

				return i;
			}
		}
		return -1;
	}
	
}
