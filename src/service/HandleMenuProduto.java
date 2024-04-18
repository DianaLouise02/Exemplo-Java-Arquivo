package service;

import java.util.List;
import java.util.Scanner;

import models.Produto;
import models.Usuario;
import utils.GerenciadorDeProdutos;


public class HandleMenuProduto {

	
	Scanner sc = new Scanner(System.in);
	//Gerenciador
		GerenciadorDeProdutos ps = new GerenciadorDeProdutos();
		
		// Construtor vazio
		public HandleMenuProduto() {
			//Toda vez que a classe menu, for instanciada, o nosso arquivo sera verificado
			ps.verificaECria("produtos.txt");
		}
		public void criar() {
			System.out.println("Digite o nome do produto:");
			String nome = sc.next();
			System.out.println("Digite o id:");
			long id = sc.nextInt();
			
			
			
			Produto p = new Produto(2147483647, "Playstation 5", 4200.25, 8);
			ps.adicionarProduto(p);
			
		}
		
		public void editar() {
			System.out.println("Digite o ID do Produto:");
			long id = sc.nextInt();
			
			System.out.println("Digite o novo nome:");
			String nome = sc.next();
			
			System.out.println("Digite o novo preço:");
			Double preco = sc.nextDouble();
			
			System.out.println("Digite a quantidade:");
			int quantidade = sc.nextInt();

			
			ps.editarProduto(id, nome, preco, quantidade);
		}
		
		public void deletar () {
			System.out.println("Digite o ID do usuario a ser deletado:");
			long id = sc.nextInt();
			ps.deletarProduto(id);
		}
		public void listarProduto() {
			ps.lerProdutos();
		}

		private int getNextId() {
			List<Produto> produtos = ps.lerProdutos();
			int maxId = 0;
			// for => foreach
			// Unico usuario : Lista com todos 
			for(Produto produto : produtos) {
				long id = produto.getId();
				//1
				if(id > maxId) {
					//Logica para descobrir ultimo id
					maxId = (int)id;
				
				}
			}
			// Soma 1 + o ultimo
			return maxId + 1;
		}

	    public void listUnico() {
		System.out.println("Digite o ID do produto");
		long id = sc.nextInt();
		ps.locProduto(id);
	}
	
	
	
	
	
	
	
	
	
}
