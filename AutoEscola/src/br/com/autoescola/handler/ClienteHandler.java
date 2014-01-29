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

import br.com.autoescola.bean.Classificador;
import br.com.autoescola.bean.Cliente;
import br.com.autoescola.bean.Endereco;
import br.com.autoescola.bean.Habilitacao;
import br.com.autoescola.bean.Imagem;
import br.com.autoescola.bean.Telefone;
import br.com.autoescola.dao.ClienteDAO;
import br.com.autoescola.util.ControllerArquivo;

@SessionScoped
@ManagedBean(name = "clienteHandler")
public class ClienteHandler implements Serializable{

	private static final long serialVersionUID = 1L;

	//BEAN
	private  Cliente cliente;
	private  Endereco endereco = new Endereco();
	private  Telefone telefone = new Telefone();
	private  Habilitacao habilitacao = new Habilitacao();
	
	//LIST
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	private List<Telefone> telefones = new ArrayList<Telefone>();

	//DAO
	private ClienteDAO clienteDAO = new ClienteDAO();

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
	
	public String persistirCliente() {
		salvarFoto();
		this.clienteDAO.persist(cliente);
		return "formClienteList.xhtml";
	}
	
	public void persistirEndereco() {
		if(!this.cliente.getEnderecos().contains(endereco)){
			this.cliente.getEnderecos().add(endereco);
		}
		endereco = new Endereco();
	}

	public void excluirEndereco() {
		cliente.getEnderecos().remove(endereco);
	}

	public void persistirTelefone() {
		if (!this.cliente.getTelefones().contains(telefone)) {
			this.cliente.getTelefones().add(telefone);
		}
		telefone = new Telefone();
	}

	public void excluirTelefone() {
		cliente.getTelefones().remove(telefone);
	}

	public void persistirHabilitacao() {
		
		if(!this.cliente.getHabilitacoes().contains(habilitacao)){
			this.cliente.getHabilitacoes().add(habilitacao);
		}
		habilitacao = new Habilitacao();
	}
	
	public void excluirHabilitacao() {
		cliente.getHabilitacoes().remove(habilitacao);
	}

	public Cliente getNovoCliente() {
		return new Cliente();
	}

	public Habilitacao getNovoHabilitacao() {
		Habilitacao habilitacao = new Habilitacao() ;
		return habilitacao;
	}

	public Telefone getNovoTelefone() {
		Telefone telefone = new Telefone() ;
		return telefone;
	}
	
	public Endereco getNovoEndereco() {
		Endereco endereco = new Endereco();
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