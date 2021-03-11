package br.com.ftt.lpII.RegistroEstoque.Aplicacao;

import java.util.Scanner;

import br.com.ftt.lpII.RegistroEstoque.DAO.PedidoCompraDAO;
import br.com.ftt.lpII.RegistroEstoque.Negocio.PedidoCompra;

public class Aplicacao {

	public static void main(String[] args) {
		
		try {			
			Scanner s = new Scanner(System.in);

			int opcao = 0;			
			do {
				
				System.out.println("Informe a opção desejada.");
				System.out.println("1 - Cadastrar Pedido de Compra");
				System.out.println("2 - Listar Pedidos de Compra");

				PedidoCompraDAO pedidoCompraDAO = new PedidoCompraDAO();
				
				opcao = s.nextInt();
				s.nextLine();
				
				switch (opcao) {
				case 1:
					PedidoCompra pedidoCompra = new PedidoCompra();
					pedidoCompraDAO.Cadastrar(pedidoCompra);
					
					break;
					
				case 2:
					
					pedidoCompraDAO.Listagem();
					
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
