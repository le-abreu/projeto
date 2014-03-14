package br.com.system.cadastro.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.system.cadastro.model.Endereco;

@RequestScoped
@ManagedBean(name = "enderecoBean")
public class EnderecoBean implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS CONTROLER
	private String evento;
	private boolean disabled;
	
	// CONTROLER
	public Endereco getNovoEndereco() 
	{
		return new Endereco();
	}
	
	public void persistirEndereco() 
	{
		if(!this.enderecos.contains(endereco)){
			this.enderecos.add(endereco);
		}
		endereco = new Endereco();
	}	

	
	// GET - SET
	private Endereco endereco = new Endereco();
	private List<Endereco> enderecos = new ArrayList<Endereco>();

	public void excluirEndereco() {
		enderecos.remove(endereco);
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
}