package br.com.system.cadastro.dao.impl;

import java.util.List;

import br.com.system.cadastro.dao.ClienteDao;
import br.com.system.cadastro.dao.JPAUtil;
import br.com.system.cadastro.model.Cliente;
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
		
	}
}
