package filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Administrador;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(filterName="LoginFilter", urlPatterns= {"/TelaAdmin.jsp", "/ListarClientes.jsp", "/ListarAdministradores.jsp",
        "/ListarColecoes.jsp", "/ListarProdutos.jsp", "/EditarAdministrador.jsp",
        "/EditarCliente.jsp", "/EditarColecao.jsp", "/EditarProduto.jsp",
        "/VisualizarAdministrador.jsp", "/VisualizarCliente.jsp", "/VisualizarColecao.jsp",
        "/VisualizarProduto.jsp", "/TelaCadastroAdministrador.jsp","/TelaCadastroColecao.jsp", "/TelaCadastroProduto.jsp", "/Menu.jsp",
        "/MenuAdm.jsp", "/MenuAdmLista.jsp", "/footer.jsp", "/header.jsp", })
public class LoginFilter implements Filter {

	public LoginFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		Administrador administrador = (Administrador) session.getAttribute("logado");

		String path = req.getContextPath();
		String uri = req.getRequestURI();

		String comando = req.getParameter("command");

		if (comando == null) {
			comando = "";
		}
		if (administrador == null && !uri.equals(path + "/LoginAdm.jsp") && !comando.equals("FazerLoginAdm")) {
			((HttpServletResponse) response).sendRedirect(path + "/LoginAdm.jsp");

		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
