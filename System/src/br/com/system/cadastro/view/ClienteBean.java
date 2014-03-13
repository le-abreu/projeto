package br.com.system.cadastro.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.system.cadastro.business.ClienteBusiness;
import br.com.system.cadastro.business.impl.ClienteBusinessImpl;
import br.com.system.cadastro.model.Cliente;
import br.com.system.cadastro.model.PessoaFisica;

@SessionScoped
@ManagedBean(name = "clienteBean")
public class ClienteBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ATRIBUTOS CONTROLER
	private ClienteBusiness clienteBusiness = new ClienteBusinessImpl();
	private boolean disabled;
	
	{
		this.cliente = new Cliente();
		this.cliente.setPessoa(new PessoaFisica());
	}
	
	// CONTROLER
	public String saveOrUpdate() {
		
		try {
			clienteBusiness.saveOrUpdate(cliente);
			restart();
			getFacesMessage("Cliente salvo com sucesso: ");
			return PAG_CLIENT_LISTA;
			
		} catch (Exception e) {
			e.printStackTrace();
			getFacesMessage("Erro ao salvar cliente: " , e);
			return PAG_CLIENT_EDIT;
		}

	}

	
	public void pesquisarClientes() {
		try {
			clientes = clienteBusiness.findClienteDaoFilters();
		} catch (Exception e) {
			e.printStackTrace();
			getFacesMessage("Erro ao pesquisar em clientes: " , e);
		}
		
	}
	
	public void restart() {
		cliente = new Cliente();
		clientes = new ArrayList<Cliente>();
		pesquisarClientes();
	}


	// CONSTANTES
	public static final String PAG_CLIENT_LISTA = "clienteList.xhtml"; 
	public static final String PAG_CLIENT_EDIT = "clienteEdit.xhtml"; 

	// ATRIBUTOS
	private Cliente cliente;
	private List<Cliente> clientes;
	
	// GET - SET
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	

	private void getFacesMessage(String msgTela) {
		FacesMessage msg = new FacesMessage(msgTela);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	private void getFacesMessage(String msgTela, Exception e) {
		FacesMessage msg = new FacesMessage(msgTela + e.getMessage() );
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
}
