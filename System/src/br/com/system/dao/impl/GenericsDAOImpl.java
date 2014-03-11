package br.com.system.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.system.cadastro.dao.JPAUtil;
import br.com.system.dao.GenericsDAO;

public class GenericsDAOImpl<T> implements GenericsDAO<T>
{

	private EntityManager em;
	private Class<?> persistentClass;
	
	@SuppressWarnings("unused")
	private T t;
	
	public GenericsDAOImpl(EntityManager em, Class<?> persistenClass) 
	{
		this.em = em;
		this.persistentClass = persistenClass;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> lista() throws Exception
	{
		try
		{
			
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<?> criteriaQuery = criteriaBuilder.createQuery(persistentClass);
			criteriaQuery.from(persistentClass);
			List<?> lista = em.createQuery(criteriaQuery).getResultList();
			return (List<T>) lista;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T find(int id) throws Exception
	{
		return (T) getEm().find(persistentClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T find(long id) throws Exception
	{
		return (T) getEm().find(persistentClass, id);
	}

	@Override
	public void persist(T t) throws Exception
	{
		EntityTransaction trans = getEm().getTransaction();
		try 
		{
			trans.begin();
			getEm().persist(t);
			trans.commit();
		} 
		catch (Exception e) 
		{
			if (trans.isActive())
				trans.rollback();

			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void update(T t) throws Exception
	{
		EntityTransaction trans = getEm().getTransaction();
		try 
		{
			trans.begin();
			getEm().merge(t);
			trans.commit();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
			if (trans.isActive())
				trans.rollback();
		}

	}

	@Override
	public void delete(T t) throws Exception
	{
		try 
		{
			EntityTransaction trans = getEm().getTransaction();
			trans.begin();
			getEm().remove(t);
			trans.commit();
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}

	}


	@SuppressWarnings("unchecked")
	@Override
	public T buscaPorParametro(Map<String, Object> parameters) throws Exception
	{
		String nome = this.persistentClass.getName();
		StringBuilder sql = new StringBuilder();
		sql.append("from ").append( nome.replace("br.com.system.model.", "") + " c").append(" where ");
		int indice = 0;
		for (String string: parameters.keySet()) 
		{
			if(indice++ > 0)
			{
				sql.append(" AND ");
			}
			sql.append(string+ "= :"+ string);
			
		}
		Query q = JPAUtil.getEntityManager().createQuery(sql.toString());
		for (String string: parameters.keySet())
		{
			q.setParameter(string, parameters.get(string));
		}

		return (T) ( q.getResultList().size() > 0 ? q.getResultList().get(0) : null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> buscaListaPorParametro(Map<String, Object> parameters) throws Exception
	{
		String nome = this.persistentClass.getName();  
		StringBuilder sql = new StringBuilder();
		sql.append("from ").append( nome.replace("br.com.system.model.", "") + " c").append(" where ");
		int indice = 0;
		for (String string: parameters.keySet()) 
		{
			if(indice++ > 0)
			{
				sql.append(" AND ");
			}
			sql.append(string+ "= :"+ string);
			
		}
		
		Query q = JPAUtil.getEntityManager().createQuery(sql.toString());
		for (String string: parameters.keySet())
		{
			q.setParameter(string, parameters.get(string));
		}
		
		return (List<T>) q.getResultList();
	}

	public EntityManager getEm() 
	{
		return em;
	}
}
