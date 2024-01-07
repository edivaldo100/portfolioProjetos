package br.com.edivaldo.enuns;

public enum Risco {
	BAIXO("baixo"), MEDIO("médio"), ALTO("alto");

	private String descricao;

	Risco(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
