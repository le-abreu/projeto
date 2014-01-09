package br.com.autoescola.bean;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

	@ManyToOne(cascade = CascadeType.REFRESH)
	private Cliente cliente;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	private Funcionario funcionario;


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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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
