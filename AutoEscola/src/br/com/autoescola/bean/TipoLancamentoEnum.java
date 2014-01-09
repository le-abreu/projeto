package br.com.autoescola.bean;

public enum TipoLancamentoEnum {

	CREDITO("C"),
	DEBITO("D");
	
	private String tipoLancamento;

	public String getTipoLancamento() {
		return tipoLancamento;
	}

	private TipoLancamentoEnum(String tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

}
