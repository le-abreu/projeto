package br.com.autoescola.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.autoescola.bean.Classificador;
import br.com.autoescola.bean.Pessoa;
import br.com.autoescola.bean.Telefone;
import br.com.autoescola.util.JPAUtil;

public class TelefoneDAO extends DAO<Telefone>{

		public TelefoneDAO() {
			super(JPAUtil.getEntityManager(), Telefone.class);
		}
		
		public Telefone buscaPorParametro(Integer ddi, Integer ddd,Classificador tipoTelefone, String numero, String operadora, Pessoa pessoa) {

			Map<String, Object> parametros = new HashMap<String, Object>();
			if(ddi != null)
				parametros.put("ddi", ddi);
			if(ddd != null)
				parametros.put("ddd", ddd);
			if(tipoTelefone != null)
				parametros.put("tipoTelefone", tipoTelefone);
			if(numero != null)
				parametros.put("numero", numero);
			if(operadora != null)
				parametros.put("operadora", operadora);
			if(pessoa != null)
				parametros.put( pessoa.getNomePessoa() +"_id", pessoa.getId());
			
			return super.buscaPorParametro(parametros);
		}

		public List<Telefone> buscaListaPorParametro(Integer ddi, Integer ddd, Classificador tipoTelefone, String numero, String operadora, Pessoa pessoa) {
			
			Map<String, Object> parametros = new HashMap<String, Object>();
			if(ddi != null)
				parametros.put("ddi", ddi);
			if(ddd != null)
				parametros.put("ddd", ddd);
			if(numero != null)
				parametros.put("numero", numero);
			if(tipoTelefone != null)
				parametros.put("tipoTelefone", tipoTelefone);
			if(operadora != null)
				parametros.put("operadora", operadora);
			if(pessoa != null)
				parametros.put( pessoa.getNomePessoa() +"_id", pessoa.getId());

			
			return super.buscaListaPorParametro(parametros);
		}

	}

