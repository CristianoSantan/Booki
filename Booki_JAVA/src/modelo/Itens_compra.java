package modelo;

public class Itens_compra {
	// Atributos
	private int id;
	private int qtd_itens;
	private double valor;
	
	private Compras compras;
	private Livros livros;

	// Contrutores
	public Itens_compra() {
	}

	public Itens_compra(int id, int qtd_itens, Compras compras, Livros livros) {
		this.id = id;
		this.qtd_itens = qtd_itens;
		valorItens(livros.getPreco());
		this.compras = compras;
		this.livros = livros;
	}

	// Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQtd_itens() {
		return qtd_itens;
	}

	public void setQtd_itens(int qtd_itens) {
		this.qtd_itens = qtd_itens;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Compras getCompras() {
		return compras;
	}

	public void setCompras(Compras compras) {
		this.compras = compras;
	}
	
	public Livros getLivros() {
		return livros;
	}

	public void setLivros(Livros livros) {
		this.livros = livros;
	}

	// ToString
	@Override
	public String toString() {
		return "Itens_compra [id=" + id + ", qtd_itens=" + qtd_itens + ", valor=" + valor + ", compras=" + compras
				+ "]";
	}
	
	private void valorItens(double preco) {
		this.valor = this.qtd_itens * preco;
	}
	
}
