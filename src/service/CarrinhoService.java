package service;

import java.io.IOException;
import java.util.ArrayList;

import dao.CarrinhoDAO;
import model.Carrinho;

public class CarrinhoService {
    CarrinhoDAO dao= new CarrinhoDAO();
    
    public int inserir(Carrinho carrinho) {
        return dao.inserir(carrinho);
    }
    
    public void excluir(int idCarrinho) {
        dao.excluir(idCarrinho);
    }
    
    public Carrinho carregarCarrinho(int idCarrinho) throws IOException {
        return dao.carregarCarrinho(idCarrinho);
    }
    
    public ArrayList<Carrinho> listarCarrinho(Carrinho carrinho) throws IOException {
    	return dao.listarCarrinho(carrinho);
    }
}
