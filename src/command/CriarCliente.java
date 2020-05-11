package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;
import service.ClienteService;

public class CriarCliente implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		String pEmail = request.getParameter("email");
		String pSenha = request.getParameter("senha");
		String pCpf = request.getParameter("cpf");
		String pEndereco = request.getParameter("endereco");
		String pPais = request.getParameter("pais");
		String pEstado = request.getParameter("estado");
		String pCep = request.getParameter("cep");
		String pFone = request.getParameter("fone");
		String pNotificacao = request.getParameter("notificacao");
		String pBairro = request.getParameter("bairro");
		String pNumero = request.getParameter("numero");
		String pComplemento = request.getParameter("complemento");
		
		Cliente cliente = new Cliente();
		cliente.setNome(pNome); 
		cliente.setEmail(pEmail);
		cliente.setSenha(pSenha);
		cliente.setCpf(pCpf);
		cliente.setEndereco(pEndereco);
		cliente.setPais(pPais);
		cliente.setEstado(pEstado);
		cliente.setCep(pCep);
		cliente.setFone(pFone);
		cliente.setNotificacao(pNotificacao);
		cliente.setBairro(pBairro);
		cliente.setNumero(pNumero);
		cliente.setComplemento(pComplemento);	
		
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
