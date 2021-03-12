package br.com.ftt.lpII.RegistroEstoque.Negocio;

public class Produto {
	private int codigoItem;
	private String nome;
	private String tipoItem;
	private String Marca;
	private String caracteristicas;
	private Enum tamanho;
	private Enum cor;
	private double precoSugerido;
	
	public int getCodigoItem() {
		return codigoItem;
	}
	public void setCodigoItem(int codigoItem) {
		this.codigoItem = codigoItem;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipoItem() {
		return tipoItem;
	}
	public void setTipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public Enum getTamanho() {
		return tamanho;
	}
	public void setTamanho(Enum tamanho) {
		this.tamanho = tamanho;
	}
	public Enum getCor() {
		return cor;
	}
	public void setCor(Enum cor) {
		this.cor = cor;
	}
	public double getPrecoSugerido() {
		return precoSugerido;
	}
	public void setPrecoSugerido(double precoSugerido) {
		this.precoSugerido = precoSugerido;
	}

}
