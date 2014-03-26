package br.com.system.business.impl.cadastro;

import br.com.system.business.cadastro.PessoaFisicaBusiness;
import br.com.system.dao.cadastro.PessoaFisicaDao;
import br.com.system.dao.impl.cadastro.PessoaFisicaDaoImpl;

public class PessoaFisicaBusinessImpl extends PessoaBusinessImpl implements PessoaFisicaBusiness
{

	private PessoaFisicaDao pessoaFisicaDao = new PessoaFisicaDaoImpl();
	 
}
