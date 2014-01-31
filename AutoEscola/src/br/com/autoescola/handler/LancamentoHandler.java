package br.com.autoescola.handler;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.autoescola.bean.Cliente;
import br.com.autoescola.bean.Lancamento;
import br.com.autoescola.bean.TipoLancamentoEnum;
import br.com.autoescola.dao.ClienteDAO;
import br.com.autoescola.dao.LancamentoDAO;

@SessionScoped
@ManagedBean(name = "lancamentoHandler")
public class LancamentoHandler {

	private Cliente cliente = new Cliente();
	private Lancamento lancamento =  new Lancamento();
	private LancamentoDAO lancamentoDAO =  new LancamentoDAO();
	
	//VARIAVEIS AUXILIARES
	private boolean disabled = false;
	private boolean rendered = false;
	private String evento;
	private String cpf;
	
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Lancamento> getLancamentos() {
		return lancamentoDAO.lista();
	}

	public Lancamento getLancamento() {
		return lancamento = lancamento != null ? lancamento : new Lancamento();
	}
	
	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}
	
	public boolean isRendered() {
		return rendered;
	}

	public void setRendered(boolean rendered) {
		this.rendered = rendered;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void salvarLancamento() {
		lancamento.setCliente(cliente);

		if (lancamento.getId() == 0)
			lancamentoDAO.persist(lancamento);
		else
			lancamentoDAO.update(lancamento);
		
		lancamento =  new Lancamento();
	}

	public List<Lancamento> getLancamentosCliente() {
		double saldo = 0;
		if(cliente.getId() != 0){
			
			cliente.setLancamentos(lancamentoDAO.buscaPorParametro(null, null, cliente, null));
			
			for (Lancamento lancamento : cliente.getLancamentos()) {
				if(lancamento.getTipoLancamento().equals(TipoLancamentoEnum.CREDITO))
					saldo += lancamento.getValor();
				else
					saldo = saldo - lancamento.getValor();
				
				lancamento.setSaldo(saldo);
				
			}
			
		}
		return cliente.getLancamentos();
	}
	
	public void selecionaCliente() {
		cliente = new ClienteDAO().buscaPorParametro(cpf, null);
		if(cliente != null)
		{
			rendered = true;
		}
		else
		{
			rendered = false;
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não existe esse cliente!!!"));
			
		}
	}
	
	public Lancamento getNovoLancamentoDebito() {
		Lancamento lancamento = new Lancamento() ;
		lancamento.setCliente(this.cliente);
		lancamento.setTipoLancamento(TipoLancamentoEnum.DEBITO);
		return lancamento;
	}

	public Lancamento getNovoLancamentoCredito() {
		Lancamento lancamento = new Lancamento() ;
		lancamento.setCliente(this.cliente);
		lancamento.setTipoLancamento(TipoLancamentoEnum.CREDITO);
		return lancamento;
	}
	
	public SelectItem[] getTipoLancamentoEnum() {
		SelectItem[] items = new SelectItem[TipoLancamentoEnum.values().length];
		int i = 0;
		for (TipoLancamentoEnum t : TipoLancamentoEnum.values()) {
			items[i++] = new SelectItem(t, ""+t);
		} 
		return items;
	}
	
}