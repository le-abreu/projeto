package br.com.system.business.cadastro;

import java.util.List;

import br.com.system.model.cadastro.Endereco;

public interface EnderecoBusiness {

	void saveOrUpdate(Endereco endereco) throws Exception;

	List<Endereco> findEnderecoDaoFilters() throws Exception;

}
