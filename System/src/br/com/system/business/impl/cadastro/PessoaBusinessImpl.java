package br.com.system.business.impl.cadastro;

import java.util.List;

import br.com.system.business.cadastro.PessoaBusiness;
import br.com.system.dao.cadastro.PessoaDao;
import br.com.system.dao.impl.cadastro.PessoaDaoImpl;
import br.com.system.model.cadastro.Pessoa;

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
