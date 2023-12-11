package com.br.missSport.view;
import java.util.List;
import java.util.Scanner;
import com.br.missSport.model.Produto;
import com.br.missSport.dao.*;



public class MainView {

	public static void main(String[] args) {
		Produto produto = new Produto();
		crudDAO add_produtos = new crudDAO();
		Scanner entrada = new Scanner(System.in);
		boolean sair = false;	
		
		
		
		while (!sair) {
		System.out.println("1- Adicione um produto "+"\n2- Atualizar dados do produto "+"\n3-Deletar produto" + "\n4-Ler a lista" + "\n0-Sair do programa");
		int opcao = entrada.nextInt();
		switch (opcao) {
		case 1:   {
			System.out.println("Insira os produtos na tabela:");
			System.out.println("EAN:");
			produto.setEan(entrada.nextInt());
			System.out.println("Nome do produto");
			produto.setNomeProduto(entrada.next());
			System.out.println("Preco:");
			produto.setPreco(entrada.nextFloat());
			System.out.println("Categoria: \n Roupas \n Acessorios \n Calcados \n Suplementos \n Equipamentos");
			produto.setCategoria(entrada.next());
			add_produtos.create(produto); 
		
		}
		break;
		
		case 2:
		{
			
			List<Produto> listaProdutos = add_produtos.read();
			for (Produto produto1 : listaProdutos) {
				System.out.println("Nome do produto: "+ produto1.getNomeProduto());
				System.out.println("Preco: " + produto1.getPreco());
				System.out.println("Categoria" + produto1.getCategoria());
				System.out.println("EAN: " + produto1.getEan());
				
			}
			    
			System.out.println("Atualize os produtos");
			System.out.println("Nome do produto");
			produto.setNomeProduto(entrada.next());
			System.out.println("Preco:");
			produto.setPreco(entrada.nextFloat());
			System.out.println("Categoria: \n Roupas \n Acessorios \n Calcados \n Suplementos \n Equipamentos");
			produto.setCategoria(entrada.next());
			System.out.println("EAN:");
			produto.setEan(entrada.nextInt());
			add_produtos.update(produto);
			System.out.println("Nome do produto: "+ produto.getNomeProduto());
			System.out.println("Preco: " + produto.getPreco());
			System.out.println("Categoria" + produto.getCategoria());
			System.out.println("EAN: " + produto.getEan());
		}
			break;
		case 3:
			
			List<Produto> listaProdutos = add_produtos.read();
			for (Produto produto1 : listaProdutos) {
				System.out.println("Nome do produto: "+ produto1.getNomeProduto());
				System.out.println("Preco: " + produto1.getPreco());
				System.out.println("Categoria" + produto1.getCategoria());
				System.out.println("EAN: " + produto1.getEan());
			}
			
			crudDAO deletar_aluno = new crudDAO();
			System.out.println("Delete o produto de acordo com EAN");
			deletar_aluno.delete(entrada.nextInt());
			break;
			
		case 4:
			
			for (Produto olho :  add_produtos.read()) {//ler a lista 
				System.out.println("Nome do produto: "+ olho.getNomeProduto());
				System.out.println("Preco: " + olho.getPreco());
				System.out.println("Categoria" + olho.getCategoria());
				System.out.println("EAN: " + olho.getEan());
			}
			break;
		
		  case 0:
              sair = true;
              System.out.println("Saindo do programa.");
              break;

          default:
              System.out.println("Selecione uma opção válida.");
             
		}// switch end
		}
		} // while end

	
	}
		
		
		
		
		
		
		
		
	
		
		

	


