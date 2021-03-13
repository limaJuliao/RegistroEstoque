package br.com.ftt.lpII.RegistroEstoque.DAO;

import java.util.LinkedList;
import java.util.Scanner;

import br.com.ftt.lpII.RegistroEstoque.Negocio.PedidoDeCompra;


public class PedidoCompraDAO {
	private LinkedList<PedidoDeCompra> pedidoDeCompraLista;
	
	public String select() throws Exception {
		montaPedidoDeCompraLista();
		return Listagem();
	}
	
	public void create() throws Exception {
		PedidoDeCompra pedidoDeCompra = new PedidoDeCompra();
		montaPedidoDeCompra(pedidoDeCompra);
		save(pedidoDeCompra);
	}
	
	private void montaPedidoDeCompra(PedidoDeCompra pedidoDeCompra) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Informe a data de entrada do pedido: ");
		String dataEntrada = scanner.nextLine();
		pedidoDeCompra.setDataEntrada(dataEntrada);
		
		System.out.print("Informe o Local da compra: ");
		String localCompra = scanner.nextLine();
		pedidoDeCompra.setLocalCompra(localCompra);
		
		System.out.print("Informe o valor pago na compra: ");
		double valorPagoNaCompra = scanner.nextDouble();
		pedidoDeCompra.setValorPagoNaCompra(valorPagoNaCompra);
		
		System.out.print("Informe o valor Etiqueta na compra: ");
		double valorEtiquetaCompra = scanner.nextDouble();
		pedidoDeCompra.setValorEtiquetaCompra(valorEtiquetaCompra);
		
		System.out.print("Informe a quantidade comprada: ");
		int quantidade = scanner.nextInt();
		pedidoDeCompra.setQuantidade(quantidade);		
	}
	
	private void montaPedidoDeCompraLista() throws Exception {
		this.pedidoDeCompraLista = new LinkedList<PedidoDeCompra>();
		
		HelperTxt helperTxt = new HelperTxt("PedidoCompra.csv");
		
		Scanner scanner = helperTxt.LoadFile();

		if (scanner.hasNextLine()) {			
			//retira cabeçalho
			scanner.nextLine();
			
			while (scanner.hasNextLine()) {
				Scanner linha = new Scanner(scanner.nextLine());
				linha.useDelimiter(";");

				PedidoDeCompra pedidoDeCompra = new PedidoDeCompra();				
				pedidoDeCompra.setId(linha.nextInt());
				pedidoDeCompra.setDataEntrada(linha.next());
				pedidoDeCompra.setLocalCompra(linha.next());
				pedidoDeCompra.setValorPagoNaCompra(linha.nextDouble());
				pedidoDeCompra.setValorEtiquetaCompra(linha.nextDouble());
				pedidoDeCompra.setQuantidade(linha.nextInt());
				pedidoDeCompra.setValorMargemCem(linha.nextDouble());

				this.pedidoDeCompraLista.add(pedidoDeCompra);				
			}
		} 
		
		scanner.close();
	}
	
	public void save(PedidoDeCompra pedidoCompra) throws Exception {
		montaPedidoDeCompraLista();
		
		this.pedidoDeCompraLista.add(pedidoCompra);
		
		HelperTxt helperTxt = new HelperTxt("PedidoCompra.csv");
		
		helperTxt.SaveFile(Listagem(), "PedidoCompra.csv");
	}
		
	public String Listagem() throws Exception {
		String cabecalho = String.format("%s;%s;%s;%s;%s;%s;%s %n",
				"Numero Pedido",
				"Local Compra", 
				"Data Entrada",
				"Valor Pago compra", 
				"Valor Etiqueta Compra",
				"Quantidade", 
				"Valor Margem 100%" );
		
		String dados = "";
		
		for (PedidoDeCompra pedidoDeCompra : this.pedidoDeCompraLista) {
			dados += pedidoDeCompra.toString();
		}
		
		return cabecalho + dados;
	}
}
