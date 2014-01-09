package br.com.autoescola.handler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.autoescola.bean.Cargo;
import br.com.autoescola.bean.Classificador;
import br.com.autoescola.bean.Cliente;
import br.com.autoescola.bean.Endereco;
import br.com.autoescola.bean.Funcionario;
import br.com.autoescola.bean.Habilitacao;
import br.com.autoescola.bean.Telefone;
import br.com.autoescola.dao.CargoDAO;
import br.com.autoescola.dao.EnderecoDAO;
import br.com.autoescola.dao.FuncionarioDAO;
import br.com.autoescola.dao.HabilitacaoDAO;
import br.com.autoescola.dao.TelefoneDAO;

@ViewScoped()
@ManagedBean(name = "funcionarioHandler")
public class FuncionarioHandler implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FuncionarioHandler() {
		this.telefone.setFuncionario(new Funcionario());
		this.endereco.setFuncionario(new Funcionario());
		this.habilitacao.setFuncionario(new Funcionario());
	}
	
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
	private TelefoneDAO telefoneDAO = new TelefoneDAO();
	private EnderecoDAO enderecoDAO = new EnderecoDAO();
	private HabilitacaoDAO habilitacaoDAO = new HabilitacaoDAO();

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
	
	public void persistirEndereco() {
		enderecoDAO.update(endereco);
	}
	
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public void excluirEndereco() {
		Endereco endereco = enderecoDAO.find(this.endereco.getId());
		Funcionario funcionario = endereco.getFuncionario();
		endereco.setFuncionario(null);
		funcionario.getEnderecos().remove(endereco);
		enderecoDAO.delete(endereco);
	}

	public void persistirTelefone() {
		telefoneDAO.update(telefone);
	}
	
	public void excluirTelefone() {
		Telefone telefone = telefoneDAO.find(this.telefone.getId());
		Funcionario funcionario = telefone.getFuncionario();
		telefone.setFuncionario(null);
		funcionario.getTelefones().remove(telefone);
		telefoneDAO.delete(telefone);
	}
	

	public void persistirHabilitacao() {
		habilitacaoDAO.update(habilitacao);
	}
	
	public void excluirHabilitacao() {
		Habilitacao habilitacao = habilitacaoDAO.find(this.habilitacao.getId());
		Cliente cliente = habilitacao.getCliente();
		habilitacao.setCliente(null);
		cliente.getTelefones().remove(habilitacao);
		habilitacaoDAO.delete(habilitacao);
	}


	public Funcionario getNovoFuncionario() {
		return new Funcionario();
	}

	public Telefone getNovoTelefone() {
		Telefone telefone = new Telefone() ;
		telefone.setFuncionario(this.funcionario);
		return telefone;
	}
	
	public Endereco getNovoEndereco() {
		Endereco endereco = new Endereco();
		endereco.setFuncionario(this.funcionario);
		return endereco;
	}

	public Habilitacao getNovoHabilitacao() {
		Habilitacao habilitacao = new Habilitacao() ;
		habilitacao.setFuncionario(this.funcionario);
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