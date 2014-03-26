package br.com.system.dao.cadastro;

import java.util.List;

import br.com.system.dao.GenericsDAO;
import br.com.system.model.cadastro.Endereco;

public interface EnderecoDao extends GenericsDAO<Endereco> {

	List<Endereco> findEnderecoDaoFilters();

}
