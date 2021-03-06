package br.com.autoescola.bean;

public enum SexoEnum {

	MASCULINO("Masculino"), 
	FEMININO("Feminino");

	private String sexo;
	
	private SexoEnum(String sexo) {
		this.sexo = sexo;
	}

	public String getSexo() {
		return sexo;
	}
	
	@Override
	public String toString() {
		return getSexo();
	}
}
