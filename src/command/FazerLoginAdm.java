package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Administrador;
import service.AdministradorService;

public class FazerLoginAdm implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Administrador administrador = new Administrador();
		administrador.setEmail(email);
		administrador.setSenha(senha);
		
		AdministradorService as = new AdministradorService();
		
		if(as.validar(administrador)) {
			HttpSession session = request.getSession();
			administrador = as.carregarEmail(administrador.getEmail());
			session.setAttribute("logado", administrador);
			session.setAttribute("logNomeAdm", administrador.getNome());			
			System.out.println("logou" + administrador);
		}else {
			System.out.println("Não logou" + administrador);
			throw new ServletException("Usuario/Senha invalidos");
		}
		
		response.sendRedirect("TelaAdmin.jsp");
	}

}
