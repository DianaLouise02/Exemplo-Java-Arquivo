package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Produto;
import models.Usuario;

public class GerenciadorDeProdutos {

	
	private static final String NOME_ARQUIVO = "produtos.txt";
	
	// Verificar a existencia do nosso bando e criar caso não exista
	public void verificaECria(String nomeArquivo) {
		// file => arquivo
		File arquivo = new File(nomeArquivo);
		// Verificar se o arquivo existe 
		if(arquivo.exists()) {
			System.out.println("Banco funcionando!");
		} else {
			// tente criar, caso de erro, exiba o erro
			try {
				arquivo.createNewFile();
				System.out.println("Arquivo criado com sucesso!");
			} catch (IOException e) {
				System.out.println("Ocorreu um erro ao criar o arquivo: " + e.getMessage());
			}
		}
	}
	
	public void adicionarProduto(Produto produto) {
		//Writer => Escrever
		//BufferreWriter , FileWrite
		//BufferedWriter, proporciona uma escrita eficiente
		//FileWrite, escreve dentro de arquivo
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
			bw.write(produto.toString()); 
			bw.newLine(); // nova linha no arquivo txt
			System.out.println("Usuario adicionado com sucesso!");
		}	catch (IOException e) {
			System.out.println("Ocorreu um erro ao escrever no arquivo: " +e.getMessage());
		}
	}
	
	public List<Produto> lerProdutos() {
		List<Produto> produtos = new ArrayList<Produto>();
		// Buffed, File, Reader
		try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))){
			
			String linha; //linha => 1;mome;senha
			//percorrer todas as linhas enquanto seja diferente de vazio
			while((linha = br.readLine()) != null) {
				String[] partes = linha.split(";"); //DIVIDIR EM TRES PARTES
				produtos.add( new Produto(0, linha, 0, 0));
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
		}
		return produtos;
	}
 
	
	public void deletarProduto(long id) {
		List<Produto> produtos = lerProdutos();
		
		if(produtos.removeIf(produto -> produto.getId() == id)) {
			//Reescrevendo arquivo com novos usuarios e alterações
		reescreverArquivo(produtos);
			System.out.println("Usuario deletado com sucesso");
		} else { 
			System.out.println("Usuario nao encontrado");
			
		}
	}
	
	public void reescreverArquivo(List<Produto> produtos) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
			for(Produto produto : produtos) {
				bw.write(produto.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao reescrever o arquivo: " + e.getMessage());
		}
	}

	
	

    public void listarProdutos() {
    	List<Produto> produtos = lerProdutos();

    	// nenhum usuario
    	if(produtos.isEmpty()) {
    		System.out.println("Lista de produtos");
    		for (Produto produto : produtos) {
    			System.out.println("ID: " + produto.getId() + ", Nome: " + "" + produto.getNome() + ", Preço: " + produto.getPreco() + produto.getQuantidade());
    		}
    	}
    }


public void editarProduto(long id, String novoNome, double novoPreco, int novaQuantidade) {
	List<Produto> produtos = lerProdutos();
	boolean encontrado = false;
	
	for (Produto produto : produtos) {
		if(produto.getId() == id) {
			produto.setNome(novoNome);
			produto.setPreco(novoPreco);
			produto.setQuantidade(novaQuantidade);
			encontrado = true;
			break;
		}
	}
	if(encontrado) {
		reescreverArquivo(produtos);
		System.out.println("Produto editado com sucesso!");
	} else {
		System.out.println("Produto não encontrado");
		
	}
}






public void locProduto(long id) {
	// TODO Auto-generated method stub
	List<Produto> produtos = lerProdutos();
	for (Produto produto : produtos) {
	if(produtos.isEmpty()) {
		System.out.println("Nenhum produto cadastrado");
	}else if(produto.getId() == id) {
		System.out.println("Lista de produtos");
			System.out.println("ID: " + produto.getId() + ", Nome: " + "" + produto.getNome() + ", Preço: " + produto.getPreco() + ", Quantidade: " + produto.getQuantidade());
	}
	
}
}
}
	

