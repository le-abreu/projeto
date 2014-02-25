package br.com.autoescola.bean;

public enum NacionalidadeEnum {

	BRASILEIRA("Brasileira"), 
	PORTUGUESA("Portuguesa"),
	ARGENTINA("Argentina"),
	ITALIANA("Italiana"),
	ALEMA("Alemã"),
	FRANCESA("Francesa");

	private String nacionalidade;
	
	private NacionalidadeEnum(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}
	
	@Override
	public String toString() {
		return getNacionalidade();
	}
}
