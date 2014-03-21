package br.com.system.cadastro.dao;

import java.util.List;

import br.com.system.cadastro.model.Telefone;
import br.com.system.dao.GenericsDAO;

public interface TelefoneDao extends GenericsDAO<Telefone> {

	List<Telefone> findTelefoneDaoFilters();

}
