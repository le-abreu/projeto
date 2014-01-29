package br.com.autoescola.bean;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Telefone {

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
	private String operadora;

	@Column
	private Classificador tipoTelefone;

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

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public Classificador getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(Classificador tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
	
	public List<Classificador> getClassificadorEnum() {
		return Arrays.asList(Classificador.values());
	}
	
}
