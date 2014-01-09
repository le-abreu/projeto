package br.com.autoescola.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.autoescola.util.JPAUtil;

public class DAO<T> {

	private EntityManager em;
	private Class<?> persistentClass;
	
	public DAO(EntityManager em, Class<?> persistenClass) {
		this.em = em;
		this.persistentClass = persistenClass;
	}

	@SuppressWarnings("unchecked")
	public List<T> lista() {
		String nome = this.persistentClass.getName();
		String sql = "SELECT c FROM " + nome.replace("br.com.autoescola.bean.", "") + " c";
		Query q = getEm().createQuery(sql);
		List<T> lista = q.getResultList();
		return lista;
	}

	@SuppressWarnings("unchecked")
	public T find(int id) {
		return (T) getEm().find(persistentClass, id);
	}

	@SuppressWarnings("unchecked")
	public T find(long id) {
		return (T) getEm().find(persistentClass, id);
	}

	public void persist(T t) {
		EntityTransaction trans = getEm().getTransaction();
		try {
			trans.begin();
			getEm().persist(t);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			if (trans.isActive())
				trans.rollback();
		}
	}

	public void update(T t) {
		EntityTransaction trans = getEm().getTransaction();
		try {
			trans.begin();
			getEm().merge(t);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			if (trans.isActive())
				trans.rollback();
		}

	}

	public void delete(T t) {
		try {
			EntityTransaction trans = getEm().getTransaction();
			trans.begin();
			getEm().remove(t);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public EntityManager getEm() {
		return em;
	}

	@SuppressWarnings("unchecked")
	public T buscaPorParametro(Map<String, Object> parameters) {
		String nome = this.persistentClass.getName();
		StringBuilder sql = new StringBuilder();
		sql.append("from ").append( nome.replace("br.com.autoescola.bean.", "") + " c").append(" where ");
		int indice = 0;
		for (String string: parameters.keySet()) {
			if(indice++ > 0){
				sql.append(" AND ");
			}
			sql.append(string+ "= :"+ string);
			
		}
		Query q = JPAUtil.getEntityManager().createQuery(sql.toString());
		for (String string: parameters.keySet()) {
			q.setParameter(string, parameters.get(string));
		}

		return (T) ( q.getResultList().size() > 0 ? q.getResultList().get(0) : null);
	}

	@SuppressWarnings("unchecked")
	public List<T> buscaListaPorParametro(Map<String, Object> parameters) {
		String nome = this.persistentClass.getName();
		StringBuilder sql = new StringBuilder();
		sql.append("from ").append( nome.replace("br.com.autoescola.bean.", "") + " c").append(" where ");
		int indice = 0;
		for (String string: parameters.keySet()) {
			if(indice++ > 0){
				sql.append(" AND ");
			}
			sql.append(string+ "= :"+ string);
			
		}
		
		Query q = JPAUtil.getEntityManager().createQuery(sql.toString());
		for (String string: parameters.keySet()) {
			q.setParameter(string, parameters.get(string));
		}
		
		return (List<T>) q.getResultList();
	}
}
