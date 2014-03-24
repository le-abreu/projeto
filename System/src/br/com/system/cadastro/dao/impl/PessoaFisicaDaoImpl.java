package br.com.system.cadastro.dao.impl;

import br.com.system.cadastro.dao.PessoaFisicaDao;
import br.com.system.cadastro.model.enumaretor.SexoEnum;

public class PessoaFisicaDaoImpl extends PessoaDaoImpl implements PessoaFisicaDao
{

	public static class PessoaFisicaDaoFilters extends PessoaDaoFilters{
		
		private String cpf;
		private String rg;
		private SexoEnum sexo;
		
		public String getCpf() {
			return cpf;
		}
		
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		
		public String getRg() {
			return rg;
		}

		public void setRg(String rg) {
			this.rg = rg;
		}
		
		public SexoEnum getSexo() {
			return sexo;
		}

		public void setSexo(SexoEnum sexo) {
			this.sexo = sexo;
		}
	}
}
