package sistema;

import java.util.Scanner;


import service.HandleMenuProduto;

public class SistemaProduto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		HandleMenuProduto hmp = new HandleMenuProduto();
		int opcao = 0;
		do {
			// \n
			System.out.print("1 - Criar \n2 - Editar \n3 - Deletar \n4 - Listar \n9 - Sair\n");
			
			// 5 - Listar especifico
			// Qual id voce deseja vizualizar?
			// 4
			// Objeto N4
			opcao = sc.nextInt();
			
			switch (opcao) {
			case 1: { 
				hmp.criar();
				break;
			}
			case 2: {
				hmp.editar();
				break;
			}
			case 3: {
				hmp.deletar();
				break;
			}
			case 4: {
				hmp.listarProduto();
				break;
			}
			case 5: {
				hmp.listUnico();
				break;
			}
			default:
				System.out.println("Opção Invalida");
				break;
			}
		
		}
		while (opcao != 9);
		sc.close();

		
		
		
		
		
		
		
		
		
		
	}

}
