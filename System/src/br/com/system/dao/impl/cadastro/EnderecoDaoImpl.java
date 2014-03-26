package br.com.system.dao.impl.cadastro;

import java.util.List;

import br.com.system.cadastro.model.enumaretor.Classificador;
import br.com.system.dao.JPAUtil;
import br.com.system.dao.cadastro.EnderecoDao;
import br.com.system.dao.impl.GenericsDAOImpl;
import br.com.system.model.cadastro.Endereco;

public class EnderecoDaoImpl extends GenericsDAOImpl<Endereco> implements EnderecoDao{

	public EnderecoDaoImpl() {
		super(JPAUtil.getEntityManager(), Endereco.class);
	}


	@Override
	public List<Endereco> findEnderecoDaoFilters() {
		return null;
	}

	public static class EnderecoDaoFilters{
		
		private Long id;
		private String cep;
		private Classificador tipoEndereco;
		private String uf;
		private String logradouro;
		private String numero;
		private String complemento;
		private String bairro;
		private String cidade;
		private String observacao;
		
		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}

		public String getCep() {
			return cep;
		}

		public void setCep(String cep) {
			this.cep = cep;
		}

		public Classificador getTipoEndereco() {
			return tipoEndereco;
		}

		public void setTipoEndereco(Classificador tipoEndereco) {
			this.tipoEndereco = tipoEndereco;
		}

		public String getUf() {
			return uf;
		}

		public void setUf(String uf) {
			this.uf = uf;
		}

		public String getLogradouro() {
			return logradouro;
		}

		public void setLogradouro(String logradouro) {
			this.logradouro = logradouro;
		}

		public String getNumero() {
			return numero;
		}

		public void setNumero(String numero) {
			this.numero = numero;
		}

		public String getComplemento() {
			return complemento;
		}

		public void setComplemento(String complemento) {
			this.complemento = complemento;
		}

		public String getBairro() {
			return bairro;
		}

		public void setBairro(String bairro) {
			this.bairro = bairro;
		}

		public String getCidade() {
			return cidade;
		}

		public void setCidade(String cidade) {
			this.cidade = cidade;
		}

		public String getObservacao() {
			return observacao;
		}

		public void setObservacao(String observacao) {
			this.observacao = observacao;
		}
		
	}
}
