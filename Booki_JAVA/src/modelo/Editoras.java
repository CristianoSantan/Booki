package modelo;

public class Editoras {
	// Atributos
	private int id;
	private String nome;
	//Contrutores
	public Editoras() {
	}
	
	public Editoras(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	//Getters e Setters

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
	//ToString

	@Override
	public String toString() {
		return "Editoras [id=" + id + ", nome=" + nome + "]";
	}
	
}
