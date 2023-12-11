package com.br.missSport.model;

public class Produto {
	private String NomeProduto;
	private int ean;
	private float preco;
	private String categoria;
	
	
	public Produto() {
		
	}
	public int getEan() {
		return ean;
	}
	public void setEan(int ean) {
		this.ean = ean;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getNomeProduto() {
		return NomeProduto;
	}


	public void setNomeProduto(String nomeProduto) {
		NomeProduto = nomeProduto;
	}
	
	
}
