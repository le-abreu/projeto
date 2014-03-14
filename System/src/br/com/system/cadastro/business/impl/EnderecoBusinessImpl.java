package br.com.system.cadastro.business.impl;

import java.util.List;

import br.com.system.cadastro.business.EnderecoBusiness;
import br.com.system.cadastro.dao.EnderecoDao;
import br.com.system.cadastro.dao.impl.EnderecoDaoImpl;
import br.com.system.cadastro.model.Endereco;

public class EnderecoBusinessImpl implements EnderecoBusiness
{

	private EnderecoDao enderecoDao = new EnderecoDaoImpl();
	
	@Override
	public void saveOrUpdate(Endereco endereco) throws Exception 
	{
		try 
		{
			if(endereco.getId() == null)
			{
				enderecoDao.persist(endereco);
			}
			else
			{
				enderecoDao.update(endereco);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Endereco> findEnderecoDaoFilters() throws Exception 
	{
		try
		{
			return enderecoDao.findEnderecoDaoFilters();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
}
