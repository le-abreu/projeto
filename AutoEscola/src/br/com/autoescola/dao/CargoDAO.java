package br.com.autoescola.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import br.com.autoescola.bean.Cargo;
import br.com.autoescola.bean.Funcionario;
import br.com.autoescola.util.JPAUtil;

public class CargoDAO extends DAO<Cargo> {

	public CargoDAO() {
		super(JPAUtil.getEntityManager(), Cargo.class);
	}

	public Cargo buscaPorParametro(String titulo) {

		Map<String, Object> parametros = new HashMap<String, Object>();
		if (titulo != null)
			parametros.put("titulo", titulo);
		return super.buscaPorParametro(parametros);
	}

	public List<Cargo> buscaListaPorParametro(String titulo) {

		Map<String, Object> parametros = new HashMap<String, Object>();
		if (titulo != null)
			parametros.put("titulo", titulo);

		return super.buscaListaPorParametro(parametros);
	}

	public List<Cargo> buscaListaPorParametro(Funcionario funcionario) {
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		if (funcionario != null)
			parametros.put("funcionario_id", funcionario);
		
		return super.buscaListaPorParametro(parametros);
	}

	@SuppressWarnings("unchecked")
	public List<Cargo> buscaListaPorTitulo(String titulo) {
		Query q = JPAUtil.getEntityManager().createQuery(
				"select p from Cargo p where p.titulo like'" + titulo + "%'");

		return ((List<Cargo>) q.getResultList());
	}

}
