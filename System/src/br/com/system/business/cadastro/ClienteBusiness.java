package br.com.system.business.cadastro;

import java.util.List;

import br.com.system.model.cadastro.Cliente;

public interface ClienteBusiness {

	void saveOrUpdate(Cliente cliente) throws Exception;

	List<Cliente> findClienteDaoFilters() throws Exception;

}
