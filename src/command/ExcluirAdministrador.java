package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Administrador;
import service.AdministradorService;

public class ExcluirAdministrador implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String pIdAdministrador = request.getParameter("idAdministrador");
		int idAdministrador = 1;
		
		try {
			idAdministrador = Integer.parseInt(pIdAdministrador);
		}catch (NumberFormatException e) {
			
		}
		
		Administrador administrador = new Administrador();
		administrador.setIdAdministrador(idAdministrador);
		
		AdministradorService cs = new AdministradorService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		 
		cs.excluir(administrador.getIdAdministrador());
		ArrayList<Administrador> lista = (ArrayList<Administrador>) session.getAttribute("lista");
		lista.remove(busca(administrador, lista));
		session.setAttribute("lista", lista);
		
		view = request.getRequestDispatcher("ListarAdministradores.jsp");
	
		view.forward(request, response);
	}

	public int busca(Administrador administrador, ArrayList<Administrador> lista) {
		Administrador to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getIdAdministrador() == administrador.getIdAdministrador()) {

				return i;
			}
		}
		return -1;
	}
	
}
