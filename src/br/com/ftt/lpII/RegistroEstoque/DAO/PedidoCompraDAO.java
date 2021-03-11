package br.com.ftt.lpII.RegistroEstoque.DAO;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

import br.com.ftt.lpII.RegistroEstoque.Negocio.PedidoCompra;

public class PedidoCompraDAO {
	
	public void Cadastrar(PedidoCompra pedidoCompra) throws Exception {
		int ultimoId = this.Carrega().getLast().getId();
		System.out.println(ultimoId);
		
		pedidoCompra.setId(ultimoId++);
		pedidoCompra.setDataEntrada("");
	}
	
	public LinkedList<PedidoCompra> Carrega() throws Exception {
		// Instancia objeto de leitura do arquivo
		Scanner scanner = new Scanner(new File("PedidoCompra.csv"));
		
		// Instancia lista para armazenar pedidos lidos no arquivo
		LinkedList<PedidoCompra> colecao = new LinkedList<PedidoCompra>();		
		
		while (scanner.hasNextLine()) {
			// fraciona objeto de leitura em linhas
			String linha = scanner.nextLine();
			
			// instancia novo objeto de leitura agora da linha fracionada
			// necessário para adiocionar delimitador (;)
			Scanner linhaScanner = new Scanner(linha);
			
			// Adiciona o delimitados de dados
			linhaScanner.useDelimiter(";");
			
			// Acrescenta pedido de compra na lista
			colecao.add(compoe(linhaScanner));
		}		
		return colecao;
	}
	
	private PedidoCompra compoe(Scanner linhaScanner) {		
		// Instancia novo objeto
		PedidoCompra pedidoCompra = new PedidoCompra();

		// Conpoe Objeto
		pedidoCompra.setId(linhaScanner.nextInt());
//		pedidoCompra.dataEntrada(linhaScanner.next());
		pedidoCompra.setLocalCompra(linhaScanner.next());
		pedidoCompra.setValorPagoNaCompra(linhaScanner.nextInt());
		pedidoCompra.setValorEtiquetaCompra(linhaScanner.nextDouble());
		pedidoCompra.setQuantidade(linhaScanner.nextInt());
		pedidoCompra.setValorMargemCem(linhaScanner.nextInt());		
		
		return pedidoCompra;
	}
	
	public void Listagem() throws Exception {
		System.out.println("Pedidos de Compras: ");
		System.out.format("%s | %s | %s | %s | %s | %s %n",
				"Numero Pedido",
				"Local Compra", 
				"Valor Pago compra", 
				"Valor Etiqueta Compra",
				"Quantidade", 
				"Valor Margem 100%" );
		
		for (PedidoCompra pedidoCompra : this.Carrega()) {
			System.out.format("%013d | %12s | %17.2f | %21.5f | %10d | %17.2f %n%n",
					pedidoCompra.getId(), 
					pedidoCompra.getLocalCompra(),
					pedidoCompra.getValorPagoNaCompra(),
					pedidoCompra.getValorEtiquetaCompra(),
					pedidoCompra.getQuantidade(),
					pedidoCompra.getValorMargemCem());
		}
	}
}
