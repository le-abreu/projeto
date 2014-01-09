package br.com.autoescola.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.autoescola.bean.Cliente;
import br.com.autoescola.util.JPAUtil;

public class ClienteDAO extends DAO<Cliente>{

	public ClienteDAO() {
		super(JPAUtil.getEntityManager(), Cliente.class);
	}
	
	public Cliente buscaPorParametro(String cpf, Cliente pessoa) {
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		if(pessoa != null)
			parametros.put("cpf", pessoa.getCpf());

		return super.buscaPorParametro(parametros);
	}

	public List<Cliente> buscaListaPorParametro(String cpf, Cliente pessoa) {
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		if(pessoa != null)
			parametros.put("cpf", pessoa.getCpf());

		return super.buscaListaPorParametro(parametros);
	}

}
