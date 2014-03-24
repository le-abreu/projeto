package br.com.system.cadastro.dao.impl;

import java.util.List;

import br.com.system.cadastro.dao.ClienteDao;
import br.com.system.cadastro.dao.impl.PessoaFisicaDaoImpl.PessoaFisicaDaoFilters;
import br.com.system.cadastro.model.Cliente;
import br.com.system.dao.JPAUtil;
import br.com.system.dao.impl.GenericsDAOImpl;

public class ClienteDaoImpl extends GenericsDAOImpl<Cliente> implements ClienteDao{

	public ClienteDaoImpl() {
		super(JPAUtil.getEntityManager(), Cliente.class);
	}


	@Override
	public List<Cliente> findClienteDaoFilters() {
		return null;
	}

	public static class ClienteDaoFilters{
		
		//- atributos para pesquisa
		private Long idCliente;
		private PessoaFisicaDaoFilters pessoaFisicaDaoFilters;
		
		public Long getIdCliente() {
			return idCliente;
		}

		public void setIdCliente(Long idCliente) {
			this.idCliente = idCliente;
		}
		
		public PessoaFisicaDaoFilters getPessoaFisicaDaoFilters() {
			return pessoaFisicaDaoFilters;
		}
		
		public void setPessoaFisicaDaoFilters(
				PessoaFisicaDaoFilters pessoaFisicaDaoFilters) {
			this.pessoaFisicaDaoFilters = pessoaFisicaDaoFilters;
		}
		
	}
}
