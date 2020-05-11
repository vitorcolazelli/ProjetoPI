package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Estoque;

public class EstoqueDAO {
	public int inserir(Estoque estoque){
		String sqlInsert = "INSERT INTO Estoque(quantidadeProduto, produto_idProduto, produto_Pedido_idPedido, produto_Pedido_Entrega_idEntrega) VALUES (?, ?, ?, ?)";
		
		try(Connection conn = ConnectionFactory.obtemConexao(); 
			PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			stm.setString(1, estoque.getQuantidadeProduto());
			stm.setInt(2, estoque.getProduto_idProduto());
			stm.setInt(3, estoque.getProduto_pedido_idPedido());
			stm.setDouble(4, estoque.getProduto_pedido_entrega_idEntrega());
			stm.execute();
			String sqlQuery  = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					estoque.setIdEstoque(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return estoque.getIdEstoque();
	}
	
	public void atualizar(Estoque estoque) {
		String sqlUpdate = "UPDATE Produto SET quantidadeProduto, produto_idProduto, produto_Pedido_idPedido, produto_Pedido_Entrega_idEntrega WHERE idEstoque=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, estoque.getQuantidadeProduto());
			stm.setInt(2, estoque.getProduto_idProduto());
			stm.setInt(3, estoque.getProduto_pedido_idPedido());
			stm.setInt(4, estoque.getProduto_pedido_entrega_idEntrega());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int idEstoque){
		String sqlDelete = "DELETE FROM Estoque WHERE idEstoque=?";
		try(Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlDelete);){
			stm.setInt(1, idEstoque);
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Estoque carregar(int idEstoque) {
		Estoque estoque = new Estoque();
		estoque.setIdEstoque(idEstoque);
		String sqlSelect = "SELECT quantidadeProduto, produto_idProduto, produto_Pedido_idPedido, produto_Pedido_Entrega_idEntrega FROM Estoque WHERE Estoque.idEstoque = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, estoque.getIdEstoque());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					estoque.setQuantidadeProduto(rs.getString("quantidadeProduto"));
					estoque.setProduto_idProduto(rs.getInt("produto_idProduto"));
					estoque.setProduto_pedido_idPedido(rs.getInt("produto_Pedido_idPedido"));
					estoque.setProduto_pedido_entrega_idEntrega(rs.getInt("produto_Pedido_Entrega_idEntrega"));
					
				} else {
					estoque.setIdEstoque(-1);
					estoque.setQuantidadeProduto(null);
					estoque.setProduto_idProduto(0);
					estoque.setProduto_pedido_idPedido(0);
					estoque.setProduto_pedido_entrega_idEntrega(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return estoque;
	}
}