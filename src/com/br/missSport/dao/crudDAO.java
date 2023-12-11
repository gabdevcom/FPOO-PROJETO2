package com.br.missSport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.br.missSport.controller.Conexao;
import com.br.missSport.model.Produto;




public class crudDAO {

	public void create(Produto produto) {
		String sql = "INSERT INTO catalogo(ean, NomeProduto, preco, categoria) VALUES (?,?,?,?)";
	    Connection conn = null;
	    PreparedStatement p = null;
	    try {
	        conn = Conexao.criandoConexao();
	        p = conn.prepareStatement(sql);
	        p.setInt(1, produto.getEan());
	        p.setString(2, produto.getNomeProduto());
	        p.setFloat(3, produto.getPreco());
	        p.setString(4, produto.getCategoria());
	        p.execute();
	        JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso");
	        System.out.println("Dados inseridos com sucesso");
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Erro ao inserir dados\nERRO: " + e);
	        e.printStackTrace();
	    } finally {
	        try {
	            if (p != null) {
	                p.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
 //fim create
	
	//metodo update 
	
	public void update(Produto produto) {
	    String sql = "UPDATE catalogo SET NomeProduto = ?, categoria = ?, preco = ? WHERE ean = ?";
	    Connection conn = null;
	    PreparedStatement p = null;
	    try {
	        conn = Conexao.criandoConexao();
	        p = conn.prepareStatement(sql);
	        p.setString(1, produto.getNomeProduto());
	        p.setString(2, produto.getCategoria());
	        p.setFloat(3, produto.getPreco());
	        p.setInt(4, produto.getEan());
	        p.execute();
	        JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso");
	        System.out.println("Dados atualizados com sucesso");
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Erro ao atualizar dados\nERRO: " + e);
	        e.printStackTrace();
	    } finally {
	        try {
	            if (p != null) {
	                p.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
			//*******************************************
	public List<Produto> read() {
	    String sql = "SELECT * FROM catalogo";
	    List<Produto> produtos = new ArrayList<Produto>();
	    Connection conn = null;
	    PreparedStatement p = null;
	    ResultSet resultado = null;

	    try {
	        conn = Conexao.criandoConexao();
	        p = conn.prepareStatement(sql);
	        resultado = p.executeQuery();
	        while (resultado.next()) {
	            Produto ver_produto = new Produto();

	            ver_produto.setEan(resultado.getInt("ean"));
	            ver_produto.setPreco(resultado.getFloat("preco"));
	            ver_produto.setNomeProduto(resultado.getString("NomeProduto"));
	            ver_produto.setCategoria(resultado.getString("categoria"));

	            produtos.add(ver_produto);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (p != null) {
	                p.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return produtos;
	}
// metodo de leitura 
			//*******************************************************************
			//metodo delete 
			public boolean delete(int ean) {
				String sql = "DELETE FROM catalogo WHERE ean = ?";
				Connection conn = null;
				PreparedStatement p = null;
				
				try {
					conn = Conexao.criandoConexao();
					p = (PreparedStatement)  conn.prepareStatement(sql);
					p.setInt(1, ean);
					p.execute();
					JOptionPane.showMessageDialog(null, "Dados deletados com sucesso");
					System.out.println("Dados deletados com sucesso");
				} catch (Exception e ) {
					JOptionPane.showMessageDialog(null, "Erro ao inserir dados /n ERRO" + e );
				} finally {
					try {
						if(p != null );
						p.close();
					}catch(Exception e){
						e.printStackTrace();
					}
				} return false;
			}// fim delete
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
