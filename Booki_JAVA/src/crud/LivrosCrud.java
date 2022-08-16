package crud;

import java.util.Scanner;

import dao.AutoresDAO;
import dao.EditorasDAO;
import dao.LivroDAO;
import modelo.Autores;
import modelo.Editoras;
import modelo.Livros;

public class LivrosCrud {

	public static void main(String[] args) {
		LivroDAO livroDAO = new LivroDAO();
		EditorasDAO editoraDAO = new EditorasDAO();
		AutoresDAO autorDAO = new AutoresDAO();

		Scanner s = new Scanner(System.in);
		int opcao = 0;
		int posicao = 0;

		int id = 0;
		String nome = "";
		double preco = 0;
		String publicacao = "";
		int id_autor = 0;
		int id_editora = 0;

		do {
			System.out.println("=== CRUD Livros ===");
			System.out.println("1 - Cadastrar Livros");
			System.out.println("2 - Consultar Livros");
			System.out.println("3 - Atualizar Livros");
			System.out.println("4 - Deletar Livros");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				// CREATE
				System.out.println("Digite o nome do Livro: ");
				nome = s.nextLine();
				System.out.println("Digite o preco do Livro: ");
				preco = s.nextDouble();
				s.nextLine();
				System.out.println("Digite o publicacao do Livro: ");
				publicacao = s.nextLine();
				System.out.println("Digite o id do editora: ");
				id_editora = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do autor: ");
				id_autor = s.nextInt();
				s.nextLine();
				
				Editoras editora = editoraDAO.getEditoraById(id_editora);
				Autores autor = autorDAO.getAutorById(id_autor);

				Livros l1 = new Livros(id, nome, preco, publicacao, editora, autor);

				livroDAO.save(l1);

				System.out.println("\n***  Cadastrou  ***\n");

				break;
			case 2:
				// READ
				for (Livros l : livroDAO.getLivros()) {
					System.out.println("Id: " + l.getId() + " Nome: " + l.getNome() 
					+ " Autor(a): "+ l.getAutores().getNome() +" Editora:" + l.getEditoras().getNome());
				}

				System.out.println("consultou");
				break;
			case 3:
				// UPDATE
				System.out.println("Digite o id do Livro: ");
				posicao = s.nextInt();
				s.nextLine();
				System.out.println("Digite o nome do Livro: ");
				nome = s.nextLine();
				System.out.println("Digite o preco do Livro: ");
				preco = s.nextDouble();
				s.nextLine();
				System.out.println("Digite o publicacao do Livro: ");
				publicacao = s.nextLine();
				System.out.println("Digite o id do editora: ");
				id_editora = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do autor: ");
				id_autor = s.nextInt();
				s.nextLine();
				
				Editoras editora1 = editoraDAO.getEditoraById(id_editora);
				Autores autor1 = autorDAO.getAutorById(id_autor);

				Livros l2 = new Livros(id, nome, preco, publicacao, editora1, autor1);

				livroDAO.update(l2);

				System.out.println("atualizou");
				break;
			case 4:
				// DELETE
				System.out.println("Digite o id do Livro: ");
				posicao = s.nextInt();

				livroDAO.deleteById(posicao);

				break;
			case 5:
				// buscar por id
				System.out.println("Digite o id do Livro: ");
				posicao = s.nextInt();

				Livros l3 = livroDAO.getLivroById(posicao);

				System.out.println("Id: " + l3.getId() + " Nome: " + l3.getNome() 
				+ " Autor(a): "+ l3.getAutores().getNome() +" Editora:" + l3.getEditoras().getNome());

				break;
			default:
				System.out.println(opcao != 0 ? "opção invalida, digite novamente." : "");
				break;

			}

		} while (opcao != 0);

		System.out.println("Até mais!");
		s.close();
	}

}
