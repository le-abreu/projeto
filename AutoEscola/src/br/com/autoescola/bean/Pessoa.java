package br.com.autoescola.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass 
public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private transient static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column()
	private String nome;

	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Column()
	private String nacionalidade;

	@Column(unique= true)
	private String cpf;
	
	@Column()
	private String rg;
	
	@Column()
	private SexoEnum sexo;
	
	@Column()
	private String pai;
	
	@Column()
	private String mae;

	@Temporal(TemporalType.DATE)
	private Date dataMatricula = new Date();

	@Column()
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	private Imagem imagem;

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

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

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

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}
	
	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public Imagem getImagem() {
		if(this.imagem == null)
			this.setImagem(new Imagem());

		return imagem;
	}
	
	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}
	
	public List<SexoEnum> getSexoEnum() {
		return Arrays.asList(SexoEnum.values());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomePessoa() {
		return "pessoa";
	}

}
