package br.com.system.cadastro.view;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.system.cadastro.business.PessoaBusiness;
import br.com.system.cadastro.business.impl.PessoaBusinessImpl;
import br.com.system.cadastro.model.Pessoa;

@SessionScoped
@ManagedBean(name = "pessoaBean")
public class PessoaBean {

	
	// ATRIBUTOS CONTROLER
	private PessoaBusiness pessoaBusiness = new PessoaBusinessImpl();
	
	// CONTROLER
	public String saveOrUpdate() {
		
		try {
			pessoaBusiness.saveOrUpdate(pessoa);
			getFacesMessage("Pessoa salvo com sucesso: ");
			return PAG_CLIENT_LISTA;
			
		} catch (Exception e) {
			e.printStackTrace();
			getFacesMessage("Erro ao salvar pessoa: " , e);
			return PAG_CLIENT_EDIT;
		}

	}

	
	public void pesquisarPessoas() {
		try {
			pessoas = pessoaBusiness.findPessoaDaoFilters();
		} catch (Exception e) {
			e.printStackTrace();
			getFacesMessage("Erro ao pesquisar em pessoas: " , e);
		}
		
	}
	


	// CONSTANTES
	public static final String PAG_CLIENT_LISTA = "pessoaList.xhtml"; 
	public static final String PAG_CLIENT_EDIT = "pessoaEdit.xhtml"; 

	// ATRIBUTOS
	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	
	// GET - SET
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
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
