package command;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Colecao;
import service.ColecaoService;

public class VisualizarColecao implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		String pIdColecao = request.getParameter("idColecao");
		String pNome = request.getParameter("nome");
		int idColecao = -1;
		/*InputStream is  = request.getPart("imagem_colecao").getInputStream();
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		
		int nRead;
		byte[] data = new byte[16384];

		while ((nRead = is.read(data, 0, data.length)) != -1) {
		  buffer.write(data, 0, nRead);
		}

		byte[] imagem_colecao = buffer.toByteArray();*/
		
		try {
			idColecao = Integer.parseInt(pIdColecao);
		} catch (NumberFormatException e) {
		}
		
		Colecao colecao = new Colecao();
		colecao.setIdColecao(idColecao);
		colecao.setNome(pNome);
		//colecao.setImagem_colecao(imagem_colecao);
		
		ColecaoService cs = new ColecaoService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		colecao = cs.carregar(colecao.getIdColecao());
		request.setAttribute("colecao", colecao);
		view = request.getRequestDispatcher("VisualizarColecao.jsp");
			
		view.forward(request, response);
	}
}
