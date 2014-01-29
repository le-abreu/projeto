package br.com.autoescola.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;



@Entity
public class Cliente extends Pessoa implements Serializable {
	
	/**
	 * 
	 */
	private transient static final long serialVersionUID = 1L;

	@OneToMany(cascade= CascadeType.ALL, mappedBy="cliente")
	private List<Lancamento> lancamentos =  new ArrayList<Lancamento>();

	@OneToMany(cascade = CascadeType.ALL,  fetch= FetchType.LAZY)
	private List<Endereco> enderecos = new ArrayList<Endereco>();

	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	private List<Telefone> telefones= new ArrayList<Telefone>();

	@OneToMany(cascade = CascadeType.ALL,  fetch= FetchType.LAZY)
	private List<Habilitacao> habilitacoes = new ArrayList<Habilitacao>();
	
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Telefone> getTelefones() {
		return this.telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	public List<Habilitacao> getHabilitacoes() {
		return this.habilitacoes; 
	}

	public void setHabilitacoes(List<Habilitacao> habilitacoes) {
		this.habilitacoes = habilitacoes;
	}

	@Override
	public String getNomePessoa() {
		return "cliente";
	}
	
}
