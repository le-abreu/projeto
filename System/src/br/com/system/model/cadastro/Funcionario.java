package br.com.system.model.cadastro;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="funcionario")
public class Funcionario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne()
	private PessoaFisica pessoaFisica;

	
	// GET - SET
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

}
