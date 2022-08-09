package modelo;

public class Livros {
	// Atributos
	private int id;
	private String nome;
	private double preco;
	private String publicacao;
	
	private Editoras editoras;
	private Autores autores;
	
	// Construtores
	public Livros() {
	}
	
	public Livros(int id, String nome, double preco, String publicacao, Editoras editoras, Autores autores) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.publicacao = publicacao;
		this.editoras = editoras;
		this.autores = autores;
	}
	// Getters e Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(String publicacao) {
		this.publicacao = publicacao;
	}

	public Editoras getEditoras() {
		return editoras;
	}

	public void setEditoras(Editoras editoras) {
		this.editoras = editoras;
	}

	public Autores getAutores() {
		return autores;
	}

	public void setAutores(Autores autores) {
		this.autores = autores;
	}
	// ToString

	@Override
	public String toString() {
		return "Livros [id=" + id + ", nome=" + nome + ", preco=" + preco + ", publicacao=" + publicacao + ", editoras="
				+ editoras + ", autores=" + autores + "]";
	}
}
