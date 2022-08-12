package crud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

		List<Autores> autores = new ArrayList<Autores>();

		do {
			System.out.println("=== CRUD AUTORES ===");
			System.out.println("1 - Cadastrar autores");
			System.out.println("2 - Consultar autores");
			System.out.println("3 - Atualizar autores");
			System.out.println("4 - Deletar autores");
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
				
				autores.addAll(Arrays.asList(a1));
				
				id++;
				
				System.out.println("\n***  Cadastrou  ***\n");

				break;
			case 2:
				// READ
				for (Autores a : autores) {
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
				
				for (int i = 0; i < autores.size(); i++) {
					if (posicao == autores.get(i).getId()) {
						System.out.println("\nVocê atualizou o autor: " + autores.get(i).getNome());
						Collections.replaceAll(autores, autores.get(i), a2);
					}
				}
	
				System.out.println("atualizou");
				break;
			case 4:
				// DELETE
				System.out.println("Digite o id do autor: ");
				posicao = s.nextInt();
				
				for (int i = 0; i < autores.size(); i++) {
					if (posicao == autores.get(i).getId()) {
						System.out.println("\nVocê removeu o autor: " + autores.get(i).getNome());
						autores.remove(i);
					}
				}
				
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
