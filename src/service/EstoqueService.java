package service;

import model.Estoque;
import dao.EstoqueDAO;

public class EstoqueService {
    EstoqueDAO dao = new EstoqueDAO();

    public int inserir(Estoque estoque) {
        return dao.inserir(estoque);
    }
    public void atualizar(Estoque estoque){
        dao.atualizar(estoque);
    }

    public void excluir(int idEstoque){
        dao.excluir(idEstoque);
    }

    public Estoque carregar(int idEstoque){
        return dao.carregar(idEstoque);
    }
}