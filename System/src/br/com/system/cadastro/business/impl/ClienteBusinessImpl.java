package br.com.system.cadastro.business.impl;

import java.util.List;

import br.com.system.cadastro.business.ClienteBusiness;
import br.com.system.cadastro.dao.ClienteDao;
import br.com.system.cadastro.dao.impl.ClienteDaoImpl;
import br.com.system.cadastro.model.Cliente;

public class ClienteBusinessImpl implements ClienteBusiness
{

	private ClienteDao clienteDao = new ClienteDaoImpl();
	
	@Override
	public void saveOrUpdate(Cliente cliente) throws Exception 
	{
		try 
		{
			if(cliente.getId() == null)
			{
				clienteDao.persist(cliente);
			}
			else
			{
				clienteDao.update(cliente);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Cliente> findClienteDaoFilters() throws Exception 
	{
		try
		{
			return clienteDao.findClienteDaoFilters();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
}
