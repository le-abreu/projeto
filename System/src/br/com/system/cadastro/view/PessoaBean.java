package br.com.system.cadastro.view;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.system.cadastro.model.Pessoa;
import br.com.system.cadastro.model.PessoaFisica;
import br.com.system.cadastro.model.PessoaJuridica;
import br.com.system.cadastro.model.enumaretor.SexoEnum;

@SessionScoped
@ManagedBean(name = "pessoaBean")
public class PessoaBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS CONTROLER
	private TipoPessoa tipoPessoa;
	
	private PessoaFisica pessoaFisica;
	
	private PessoaJuridica pessoaJuridica;
	
	public List<TipoPessoa> getTipoPessoaEnum(){
		return Arrays.asList(TipoPessoa.values());
	}
	
	public void getInstance(Pessoa pessoa) 
	{
		if(pessoa != null)
		{
			if(pessoa instanceof PessoaFisica)
				pessoaFisica = (PessoaFisica) pessoa;
			else
				if(pessoa instanceof PessoaFisica)
					pessoaJuridica = (PessoaJuridica) pessoa;
		}
		else if(tipoPessoa != null)
		{
			if(tipoPessoa.equals(TipoPessoa.PESSOA_FISICA))
				pessoaFisica = new PessoaFisica();
			else
				if(tipoPessoa.equals(TipoPessoa.PESSOA_JURIDICA))
					pessoaJuridica = new PessoaJuridica();
		}
		
	}


	public enum TipoPessoa{
		PESSOA_FISICA("Pessoa Fisica"),
		PESSOA_JURIDICA("Pessoa Juridica");
		
		private String descricao;

		private TipoPessoa(String descricao) {
			this.descricao = descricao;
		}
		
		public String getDescricao() {
			return descricao;
		}
		
		@Override
		public String toString() {
			return this.getDescricao();
		}
	}
	
	public List<SexoEnum> getSexoEnum() {
		return Arrays.asList(SexoEnum.values());
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	
}
