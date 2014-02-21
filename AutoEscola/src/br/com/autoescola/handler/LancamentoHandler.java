package br.com.autoescola.handler;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.autoescola.bean.Cliente;
import br.com.autoescola.bean.Lancamento;
import br.com.autoescola.bean.TipoLancamentoEnum;
import br.com.autoescola.dao.ClienteDAO;
import br.com.autoescola.dao.LancamentoDAO;
import br.com.autoescola.util.Html2Pdf;

import com.lowagie.text.DocumentException;

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

	public void excluirLancamento() {
		lancamentoDAO.delete(lancamento);
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
	
	public StreamedContent getComprovantePdf() {
		File file;
		try {
			file = Html2Pdf.convertComprovanteLancamento(new File("comprovante.pdf"), lancamento);
			InputStream inputStream;
			inputStream = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
	
			int offset = 0; 
			int numRead = 0;
			while (offset < bytes.length && (numRead = inputStream.read(bytes, offset, bytes.length - offset)) >= 0)
			{
				offset += numRead;
			}
			if (offset < bytes.length)
			{
				throw new IOException("Could not completely read file " + file.getName());
			}
	
			file.delete();
			inputStream.close();
			String fileName = lancamento.getTitulo() + lancamento.getCliente().getNome();
			if (fileName.indexOf(".pdf") < 0)
				fileName += ".pdf";
	
			ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
			StreamedContent contratoFichaPdf = new DefaultStreamedContent(bais, "application/pdf", fileName);
			return contratoFichaPdf;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
}