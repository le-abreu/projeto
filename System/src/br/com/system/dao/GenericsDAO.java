package br.com.system.dao;

import java.util.List;
import java.util.Map;

public interface GenericsDAO<T> {

	public List<T> lista() throws Exception;

	public T find(int id) throws Exception;

	public T find(long id) throws Exception;

	public void persist(T t) throws Exception;

	public void update(T t) throws Exception;

	public void delete(T t) throws Exception;

	public T buscaPorParametro(Map<String, Object> parameters) throws Exception;

	public List<T> buscaListaPorParametro(Map<String, Object> parameters) throws Exception;
 
}
