package service;

import java.io.IOException;
import java.util.ArrayList;

import dao.ProdutoDAO;
import model.Produto;

public class ProdutoService {
    ProdutoDAO dao = new ProdutoDAO();
    
    public int criar(Produto produto) {
        return dao.criar(produto);
    }
    public void atualizar(Produto produto){
        dao.atualizar(produto);
    }

    public void excluir(int idProduto){
        dao.excluir(idProduto);
    }

    public Produto carregar(int idProduto) throws IOException {
        return dao.carregar(idProduto);
    }
    
    public Produto carregarProduto(int idProduto) throws IOException{
    	return dao.carregarProduto(idProduto);
    }
    
    public ArrayList<Produto> listarProdutos() throws IOException {
		return dao.listarProdutos();
	}

	public ArrayList<Produto> listarProdutos(String chave) throws IOException {
		return dao.listarProdutos(chave);
	}
	public ArrayList<Produto> listarApple() throws IOException {
		return dao.listarApple();
		
	}
	public ArrayList<Produto> listarXiaomi() throws IOException {
		return dao.listarXiaomi();
		
	}
	public ArrayList<Produto> listarSmartWatch() throws IOException {
		return dao.listarSmartWatch();
		
	}
	public ArrayList<Produto> listarFones() throws IOException {
		return dao.listarFones();
		
	}
	public ArrayList<Produto> listarSamsung() throws IOException {
		return dao.listarSamsung();
		
	}
}
