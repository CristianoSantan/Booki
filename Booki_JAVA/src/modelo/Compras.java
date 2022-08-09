package modelo;

import java.util.ArrayList;
import java.util.List;

public class Compras {
	//Atributos
	private int id;
	private String data;
	private double valor;
	
	private Usuario usuario;
	
	private List<Itens_compra> itens = new ArrayList<Itens_compra>();
	
	//Construtores
	public Compras() {
		
	}
	
	public Compras(int id, String data, Usuario usuario) {
		this.id = id;
		this.data = data;
		this.usuario = usuario;
	}

	//Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getValor() {
		return valorCompra();
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Itens_compra> getItens() {
		return itens;
	}

	public void setItens(List<Itens_compra> itens) {
		this.itens = itens;
	}

	//Metodo mostrar
	@Override
	public String toString() {
		return "Compras [id=" + id + ", data=" + data + ", valor=" + valor + "]";
	}
	
	public double valorCompra() {
		for (int i = 0; i < itens.size(); i++) {
			this.valor += itens.get(i).getValor();
		}
		return this.valor;
	}
}
