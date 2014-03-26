package br.com.system.dao.cadastro;

import java.util.List;

import br.com.system.dao.GenericsDAO;
import br.com.system.model.cadastro.Pessoa;

public interface PessoaDao extends GenericsDAO<Pessoa>{

	List<Pessoa> findPessoaDaoFilters();

}
