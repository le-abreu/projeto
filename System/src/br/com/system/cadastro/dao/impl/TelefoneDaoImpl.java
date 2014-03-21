package br.com.system.cadastro.dao.impl;

import java.util.List;

import br.com.system.cadastro.dao.TelefoneDao;
import br.com.system.cadastro.model.Telefone;
import br.com.system.dao.JPAUtil;
import br.com.system.dao.impl.GenericsDAOImpl;

public class TelefoneDaoImpl extends GenericsDAOImpl<Telefone> implements TelefoneDao{

	public TelefoneDaoImpl() {
		super(JPAUtil.getEntityManager(), Telefone.class);
	}


	@Override
	public List<Telefone> findTelefoneDaoFilters() {
		return null;
	}

	public static class TelefoneDaoFilters{
		
	}
}
