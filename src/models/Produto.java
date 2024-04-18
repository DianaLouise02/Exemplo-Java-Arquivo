package models;

public class Produto {

	
	// id => 214748647 int
	// id => 9.223.372.036.854.755.807 long
	private long id;
	

	private String nome;
	private double preco;
	private int quantidade;
	

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id =id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto(long id, String nome, double preco, int quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	
	
}
