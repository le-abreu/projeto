package br.com.system.model.cadastro;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.system.cadastro.model.enumaretor.Classificador;

@Entity
public class Endereco implements Serializable {
	
	/**
	 * 
	 */
	private transient static final long serialVersionUID = 1L;

	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column()
	private String cep;

	@Column()
	private Classificador tipoEndereco;
	
	@Column(length=2)
	private String uf;
	
	@Column()
	private String logradouro;
	
	@Column()
	private String numero;

	@Column()
	private String complemento;
	
	@Column()
	private String bairro;
	
	@Column()
	private String cidade;

	@Column()
	private String observacao;
	
	// GET - SET
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Classificador getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(Classificador tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	
}
