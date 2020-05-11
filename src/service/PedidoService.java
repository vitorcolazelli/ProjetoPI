package service;

import model.Pedido;

import java.util.ArrayList;

import dao.PedidoDAO;

public class PedidoService {
	PedidoDAO dao = new PedidoDAO();

	public int criar(Pedido pedido) {
		return dao.criar(pedido);
	}

	public void atualizar(Pedido pedido) {
		dao.atualizar(pedido);
	}

	public void excluir(int idPedido) {
		dao.excluir(idPedido);
	}

	public Pedido carregar(int idPedido) {
		return dao.carregar(idPedido);
	}

	public ArrayList<Pedido> listarPedidos() {
		return dao.listarPedidos();
	}

	public ArrayList<Pedido> listarPedidos(String chave) {
		return dao.listarPedidos(chave);
	}
}