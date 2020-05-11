package dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import model.Carrinho;
import model.Produto;

public class CarrinhoDAO {
	public int inserir(Carrinho carrinho) {
		String sqlInsert = "INSERT INTO carrinho (quantidade, subTotal, fk_produtoId, fk_IdCliente) VALUES (?, ?, ?, ?)";
		int id= 0;
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, carrinho.getQuantidade());
			stm.setDouble(2, carrinho.getSubTotal());
			stm.setInt(3, carrinho.getProduto().getIdProduto());
			stm.setInt(4, carrinho.getCliente().getIdCliente());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					id= rs.getInt(1);
					carrinho.setProduto(new Produto(id));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public void excluir(int idCarrinho) {
		String sqlDelete = "DELETE FROM carrinho WHERE idCarrinho= ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, idCarrinho);
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Carrinho carregarCarrinho(int idCarrinho) throws IOException{
		Carrinho carrinho = new Carrinho();
		String sqlSelect = "SELECT fk_produtoId, nome, modelo, valor, capacidade, cor, quantidade, subTotal, imagem_produto\r\n" + 
				"FROM produto JOIN carrinho\r\n" + 
				"ON carrinho.fk_produtoId = produto.IdProduto;";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, idCarrinho);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					carrinho.setIdCarrinho(rs.getInt("idCarrinho"));
				} else {
					carrinho.setIdCarrinho(-1);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return carrinho;
	}
	
	public ArrayList<Carrinho> listarCarrinho(Carrinho carrinho) throws IOException{
		ArrayList<Carrinho> listarCarrinho = new ArrayList<Carrinho>();
		int idProduto = 0;
		String nome = null;
		String modelo = null;
		double valor = 0.0;
		String capacidade = null;
		String cor = null;
		String base64Image = null;
		String sqlSelect = "SELECT idCarrinho, nome, modelo, valor, capacidade, cor, quantidade, subTotal, imagem_produto, fk_produtoId \r\n" + 
				"FROM produto JOIN carrinho\r\n" + 
				"ON carrinho.fk_produtoId = produto.IdProduto WHERE fk_idCliente= ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, carrinho.getCliente().getIdCliente());
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Carrinho cart = new Carrinho();
					cart.setIdCarrinho(rs.getInt("idCarrinho"));
					idProduto = rs.getInt("fk_produtoId");
					nome = rs.getString("nome");
					modelo = rs.getString("modelo");
					valor = rs.getDouble("valor");
					capacidade = rs.getString("capacidade");
					cor = rs.getString("cor");
					try {
						Blob blob = rs.getBlob("imagem_produto");
		                 
		                InputStream inputStream = blob.getBinaryStream();
		                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		                byte[] buffer = new byte[4096];
		                int bytesRead = -1;
		                 
		                while ((bytesRead = inputStream.read(buffer)) != -1) {
		                    outputStream.write(buffer, 0, bytesRead);                  
		                }
		                 
		                byte[] imageBytes = outputStream.toByteArray();
		                base64Image = Base64.getEncoder().encodeToString(imageBytes);
		                 
		                inputStream.close();
		                outputStream.close();
					}catch(SQLException e){
					    e.printStackTrace();
					}
					cart.setProduto(new Produto(idProduto, nome, modelo, valor, capacidade, cor, base64Image));
					cart.setQuantidade(rs.getInt("quantidade"));
					cart.setSubTotal(rs.getDouble("subTotal"));
					listarCarrinho.add(cart);
				}  
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listarCarrinho;
	}
}