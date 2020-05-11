package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

public class VisualizarProdutoPagina implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); 
		String pIdProduto = request.getParameter("idProduto");
		String pNome = request.getParameter("nome");
		String pValor = request.getParameter("valor");
		String pCapacidade = request.getParameter("capacidade");
		String pCor = request.getParameter("cor");
		double valor = 0.0;
		int idProduto = 1;
		
		try {
			idProduto = Integer.parseInt(pIdProduto);
		}catch (NumberFormatException e) {
			
		}
		
		try {
			valor = Double.parseDouble(pValor);
		}catch (NumberFormatException e) {
			
		}
		
		Produto produto = new Produto();
		produto.setIdProduto(idProduto);
		produto.setNome(pNome); 
		produto.setValor(valor);
		produto.setCapacidade(pCapacidade);
		produto.setCor(pCor);	

		ProdutoService ps = new ProdutoService();
		RequestDispatcher view = null;
		
		produto = ps.carregarProduto(produto.getIdProduto());
		request.setAttribute("produto", produto);
		view = request.getRequestDispatcher("ProdutoTela.jsp");
		view.forward(request, response);
	}
}
