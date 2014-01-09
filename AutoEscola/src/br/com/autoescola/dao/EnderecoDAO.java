package br.com.autoescola.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.autoescola.bean.Classificador;
import br.com.autoescola.bean.Endereco;
import br.com.autoescola.bean.Pessoa;
import br.com.autoescola.util.JPAUtil;

public class EnderecoDAO extends DAO<Endereco>{

	public EnderecoDAO() {
		super(JPAUtil.getEntityManager(), Endereco.class);
	}
	
	public Endereco buscaPorParametro(String CEP, Classificador tipoEndereco, String uf, String logradouro, String bairro, String cidade, Pessoa pessoa) {
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		if(CEP != null)
			parametros.put("CEP", CEP);
		if(tipoEndereco != null)
			parametros.put("tipoEndereco", tipoEndereco);
		if(uf != null)
			parametros.put("uf", uf);
		if(logradouro != null)
			parametros.put("logradouro", logradouro);
		if(bairro != null)
			parametros.put("bairro", bairro);
		if(cidade != null)
			parametros.put("cidade", cidade);
		if(pessoa != null)
			parametros.put( pessoa.getNomePessoa() +"_id", pessoa.getId());

		return super.buscaPorParametro(parametros);
	}

	public List<Endereco> buscaListaPorParametro(String CEP, Classificador tipoEndereco, String uf, String logradouro, String bairro, String cidade, Pessoa pessoa) {
		
		
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		if(CEP != null)
			parametros.put("CEP", CEP);
		if(tipoEndereco != null)
			parametros.put("tipoEndereco", tipoEndereco);
		if(uf != null)
			parametros.put("uf", uf);
		if(logradouro != null)
			parametros.put("logradouro", logradouro);
		if(bairro != null)
			parametros.put("bairro", bairro);
		if(cidade != null)
			parametros.put("cidade", cidade);
		if(pessoa != null)
			parametros.put( pessoa.getNomePessoa() +"_id", pessoa.getId());

		
		return super.buscaListaPorParametro(parametros);
	}


}
