package br.com.ftt.lpII.RegistroEstoque.Negocio;

public class EnumTamanho {

	public enum Tamanho {
		P("pequeno"), M("médio"), G("grande"), GG("extra-grande");

		private String descricao;

		Tamanho(String descricao) {
			this.descricao = descricao;
		}

		public String getDescricao() {
			return descricao;
		}
	}

}
