package br.com.ftt.lpII.RegistroEstoque.Negocio;

import java.util.Date;
import java.util.LinkedList;

public class PedidoCompra {
	private int id;
	private Date dataEntrada;
	private String localCompra;
	private double valorPagoNaCompra;
	private double valorEtiquetaCompra;
	private int quantidade;
	private double valorMargemCem;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public String getLocalCompra() {
		return localCompra;
	}
	public void setLocalCompra(String localCompra) {
		this.localCompra = localCompra;
	}
	public double getValorPagoNaCompra() {
		return valorPagoNaCompra;
	}
	public void setValorPagoNaCompra(double valorPagoNaCompra) {
		this.valorPagoNaCompra = valorPagoNaCompra;
	}
	public double getValorEtiquetaCompra() {
		return valorEtiquetaCompra;
	}
	public void setValorEtiquetaCompra(double valorEtiquetaCompra) {
		this.valorEtiquetaCompra = valorEtiquetaCompra;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValorMargemCem() {
		return valorMargemCem;
	}
	public void setValorMargemCem(double valorMargemCem) {
		this.valorMargemCem = valorMargemCem;
	}
	
	
}
