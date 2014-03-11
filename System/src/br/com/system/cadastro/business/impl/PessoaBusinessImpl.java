package br.com.system.cadastro.business.impl;

import java.util.List;

import br.com.system.cadastro.business.PessoaBusiness;
import br.com.system.cadastro.dao.PessoaDao;
import br.com.system.cadastro.dao.impl.PessoaDaoImpl;
import br.com.system.cadastro.model.Pessoa;

public class PessoaBusinessImpl implements PessoaBusiness
{

	private PessoaDao pessoaDao = new PessoaDaoImpl();
	 
	@Override
	public void saveOrUpdate(Pessoa pessoa) throws Exception 
	{ 
		try 
		{
			if(pessoa.getId() == null)
			{ 
				pessoaDao.persist(pessoa);
			}
			else
			{
				pessoaDao.update(pessoa);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw e;
		}
	}

	@Override 
	public List<Pessoa> findPessoaDaoFilters() throws Exception 
	{
		try
		{
			return pessoaDao.findPessoaDaoFilters();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
}
