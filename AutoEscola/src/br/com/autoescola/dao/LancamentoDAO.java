package br.com.autoescola.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import br.com.autoescola.bean.Cliente;
import br.com.autoescola.bean.Lancamento;
import br.com.autoescola.util.JPAUtil;

public class LancamentoDAO extends DAO<Lancamento>{

	public LancamentoDAO() {
		super(JPAUtil.getEntityManager(), Lancamento.class);
	}
	
	public LancamentoDAO(EntityManager em, Class<?> persistenClass) {
		super(em, persistenClass);
	}

	public List<Lancamento> buscaPorParametro(String titulo, Date dataLancamento, Cliente cliente, Double valor) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		if(titulo != null)
			parametros.put("titulo", titulo);
		if(dataLancamento != null)
			parametros.put("dataLancamento", dataLancamento);
		if(valor != null)
			parametros.put("valor", valor);
		if(cliente != null)
			parametros.put("cliente_id", cliente.getId());
		return super.buscaListaPorParametro(parametros);
	}
}
