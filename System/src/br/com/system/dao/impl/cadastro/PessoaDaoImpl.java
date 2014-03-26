package br.com.system.dao.impl.cadastro;

import java.util.Date;
import java.util.List;

import br.com.system.dao.JPAUtil;
import br.com.system.dao.cadastro.PessoaDao;
import br.com.system.dao.impl.GenericsDAOImpl;
import br.com.system.model.cadastro.Pessoa;

public class PessoaDaoImpl extends GenericsDAOImpl<Pessoa> implements PessoaDao{

	public PessoaDaoImpl() {
		super(JPAUtil.getEntityManager(), Pessoa.class);
	}


	@Override
	public List<Pessoa> findPessoaDaoFilters() {
		return null;
	}

	public static class PessoaDaoFilters{

		//- campos para pesquisa
		private Long id;
		private String nome;
		private Date dataNascimento;
		
		//- GET - SET
		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}
		
		public String getNome() {
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public Date getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(Date dataNascimento) {
			this.dataNascimento = dataNascimento;
		}

	}
}
