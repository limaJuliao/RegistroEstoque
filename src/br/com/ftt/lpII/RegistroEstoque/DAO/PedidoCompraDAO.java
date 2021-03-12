package br.com.ftt.lpII.RegistroEstoque.DAO;

import java.util.Collection;
import java.util.Collections;
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
		
		scanner.close();
	}
	
	private void montaPedidoDeCompraLista() throws Exception {
		this.pedidoDeCompraLista = new LinkedList<PedidoDeCompra>();
		
		HelperTxt helperTxt = new HelperTxt("PedidoCompra.csv");
		
		Scanner scanner = helperTxt.LoadFile();

		if (scanner.hasNextLine()) {			
			//retira cabeçalho
			scanner.nextLine();
			
			while (scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				String[] values = linha.split("|");

				PedidoDeCompra pedidoDeCompra = new PedidoDeCompra();				
				pedidoDeCompra.setId(Integer.parseInt(values[0]));
				pedidoDeCompra.setDataEntrada(values[1]);
				pedidoDeCompra.setLocalCompra(values[2]);
				pedidoDeCompra.setValorPagoNaCompra(Double.parseDouble(values[3]));
				pedidoDeCompra.setValorEtiquetaCompra(Double.parseDouble(values[4]));
				pedidoDeCompra.setQuantidade(Integer.parseInt(values[5]));
				pedidoDeCompra.setValorMargemCem(Double.parseDouble(values[6]));

				this.pedidoDeCompraLista.add(pedidoDeCompra);				
			}
		} 
		
		scanner.close();
	}
	
	public void save(PedidoDeCompra pedidoCompra) throws Exception {
		montaPedidoDeCompraLista();
		
		Collections.sort(this.pedidoDeCompraLista);
		
		this.pedidoDeCompraLista.add(pedidoCompra);
		
		HelperTxt helperTxt = new HelperTxt("PedidoCompra.csv");
		
		helperTxt.SaveFile(Listagem(), "PedidoCompra.csv");
	}
		
	public String Listagem() throws Exception {
		String cabecalho = String.format("%s | %s | %s | %s | %s | %s | %s %n",
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
