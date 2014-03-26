package br.com.system.business.impl.cadastro;

import java.util.List;

import br.com.system.business.cadastro.EnderecoBusiness;
import br.com.system.dao.cadastro.EnderecoDao;
import br.com.system.dao.impl.cadastro.EnderecoDaoImpl;
import br.com.system.model.cadastro.Endereco;

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
