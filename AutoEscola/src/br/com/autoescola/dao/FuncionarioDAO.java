package br.com.autoescola.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.autoescola.bean.Funcionario;
import br.com.autoescola.util.JPAUtil;

public class FuncionarioDAO extends DAO<Funcionario>{

	public FuncionarioDAO() {
		super(JPAUtil.getEntityManager(), Funcionario.class);
	}
	
	public Funcionario buscaPorParametro(String nome) {
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		if(nome != null)
			parametros.put("pessoa.nome", nome); 

		return super.buscaPorParametro(parametros);
	}

	public boolean autentica(Funcionario funcionario) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		if(funcionario.getSenha() != null)
			parametros.put("senha", funcionario.getSenha());
		if(funcionario.getCpf() != null)
			parametros.put("pessoa_cpf", funcionario.getCpf());
		
		funcionario = super.buscaPorParametro(parametros) ;
		return funcionario != null;
	}

}
