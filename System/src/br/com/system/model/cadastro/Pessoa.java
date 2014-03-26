package br.com.system.model.cadastro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//ATRIBUTOS
@Entity(name="pessoa")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Pessoa implements Serializable {
 
	/**
	 * 
	 */
	private transient static final long serialVersionUID = 1L;

	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column()
	private String nome;

	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@OneToMany(cascade = CascadeType.ALL,  fetch= FetchType.LAZY)
	private List<Endereco> enderecos = new ArrayList<Endereco>();

	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	private List<Telefone> telefones= new ArrayList<Telefone>();

	
	//GET - SET
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	
	public abstract String getValue();

}
