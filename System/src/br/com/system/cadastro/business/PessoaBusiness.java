package br.com.system.cadastro.business;

import java.util.List;

import br.com.system.cadastro.model.Pessoa;

public interface PessoaBusiness {

	void saveOrUpdate(Pessoa pessoa) throws Exception;

	List<Pessoa> findPessoaDaoFilters() throws Exception;

}
