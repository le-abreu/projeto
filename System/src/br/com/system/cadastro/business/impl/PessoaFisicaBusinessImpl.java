package br.com.system.cadastro.business.impl;

import br.com.system.cadastro.business.PessoaFisicaBusiness;
import br.com.system.cadastro.dao.PessoaFisicaDao;
import br.com.system.cadastro.dao.impl.PessoaFisicaDaoImpl;

public class PessoaFisicaBusinessImpl extends PessoaBusinessImpl implements PessoaFisicaBusiness
{

	private PessoaFisicaDao pessoaFisicaDao = new PessoaFisicaDaoImpl();
	 
}
