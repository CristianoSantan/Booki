package model;

public class Autores {
	// Atributos
	private int id;
	private String nome;
	private String imagem;
	// Contrutores
	public Autores() {
	}
	
	public Autores(int id, String nome, String imagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.imagem = imagem;
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

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	// ToString
	@Override
	public String toString() {
		return "Autores [id=" + id + ", nome=" + nome + "]";
	}
	
	
}
