package model;

public class Carrinho {
     private int idCarrinho;
     private int quantidade;
     private double subTotal;
     private Produto produto;
     private Cliente cliente;

        public Carrinho(int idCarrinho, Produto produto , Cliente cliente, int quantidade, double subTotal) {
            this.idCarrinho = idCarrinho;
            this.produto= produto;
            this.cliente= cliente;
            this.quantidade = quantidade;
            this.subTotal = subTotal;
        }

        public Carrinho() {

        }

        public int getIdCarrinho() {
            return idCarrinho;
        }

        public void setIdCarrinho(int idCarrinho) {
            this.idCarrinho = idCarrinho;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }

        public double getSubTotal() {
            return subTotal;
        }

        public void setSubTotal(double subTotal) {
            this.subTotal = subTotal;
        }

        public Produto getProduto() {
            return produto;
        }

        public void setProduto(Produto produto) {
            this.produto = produto;
        }
        public Cliente getCliente() {
            return cliente;
        }
        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }
}
