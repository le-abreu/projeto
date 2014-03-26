package br.com.system.model.cadastro;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.system.cadastro.model.enumaretor.SexoEnum;

@Entity(name="pessoa_fisica")
public class PessoaFisica extends Pessoa {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	// ATRIBUTO 
	@Column
	private String cpf;
	
	@Column
	private String rg;

	@Column
	private SexoEnum sexo;

	// GET - SET 
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public SexoEnum getSexo() {
		return sexo;
	}
	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}
	@Override
	public String getValue() {
		return "pessoaFisica";
	}

}
