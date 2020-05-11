package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

public class EditarProduto implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pIdProduto = request.getParameter("idProduto");
		String pNome = request.getParameter("nome");
		String pModelo = request.getParameter("modelo");
		String pValor = request.getParameter("valor");
		String pCapacidade = request.getParameter("capacidade");
		String pCor = request.getParameter("cor");
		String pQuantidadeEstoque = request.getParameter("quantidadeEstoque");
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
		
		int quantidadeEstoque = 1;
		
		try {
			quantidadeEstoque = Integer.parseInt(pQuantidadeEstoque);
		}catch (NumberFormatException e) {
			
		}
		
		
		Produto produto = new Produto();
		produto.setIdProduto(idProduto);
		produto.setNome(pNome); 
		produto.setModelo(pModelo);
		produto.setValor(valor);
		produto.setCapacidade(pCapacidade);
		produto.setCor(pCor);	
		produto.setQuantidadeEstoque(quantidadeEstoque);
		
		ProdutoService ps = new ProdutoService();
		RequestDispatcher view = null;
		
		produto = ps.carregar(produto.getIdProduto());
		request.setAttribute("produto", produto);
		view = request.getRequestDispatcher("EditarProduto.jsp");
		view.forward(request,response); 
	}
}
