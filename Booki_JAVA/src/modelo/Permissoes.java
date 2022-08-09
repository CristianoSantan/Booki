package modelo;

public class Permissoes {
	// Atributos
	private int id;
	private String tipo;
	
	//Construtor
	public Permissoes() {
		
	}
	
	public Permissoes(int id, String tipo) {
		this.id = id;
		this.tipo = tipo;
	}
	
	//Geters e Seters
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	//Metodo mostrar
	public String mostrar() {
		return "Id: " + this.id + " tipo: " + this.tipo ;
	}
}
