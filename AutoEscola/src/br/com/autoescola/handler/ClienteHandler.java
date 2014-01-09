package br.com.autoescola.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CaptureEvent;

import br.com.autoescola.bean.Classificador;
import br.com.autoescola.bean.Cliente;
import br.com.autoescola.bean.Endereco;
import br.com.autoescola.bean.Habilitacao;
import br.com.autoescola.bean.Imagem;
import br.com.autoescola.bean.Telefone;
import br.com.autoescola.dao.ClienteDAO;
import br.com.autoescola.dao.EnderecoDAO;
import br.com.autoescola.dao.HabilitacaoDAO;
import br.com.autoescola.dao.TelefoneDAO;
import br.com.autoescola.util.ControllerArquivo;

@SessionScoped
@ManagedBean(name = "clienteHandler")
public class ClienteHandler implements Serializable{

	private static final long serialVersionUID = 1L;

	public ClienteHandler() {
		this.endereco.setCliente(new Cliente());
		this.habilitacao.setCliente(new Cliente());
		this.telefone.setCliente(new Cliente());
	}
	
	//BEAN
	private Cliente cliente;
	private  Endereco endereco = new Endereco();
	private  Telefone telefone = new Telefone();
	private  Habilitacao habilitacao = new Habilitacao();
	
	//LIST
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	private List<Telefone> telefones = new ArrayList<Telefone>();

	//DAO
	private ClienteDAO clienteDAO = new ClienteDAO();
	private TelefoneDAO telefoneDAO = new TelefoneDAO();
	private EnderecoDAO enderecoDAO = new EnderecoDAO();
	private HabilitacaoDAO habilitacaoDAO = new HabilitacaoDAO();

	//VARIAVEIS AUXILIARES
	private boolean disabled = false;
	private String evento;
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public Habilitacao getHabilitacao() {
		return habilitacao;
	}

	public void setHabilitacao(Habilitacao habilitacao) {
		this.habilitacao = habilitacao;
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

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public List<Cliente> getClientes() {
		return clientes = clienteDAO.lista();
	}
	
	public void persistirCliente() {
		salvarFoto();
		this.clienteDAO.persist(cliente);
	}
	
	public void persistirEndereco() {
		salvarCliente();
		enderecoDAO.update(endereco);
	}

	private void salvarCliente() {
		if(this.cliente.getId() == 0){
			this.clienteDAO.persist(cliente);
			this.cliente = this.clienteDAO.buscaPorParametro(this.cliente.getCpf(), this.cliente);
		}
	}

	public void excluirEndereco() {
		Endereco endereco = enderecoDAO.find(this.endereco.getId());
		Cliente cliente = endereco.getCliente();
		endereco.setCliente(null); 
		cliente.getEnderecos().remove(endereco);
		enderecoDAO.delete(endereco);
	}

	public void persistirTelefone() {
		salvarCliente();
		telefoneDAO.update(telefone);
	}

	public void excluirTelefone() {
		Telefone telefone = telefoneDAO.find(this.telefone.getId());
		Cliente cliente = telefone.getCliente();
		telefone.setCliente(null);
		cliente.getTelefones().remove(telefone);
		telefoneDAO.delete(telefone);
	}

	public void persistirHabilitacao() {
		salvarCliente();
		cliente.getHabilitacoes().add(habilitacao);
		clienteDAO.update(cliente);
	}
	
	public void excluirHabilitacao() {
		Habilitacao habilitacao = habilitacaoDAO.find(this.habilitacao.getId());
		Cliente cliente = habilitacao.getCliente();
		habilitacao.setCliente(null);
		cliente.getHabilitacoes().remove(habilitacao);
		habilitacaoDAO.delete(habilitacao);
	}

	public Cliente getNovoCliente() {
		return new Cliente();
	}

	public Habilitacao getNovoHabilitacao() {
		Habilitacao habilitacao = new Habilitacao() ;
		habilitacao.setCliente(this.cliente);
		return habilitacao;
	}

	public Telefone getNovoTelefone() {
		Telefone telefone = new Telefone() ;
		telefone.setCliente(this.cliente);
		return telefone;
	}
	
	public Endereco getNovoEndereco() {
		Endereco endereco = new Endereco();
		endereco.setCliente(this.cliente);
		return endereco;
	}

	public List<Classificador> getClassificadorEnum() {
		return Arrays.asList(Classificador.values());
	}
	
	public void oncapture(CaptureEvent captureEvent) {
		FacesMessage msg = new FacesMessage("Sucesso!!");
		FacesContext.getCurrentInstance().addMessage(null, msg);

		Imagem imagem = cliente.getImagem();
		imagem.setCaminho("imagemSistema//temp//fotoPessoa//");
		imagem.setArquivo("fotoPerfil.jpg");
		imagem.setTipo("JPG");
		
		ControllerArquivo.guardarArquivo(captureEvent.getData(), imagem.getCaminho(), imagem.getArquivo());
	}
	
	private void salvarFoto() {
		boolean isDeletar = true;
		Imagem imagem = cliente.getImagem();
		imagem.setCaminho("imagemSistema//producao//fotoCliente");
		imagem.setArquivo(cliente.getCpf() + ".jpg");
		imagem.setTipo("JPG");
		
		try {
			File file = new File(ControllerArquivo.criarArquivo("imagemSistema//temp//fotoPessoa","fotoPerfil.jpg"));
			if (!file.exists()) {
				file = new File(ControllerArquivo.criarArquivo(cliente.getImagem().getCaminho(),cliente.getImagem().getArquivo()));
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