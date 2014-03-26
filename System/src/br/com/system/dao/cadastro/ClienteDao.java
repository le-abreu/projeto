package br.com.system.dao.cadastro;

import java.util.List;

import br.com.system.dao.GenericsDAO;
import br.com.system.model.cadastro.Cliente;

public interface ClienteDao extends GenericsDAO<Cliente> {

	List<Cliente> findClienteDaoFilters();

}
