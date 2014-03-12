package br.com.system.cadastro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.system.cadastro.model.enumaretor.Classificador;

@Entity(name="telefone")
public class Telefone {
	
	// ATRIBUTO
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private int ddi;
	
	@Column
	private int ddd;
	
	@Column
	private String numero;

	@Column
	private String ramal;
	
	@Column
	private String operadora;

	@Column
	private String codigoOperadora;

	@Column
	private Classificador tipoTelefone;

	@Column
	private String observacao;

	// GET - SET
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDdi() {
		return ddi;
	}

	public void setDdi(int ddi) {
		this.ddi = ddi;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public String getCodigoOperadora() {
		return codigoOperadora;
	}

	public void setCodigoOperadora(String codigoOperadora) {
		this.codigoOperadora = codigoOperadora;
	}

	public Classificador getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(Classificador tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
