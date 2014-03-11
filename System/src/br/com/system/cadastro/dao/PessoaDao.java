package br.com.system.cadastro.dao;

import java.util.List;

import br.com.system.cadastro.model.Pessoa;
import br.com.system.dao.GenericsDAO;

public interface PessoaDao extends GenericsDAO<Pessoa>{

	List<Pessoa> findPessoaDaoFilters();

}
