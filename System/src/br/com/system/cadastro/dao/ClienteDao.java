package br.com.system.cadastro.dao;

import java.util.List;

import br.com.system.cadastro.model.Cliente;
import br.com.system.dao.GenericsDAO;

public interface ClienteDao extends GenericsDAO<Cliente> {

	List<Cliente> findClienteDaoFilters();

}
