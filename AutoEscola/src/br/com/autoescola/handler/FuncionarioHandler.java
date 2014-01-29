package br.com.autoescola.handler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.autoescola.bean.Cargo;
import br.com.autoescola.bean.Classificador;
import br.com.autoescola.bean.Endereco;
import br.com.autoescola.bean.Funcionario;
import br.com.autoescola.bean.Habilitacao;
import br.com.autoescola.bean.Telefone;
import br.com.autoescola.dao.CargoDAO;
import br.com.autoescola.dao.FuncionarioDAO;

@ViewScoped()
@ManagedBean(name = "funcionarioHandler")
public class FuncionarioHandler implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//BEAN
	private Funcionario funcionario = new Funcionario();
	private  Endereco endereco = new Endereco();
	private  Telefone telefone = new Telefone();
	private  Habilitacao habilitacao = new Habilitacao();
	private  Cargo cargo = new Cargo();
	
	//LIST
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	private List<Telefone> telefones = new ArrayList<Telefone>();

	//DAO
	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

	//VARIAVEIS AUXILIARES
	private boolean disabled = false;
	private String evento;
	private String titulo;
	
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
	public Habilitacao getHabilitacao() {
		return habilitacao;
	}

	public void setHabilitacao(Habilitacao habilitacao) {
		this.habilitacao = habilitacao;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios = funcionarioDAO.lista();
	}
	
	public void persistirFuncionario() {
		this.funcionarioDAO.persist(funcionario);
	}
	
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public void persistirEndereco() {
		if(!this.funcionario.getEnderecos().contains(endereco)){
			this.funcionario.getEnderecos().add(endereco);
		}
		endereco = new Endereco();
	}

	public void excluirEndereco() {
		funcionario.getEnderecos().remove(endereco);
	}

	public void persistirTelefone() {
		if (!this.funcionario.getTelefones().contains(telefone)) {
			this.funcionario.getTelefones().add(telefone);
		}
		telefone = new Telefone();
	}

	public void excluirTelefone() {
		funcionario.getTelefones().remove(telefone);
	}

	public void persistirHabilitacao() {
		
		if(!this.funcionario.getHabilitacoes().contains(habilitacao)){
			this.funcionario.getHabilitacoes().add(habilitacao);
		}
		habilitacao = new Habilitacao();
	}
	
	public void excluirHabilitacao() {
		funcionario.getHabilitacoes().remove(habilitacao);
	}

	public Funcionario getNovoFuncionario() {
		return new Funcionario();
	}

	public Telefone getNovoTelefone() {
		Telefone telefone = new Telefone() ;
		return telefone;
	}
	
	public Endereco getNovoEndereco() {
		Endereco endereco = new Endereco();
		return endereco;
	}

	public Habilitacao getNovoHabilitacao() {
		Habilitacao habilitacao = new Habilitacao() ;
		return habilitacao;
	}
	
	public List<Classificador> getClassificadorEnum() {
		return Arrays.asList(Classificador.values());
	}
	
	public void removerCargo(){
		cargo = new CargoDAO().find(cargo.getId());
		funcionario.getCargos().remove(cargo);
		funcionarioDAO.persist(funcionario);
		titulo = "";
		cargo = new Cargo();
	}

	public void adicionarCargo(){
		cargo = new CargoDAO().buscaPorParametro(cargo.getTitulo());
		funcionario.getCargos().add(cargo);
		funcionarioDAO.persist(funcionario);
		titulo = "";
		cargo = new Cargo();
	}
	
	public List<String> completeCargo(String titulo) {  
        List<String> results = new ArrayList<String>();  
          
		for (Cargo cargo : new CargoDAO().buscaListaPorTitulo(titulo)) {  
            results.add(cargo.getTitulo());  
        }  
          
        return results;  
    } 
}