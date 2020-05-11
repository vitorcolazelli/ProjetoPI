package command;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Colecao;
import service.ColecaoService;

public class AlterarColecao implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		
		cs.atualizar(colecao);
		ArrayList<Colecao> lista = (ArrayList<Colecao>) session.getAttribute("lista");
		int pos = busca(colecao, lista);
		lista.remove(pos);
		lista.add(pos, colecao);
		session.setAttribute("lista", lista);
		request.setAttribute("colecao", colecao);
		view = request.getRequestDispatcher("VisualizarColecao.jsp");
		view.forward(request, response);
	}
	
	public int busca(Colecao colecao, ArrayList<Colecao> lista) {
		Colecao to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getIdColecao() == colecao.getIdColecao()) {
				return i;
			}
		}
		return -1;
	}
}