package br.com.edivaldo.enuns;

public enum StatusProjeto {
	EM_ANALISE("em análise"), 
	ANALISE_REALIZADA("análise realizada"), 
	ANALISE_APROVADA ("análise aprovada"),
	INICIADO("iniciado"),
	PLANEJADO("planejado"),
	EM_ANDAMENTO("em andamento"),
	ENCERRADO("encerrado"),
	CANCELADO("cancelado");

	private String descricao;

	StatusProjeto(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static boolean podeDeletar(StatusProjeto s) {
		switch(s) {
		case INICIADO:
		case EM_ANDAMENTO:
		case ENCERRADO:
			return false;
		}
		return true;
	}
}
