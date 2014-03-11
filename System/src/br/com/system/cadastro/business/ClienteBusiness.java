package br.com.system.cadastro.business;

import java.util.List;

import br.com.system.cadastro.model.Cliente;

public interface ClienteBusiness {

	void saveOrUpdate(Cliente cliente) throws Exception;

	List<Cliente> findClienteDaoFilters() throws Exception;

}
