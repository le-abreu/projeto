package br.com.system.cadastro.dao;

import java.util.List;

import br.com.system.cadastro.model.Endereco;
import br.com.system.dao.GenericsDAO;

public interface EnderecoDao extends GenericsDAO<Endereco> {

	List<Endereco> findEnderecoDaoFilters();

}
