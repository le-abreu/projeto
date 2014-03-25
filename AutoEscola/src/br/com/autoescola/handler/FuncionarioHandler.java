package br.com.autoescola.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CaptureEvent;

import br.com.autoescola.bean.Cargo;
import br.com.autoescola.bean.Classificador;
import br.com.autoescola.bean.Endereco;
import br.com.autoescola.bean.Funcionario;
import br.com.autoescola.bean.Habilitacao;
import br.com.autoescola.bean.Imagem;
import br.com.autoescola.bean.NacionalidadeEnum;
import br.com.autoescola.bean.Telefone;
import br.com.autoescola.dao.CargoDAO;
import br.com.autoescola.dao.FuncionarioDAO;
import br.com.autoescola.util.ControllerArquivo;

@SessionScoped
@ManagedBean(name = "funcionarioHandler")
public class FuncionarioHandler implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//BEAN
	private Funcionario funcionario;
	private  Endereco endereco = new Endereco();
	private  Telefone telefone = new Telefone();
	private  Habilitacao habilitacao = new Habilitacao();
	private  Cargo cargo = new Cargo();
	
	//LIST
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	private List<Telefone> telefones = new ArrayList<Telefone>();
	private List<NacionalidadeEnum> nacionalidadeEnum;

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
	
	public String persistirFuncionario() {
		salvarFoto();
		this.funcionarioDAO.persist(funcionario);
		return "formFuncionarioList.xhtml";
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
	
	public List<NacionalidadeEnum> getNacionalidadeEnum() {
		if(nacionalidadeEnum == null || nacionalidadeEnum.isEmpty()){
			nacionalidadeEnum = new ArrayList<NacionalidadeEnum>();
		for (NacionalidadeEnum nacEnum : NacionalidadeEnum.values()) {
			nacionalidadeEnum.add(nacEnum);
		}

		}
		return nacionalidadeEnum;
		}
	
	public void setNacionalidadeEnum(List<NacionalidadeEnum> nacionalidadeEnum) {
		this.nacionalidadeEnum = nacionalidadeEnum;
	}

	

	public List<String> completeCargo(String titulo) {  
        List<String> results = new ArrayList<String>();  
          
		for (Cargo cargo : new CargoDAO().buscaListaPorTitulo(titulo)) {  
            results.add(cargo.getTitulo());  
        }  
          
        return results;  
    }
	
	public void oncapture(CaptureEvent captureEvent) {
		FacesMessage msg = new FacesMessage("Sucesso!!");
		FacesContext.getCurrentInstance().addMessage(null, msg);

		Imagem imagem = funcionario.getImagem();
		imagem.setCaminho("imagemSistema//temp//fotoPessoa//");
		imagem.setArquivo("fotoPerfil.jpg");
		imagem.setTipo("JPG");
		
		ControllerArquivo.guardarArquivo(captureEvent.getData(), imagem.getCaminho(), imagem.getArquivo());
	}
	
	private void salvarFoto() {
		boolean isDeletar = true;
		Imagem imagem = funcionario.getImagem();
		imagem.setCaminho("imagemSistema//producao//fotofuncionario");
		imagem.setArquivo(funcionario.getCpf() + ".jpg");
		imagem.setTipo("JPG");
		
		try {
			File file = new File(ControllerArquivo.criarArquivo("imagemSistema//temp//fotoPessoa","fotoPerfil.jpg"));
			if (!file.exists()) {
				file = new File(ControllerArquivo.criarArquivo(funcionario.getImagem().getCaminho(),funcionario.getImagem().getArquivo()));
			}if (!file.exists()) {
				isDeletar = false;
				file = new File(ControllerArquivo.criarArquivo("imagemSistema//temp//fotoPessoa","fotoPerfilPadrao.jpg"));
			}
			ControllerArquivo.guardarArquivo(new FileInputStream(file), imagem.getCaminho(), imagem.getArquivo());
			if (isDeletar)
				file.delete();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}