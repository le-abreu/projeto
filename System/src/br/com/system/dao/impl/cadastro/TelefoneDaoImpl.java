package br.com.system.dao.impl.cadastro;

import java.util.List;

import br.com.system.dao.JPAUtil;
import br.com.system.dao.cadastro.TelefoneDao;
import br.com.system.dao.impl.GenericsDAOImpl;
import br.com.system.model.cadastro.Telefone;

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
