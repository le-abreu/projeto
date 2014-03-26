package br.com.system.model.cadastro;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "cliente" )
public class Cliente implements Serializable{
 
	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PessoaFisica pessoaFisica = new PessoaFisica();

	// GET - SET
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

}
