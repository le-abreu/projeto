package br.com.autoescola.bean;

public enum Classificador {

	CORRESPONDENCIA("Correspondência"), 
	COMERCIAL("Comercial"), 
	RESIDENCIAL("Residencial"), 
	OUTROS("Outros");
	
	private String tipo;

	private Classificador(String tipo) {
		this.tipo = tipo;
	}
	
	
	public String getTipo() {
		return tipo;
	}


	@Override
	public String toString() {
		return getTipo();
	}
}
