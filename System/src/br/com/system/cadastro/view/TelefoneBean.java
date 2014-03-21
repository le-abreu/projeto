package br.com.system.cadastro.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.system.cadastro.model.Telefone;

@ViewScoped
@ManagedBean(name = "telefoneBean")
public class TelefoneBean implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS CONTROLER
	private String evento;
	private boolean disabled;
	
	// CONTROLER
	public Telefone getNovoTelefone() 
	{
		return new Telefone();
	}
	
	public void persistirTelefone(List<Telefone> telefones) 
	{
		if(telefones == null) 
			telefones = new ArrayList<Telefone>();
			
		if(!telefones.contains(telefone)){
			telefones.add(telefone);
		}
		
		telefone = null;
	}	

	public void excluirTelefone(List<Telefone> telefones) {
		telefones.remove(telefone);
		telefone = null;
	}
	
	// GET - SET
	private Telefone telefone;
	private List<Telefone> telefones;


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

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
}