package br.com.system.dao.cadastro;

import java.util.List;

import br.com.system.dao.GenericsDAO;
import br.com.system.model.cadastro.Telefone;

public interface TelefoneDao extends GenericsDAO<Telefone> {

	List<Telefone> findTelefoneDaoFilters();

}
