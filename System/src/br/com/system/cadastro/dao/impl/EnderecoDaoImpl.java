package br.com.system.cadastro.dao.impl;

import java.util.List;

import br.com.system.cadastro.dao.EnderecoDao;
import br.com.system.cadastro.model.Endereco;
import br.com.system.dao.JPAUtil;
import br.com.system.dao.impl.GenericsDAOImpl;

public class EnderecoDaoImpl extends GenericsDAOImpl<Endereco> implements EnderecoDao{

	public EnderecoDaoImpl() {
		super(JPAUtil.getEntityManager(), Endereco.class);
	}


	@Override
	public List<Endereco> findEnderecoDaoFilters() {
		return null;
	}

	public static class EnderecoDaoFilters{
		
	}
}
