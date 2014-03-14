package br.com.system.cadastro.business;

import java.util.List;

import br.com.system.cadastro.model.Endereco;

public interface EnderecoBusiness {

	void saveOrUpdate(Endereco endereco) throws Exception;

	List<Endereco> findEnderecoDaoFilters() throws Exception;

}
