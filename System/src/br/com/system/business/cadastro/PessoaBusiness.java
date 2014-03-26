package br.com.system.business.cadastro;

import java.util.List;

import br.com.system.model.cadastro.Pessoa;

public interface PessoaBusiness {

	void saveOrUpdate(Pessoa pessoa) throws Exception;

	List<Pessoa> findPessoaDaoFilters() throws Exception;

}
