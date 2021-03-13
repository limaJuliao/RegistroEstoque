package br.com.ftt.lpII.RegistroEstoque.Aplicacao;

import java.util.Scanner;

import br.com.ftt.lpII.RegistroEstoque.DAO.PedidoCompraDAO;

public class Aplicacao {

	public static void main(String[] args) {
		
		try {			
			Scanner s = new Scanner(System.in);

			int opcao = 0;			
			do {
				
				System.out.println("Informe a opção desejada.");
				System.out.println("1 - Cadastrar Pedido de Compra");
				System.out.println("2 - Listar Pedidos de Compra");
				System.out.println("9 - Sair");

				PedidoCompraDAO pedidoCompraDAO = new PedidoCompraDAO();
				
				opcao = s.nextInt();
				s.nextLine();
				
				switch (opcao) {
				case 1:
					pedidoCompraDAO.create();					
					
					break;
					
				case 2:
					System.out.println(pedidoCompraDAO.select());
					
					break;
					
				case 9:
					System.out.println("Saindo da aplicação.");
					
					break;

				default:
					break;
				}
				
			} while (opcao != 9);
			
			s.close();
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
