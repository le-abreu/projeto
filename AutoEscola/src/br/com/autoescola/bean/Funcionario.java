package br.com.autoescola.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;



@Entity
public class Funcionario extends Pessoa implements Serializable {
	
	/**
	 * 
	 */
	private transient static final long serialVersionUID = 1L;

	@Column()
	private String senha;
	
	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	private List<Endereco> enderecos = new ArrayList<Endereco>();

	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	private List<Telefone> telefones= new ArrayList<Telefone>();

	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	private List<Habilitacao> habilitacoes = new ArrayList<Habilitacao>();

	@OneToMany()
	private List<Cargo> cargos = new ArrayList<Cargo>();
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
	
	public List<Cargo> getCargos() {
		return cargos;
//		cargos = new CargoDAO().buscaListaPorParametro(this);
//		return cargos != null ? cargos : new ArrayList<Cargo>();
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	@Override
	public String getNomePessoa() {
		return "funcionario";
	}
}
