package crud;

import java.util.Scanner;

import dao.EditorasDAO;
import modelo.Editoras;

public class EditorasCrud {

	public static void main(String[] args) {
		EditorasDAO editoraDAO = new EditorasDAO();

		Scanner s = new Scanner(System.in);
		int opcao = 0;
		int posicao = 0;

		int id = 0;
		String nome = "";

		do {
			System.out.println("=== CRUD Editoras ===");
			System.out.println("1 - Cadastrar Editoras");
			System.out.println("2 - Consultar Editoras");
			System.out.println("3 - Atualizar Editoras");
			System.out.println("4 - Deletar Editoras");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				// CREATE
				System.out.println("Digite o nome do editora: ");
				nome = s.nextLine();
				
				Editoras e1 = new Editoras(id, nome);
				
				editoraDAO.save(e1);
				
				System.out.println("\n***  Cadastrou  ***\n");

				break;
			case 2:
				// READ
				for (Editoras e : editoraDAO.getEditoras()) {
					System.out.println("Id: " + e.getId() + " Nome: " + e.getNome());
				}
				
				System.out.println("consultou");
				break;
			case 3:
				// UPDATE
				System.out.println("Digite o id do editora: ");
				posicao = s.nextInt();
				s.nextLine();
				System.out.println("Digite o nome do editora: ");
				nome = s.nextLine();
				
				Editoras e2 = new Editoras(posicao, nome);
			
				editoraDAO.update(e2);
	
				System.out.println("atualizou");
				break;
			case 4:
				// DELETE
				System.out.println("Digite o id do editora: ");
				posicao = s.nextInt();
				
				editoraDAO.deleteById(posicao);
				
				break;
			case 5:
				// buscar por id
				System.out.println("Digite o id do editora: ");
				posicao = s.nextInt();
				
				Editoras e3 = editoraDAO.getEditoraById(posicao);
				
				System.out.println("Id: " + e3.getId() + " Nome: " + e3.getNome());
				
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
