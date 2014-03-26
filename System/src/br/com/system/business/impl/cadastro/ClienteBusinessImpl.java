package br.com.system.business.impl.cadastro;

import java.util.List;

import br.com.system.business.cadastro.ClienteBusiness;
import br.com.system.dao.cadastro.ClienteDao;
import br.com.system.dao.impl.cadastro.ClienteDaoImpl;
import br.com.system.model.cadastro.Cliente;

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
