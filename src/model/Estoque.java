package model;

public class Estoque {
	private int idEstoque;
	private String quantidadeProduto;
	private int produto_idProduto;
	private int produto_pedido_idPedido;
	private int produto_pedido_entrega_idEntrega;
	
	public Estoque() {
		
	}
	
	public Estoque(int idEstoque, String quantidadeProduto, int produto_idProduto, int produto_pedido_idPedido,
			int produto_pedido_entrega_idEntrega) {
		this.idEstoque = idEstoque;
		this.produto_idProduto = produto_idProduto;
		this.quantidadeProduto = quantidadeProduto;
		
	}

	public int getIdEstoque() {
		return idEstoque;
	}

	public void setIdEstoque(int idEstoque) {
		this.idEstoque = idEstoque;
	}

	public String getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(String quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public int getProduto_idProduto() {
		return produto_idProduto;
	}

	public void setProduto_idProduto(int produto_idProduto) {
		this.produto_idProduto = produto_idProduto;
	}

	public int getProduto_pedido_idPedido() {
		return produto_pedido_idPedido;
	}

	public void setProduto_pedido_idPedido(int produto_pedido_idPedido) {
		this.produto_pedido_idPedido = produto_pedido_idPedido;
	}

	public int getProduto_pedido_entrega_idEntrega() {
		return produto_pedido_entrega_idEntrega;
	}

	public void setProduto_pedido_entrega_idEntrega(int produto_pedido_entrega_idEntrega) {
		this.produto_pedido_entrega_idEntrega = produto_pedido_entrega_idEntrega;
	}
}
