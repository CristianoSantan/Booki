package crud;

import java.util.Arrays;

import modelo.Autores;
import modelo.Compras;
import modelo.Editoras;
import modelo.Itens_compra;
import modelo.Livros;
import modelo.Permissoes;
import modelo.Usuario;

public class Principal {

	public static void main(String[] args) {
		
		Permissoes p1 = new Permissoes(1, "comum");
		Permissoes p2 = new Permissoes(2, "administrador");
		
		Usuario u1 = new Usuario(1, "Jo�o", "joao@email", "1234", p2);
		Usuario u2 = new Usuario(2, "Anna", "anna@email", "4567", p1);
		Usuario u3 = new Usuario(3, "Jos�", "jose@email", "7891", p1);
		
		System.out.println(u1.mostrar());
		System.out.println(u2.mostrar());
		System.out.println(u3.mostrar());
		
		Autores a1 = new Autores(1, "Joana");
		Autores a2 = new Autores(2, "Marcos");
		
		Editoras e1 = new Editoras(1, "Atlas");
		Editoras e2 = new Editoras(2, "alfa");
		
		Livros l1 = new Livros(1, "harry Poter", 50, "20/05/1995", e1, a2);
		Livros l2 = new Livros(2, "Narnia", 45, "25/05/1990", e2, a1);
		
		Compras c1 = new Compras(1, "01/08/2022", u3);
		
		Itens_compra i1 = new Itens_compra(1, 3, c1, l1);
		Itens_compra i2 = new Itens_compra(2, 1, c1, l2);
		
		c1.getItens().addAll(Arrays.asList(i1));
		c1.getItens().addAll(Arrays.asList(i2));
		
		System.out.println("\n\nUsuario: " + c1.getUsuario().getNome() 
				+ " \nLivro 1: " + c1.getItens().get(0).getValor()
				+ " \nLivro 2: " + c1.getItens().get(1).getValor()
				+ " \nValor compra: "	+ c1.getValor());
	}

}
