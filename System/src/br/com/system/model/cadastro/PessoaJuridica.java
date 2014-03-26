package br.com.system.model.cadastro;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity(name="pessoa_juridica")
public class PessoaJuridica extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// ATRIBUTO
	@Column()
	private String cnpj;

	
	// GET - SET
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String getValue() {
		return "pessoaJuridico";
	}
	
}
