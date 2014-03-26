package br.com.system.dao.impl.cadastro;

import java.util.List;

import br.com.system.dao.JPAUtil;
import br.com.system.dao.cadastro.ClienteDao;
import br.com.system.dao.impl.GenericsDAOImpl;
import br.com.system.dao.impl.cadastro.PessoaFisicaDaoImpl.PessoaFisicaDaoFilters;
import br.com.system.model.cadastro.Cliente;

public class ClienteDaoImpl extends GenericsDAOImpl<Cliente> implements ClienteDao{

	public ClienteDaoImpl() {
		super(JPAUtil.getEntityManager(), Cliente.class);
	}


	@Override
	public List<Cliente> findClienteDaoFilters() throws Exception {
		try {
			return this.lista();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static class ClienteDaoFilters{
		
		//- atributos para pesquisa
		private Long idCliente;
		private PessoaFisicaDaoFilters pessoaFisicaDaoFilters = new PessoaFisicaDaoFilters();
		
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
