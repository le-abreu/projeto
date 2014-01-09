package br.com.autoescola.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.autoescola.bean.Habilitacao;
import br.com.autoescola.bean.Pessoa;
import br.com.autoescola.util.JPAUtil;

public class HabilitacaoDAO extends DAO<Habilitacao>{

	public HabilitacaoDAO() {
		super(JPAUtil.getEntityManager(), Habilitacao.class);
	}
	
	public Habilitacao buscaPorParametro(String categoria, Date validadeCNH, Date dataExpedicao, Pessoa pessoa) {

		Map<String, Object> parametros = new HashMap<String, Object>();
		if(categoria != null)
			parametros.put("categoria", categoria);
		if(validadeCNH != null)
			parametros.put("validadeCNH", validadeCNH);
		if(dataExpedicao != null)
			parametros.put("dataExpedicao", dataExpedicao);
		if(pessoa != null)
			parametros.put( pessoa.getNomePessoa() +"_id", pessoa.getId());
		
		return super.buscaPorParametro(parametros);
	}

	public List<Habilitacao> buscaListaPorParametro(String categoria, Date validadeCNH, Date dataExpedicao, Pessoa pessoa) {

			Map<String, Object> parametros = new HashMap<String, Object>();
			if(categoria != null)
				parametros.put("categoria", categoria);
			if(validadeCNH != null)
				parametros.put("validadeCNH", validadeCNH);
			if(dataExpedicao != null)
				parametros.put("dataExpedicao", dataExpedicao);
			if(pessoa != null)
				parametros.put( pessoa.getNomePessoa() +"_id", pessoa.getId());

		return super.buscaListaPorParametro(parametros);
	}
}
