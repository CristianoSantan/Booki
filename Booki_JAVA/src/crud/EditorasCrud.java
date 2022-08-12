package crud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import modelo.Editoras;

public class EditorasCrud {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int opcao = 0;
		int posicao = 0;

		int id = 0;
		String nome = "";

		List<Editoras> editoras = new ArrayList<Editoras>();

		do {
			System.out.println("=== CRUD Editoras ===");
			System.out.println("1 - Cadastrar Editoras");
			System.out.println("2 - Consultar Editoras");
			System.out.println("3 - Atualizar Editoras");
			System.out.println("4 - Deletar Editoras");
			System.out.println("0 - Sair");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				// CREATE
				System.out.println("Digite o nome da editora: ");
				nome = s.nextLine();
				
				Editoras e1 = new Editoras(id, nome);
				
				editoras.addAll(Arrays.asList(e1));
				
				id++;
				
				System.out.println("\n***  Cadastrou  ***\n");

				break;
			case 2:
				// READ
				for (Editoras e : editoras) {
					System.out.println("Id: " + e.getId() + " Nome: " + e.getNome());
				}
				System.out.println("consultou");
				break;
			case 3:
				// UPDATE
				System.out.println("Digite o id da editora: ");
				posicao = s.nextInt();
				s.nextLine();
				System.out.println("Digite o nome da editora: ");
				nome = s.nextLine();
				
				Editoras e2 = new Editoras(posicao, nome);
				
				for (int i = 0; i < editoras.size(); i++) {
					if (posicao == editoras.get(i).getId()) {
						System.out.println("\nVocê atualizou a editora: " + editoras.get(i).getNome());
						Collections.replaceAll(editoras, editoras.get(i), e2);
					}
				}
	
				System.out.println("atualizou");
				break;
			case 4:
				// DELETE
				System.out.println("Digite o id do autor: ");
				posicao = s.nextInt();
				
				for (int i = 0; i < editoras.size(); i++) {
					if (posicao == editoras.get(i).getId()) {
						System.out.println("\nVocê removeu o autor: " + editoras.get(i).getNome());
						editoras.remove(i);
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
