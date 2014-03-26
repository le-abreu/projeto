package br.com.system.view.cadastro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.system.model.cadastro.Endereco;

@ViewScoped
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
	
	public void persistirEndereco(List<Endereco> enderecos) 
	{
		if(enderecos == null) 
			enderecos = new ArrayList<Endereco>();
			
		if(!enderecos.contains(endereco)){
			enderecos.add(endereco);
		}
		
		endereco = null;
	}	

	public void excluirEndereco(List<Endereco> enderecos) {
		enderecos.remove(endereco);
		endereco = null;
	}
	
	// GET - SET
	private Endereco endereco;
	private List<Endereco> enderecos;


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