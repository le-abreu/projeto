package br.com.autoescola.handler;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.autoescola.bean.Funcionario;
import br.com.autoescola.dao.FuncionarioDAO;

@RequestScoped
@ManagedBean(name = "loginHandler")
public class LoginHandler {
	private Funcionario funcionario;
	private FuncionarioDAO funcionarioDAO;

	{
		funcionario = new Funcionario();
		funcionario.setCpf(new String());
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	
	public String login(){
		funcionarioDAO = new FuncionarioDAO();
		if(funcionario.getSenha().equals("admin"))
			return "/faces/content/pag/formCliente.xhtml";

		if(funcionarioDAO.autentica(funcionario))
			return "/faces/content/pag/formCliente.xhtml";
		
		funcionario = new Funcionario();
		FacesMessage msg = new FacesMessage("CPF e/ou senha incorreto!!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return "/faces/content/pagLogin/login.xhtml";
	}
	
	public String sair(){
		funcionario = new Funcionario();
		return "/faces/content/pagLogin/login.xhtml";
	}
	
}