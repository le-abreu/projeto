package br.com.system.cadastro.dao.impl;

import java.util.List;

import br.com.system.cadastro.dao.PessoaDao;
import br.com.system.cadastro.model.Pessoa;
import br.com.system.dao.JPAUtil;
import br.com.system.dao.impl.GenericsDAOImpl;

public class PessoaDaoImpl extends GenericsDAOImpl<Pessoa> implements PessoaDao{

	public PessoaDaoImpl() {
		super(JPAUtil.getEntityManager(), Pessoa.class);
	}


	@Override
	public List<Pessoa> findPessoaDaoFilters() {
		return null;
	}

	public static class PessoaDaoFilters{
		 
	}
}
