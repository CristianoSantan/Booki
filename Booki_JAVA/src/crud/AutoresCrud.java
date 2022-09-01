package crud;

import java.util.Scanner;

import dao.AutoresDAO;
import modelo.Autores;

public class AutoresCrud {

	public static void main(String[] args) {
		
		AutoresDAO autorDAO = new AutoresDAO();

		Scanner s = new Scanner(System.in);
		int opcao = 0;
		int posicao = 0;

		int id = 0;
		String nome = "";

		do {
			
			System.out.println("=== CRUD AUTORES ===");
			System.out.println("1 - Cadastrar autores");
			System.out.println("2 - Consultar autores");
			System.out.println("3 - Atualizar autores");
			System.out.println("4 - Deletar autores");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				// CREATE
				System.out.println("Digite o nome do autor(a): ");
				nome = s.nextLine();
				
				Autores a1 = new Autores(id, nome);
				
				autorDAO.save(a1);
				
				System.out.println("\n***  Cadastrou  ***\n");

				break;
			case 2:
				// READ
				for (Autores a : autorDAO.getAutores()) {
					System.out.println("Id: " + a.getId() + " Nome: " + a.getNome());
				}
				
				System.out.println("consultou");
				break;
			case 3:
				// UPDATE
				System.out.println("Digite o id do autor: ");
				posicao = s.nextInt();
				s.nextLine();
				System.out.println("Digite o nome do autor: ");
				nome = s.nextLine();
				
				Autores a2 = new Autores(posicao, nome);
			
				autorDAO.update(a2);
	
				System.out.println("atualizou");
				break;
			case 4:
				// DELETE
				System.out.println("Digite o id do autor: ");
				posicao = s.nextInt();
				
				autorDAO.deleteById(posicao);
				
				break;
			case 5:
				// buscar por id
				System.out.println("Digite o id do autor: ");
				posicao = s.nextInt();
				
				Autores a3 = autorDAO.getAutorById(posicao);
				
				System.out.println("Id: " + a3.getId() + " Nome: " + a3.getNome());
				
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
