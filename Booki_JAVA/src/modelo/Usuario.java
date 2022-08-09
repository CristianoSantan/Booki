package modelo;

public class Usuario {
	// Atributos
	private int id;
	private String nome;
	private String email;
	private String senha;
	
	private Permissoes permissoes;
	
	// Contrutores
	public Usuario() {
		
	}
	
	public Usuario(int id, String nome, String email, String senha, Permissoes permissoes) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.permissoes = permissoes;
	}
	
	// Gets e Sets
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setPermissoes(Permissoes permissoes) {
		this.permissoes = permissoes;
	}
	
	public Permissoes getPermissoes() {
		return permissoes;
	}
	
	//metodos
	public String mostrar() {
		return "Id: "+ this.id +" Nome: " +this.nome 
				+ " Email: " + this.email 
				+ " Senha: " + this.senha
				+ " Tipo permissão: " + this.permissoes.getTipo(); 
	}
	
}
