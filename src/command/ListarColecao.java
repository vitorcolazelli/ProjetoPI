package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Colecao;
import service.ColecaoService;

public class ListarColecao implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String chave = request.getParameter("data[search]");
		ColecaoService cs = new ColecaoService();
		ArrayList<Colecao> lista = null;
		HttpSession session = request.getSession();
		
			if (chave != null && chave.length() > 0) {
				lista = cs.listarColecao(chave);
			} 
			else {
				lista = cs.listarColecao();
			}
			session.setAttribute("lista", lista);
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarColecoes.jsp");
		dispatcher.forward(request, response);
	}
}
