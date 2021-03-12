package br.com.ftt.lpII.RegistroEstoque.Negocio;


public class PedidoDeCompra {
	private int id;
	private String dataEntrada;
	private String localCompra;
	private double valorPagoNaCompra;
	private double valorEtiquetaCompra;
	private int quantidade;
	private double valorMargemCem;
	
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(String dataEntrada) {
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
		this.valorMargemCem = getValorPagoNaCompra() * 2;
	}
	
	@Override
	public String toString() {
		return String.format("%013d | %12s | %12s | %17.2f | %21.5f | %10d | %17.2f %n",
				this.getId(), 
				this.getLocalCompra(),
				this.getDataEntrada(),
				this.getValorPagoNaCompra(),
				this.getValorEtiquetaCompra(),
				this.getQuantidade(),
				this.getValorMargemCem());
	}
	
}
