package model;

import java.util.ArrayList;

public class Pedido {
	private int idPedido;
	private float valorTotal;
	private String status;
	private int cliente_idCliente;
	private ArrayList<ItemPedido> itens;
	private int formaPagamento_idPagamento;
	
	public Pedido(int idPedido, float valorTotal, String status, int cliente_idCliente, int formaPagamento_idPagamento) {
		this.idPedido = idPedido;
		this.valorTotal = valorTotal;
		this.status = status;
		this.cliente_idCliente = cliente_idCliente;
		this.formaPagamento_idPagamento = formaPagamento_idPagamento;
		itens = new ArrayList<ItemPedido>();
	}

	public ArrayList<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(ArrayList<ItemPedido> itens) {
		this.itens = itens;
	}

	public int getIdPedido() {
		return idPedido;
	}


	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}


	public float getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}


	public int getCliente_idCliente() {
		return cliente_idCliente;
	}


	public void setCliente_idCliente(int cliente_idCliente) {
		this.cliente_idCliente = cliente_idCliente;
	}


	public int getFormaPagamento_idPagamento() {
		return formaPagamento_idPagamento;
	}


	public void setFormaPagamento_idPagamento(int formaPagamento_idPagamento) {
		this.formaPagamento_idPagamento = formaPagamento_idPagamento;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
}