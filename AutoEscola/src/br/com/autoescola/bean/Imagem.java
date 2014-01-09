package br.com.autoescola.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Imagem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String tipo;
	
	@Column
	private String caminho =  "imagemSistema/temp/fotoPessoa";
	
	@Column
	private String arquivo = "fotoPerfilPadrao.jpg";

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	
	public String getImagem() {
		return (!arquivo.equals("fotoPerfilPadrao.jpg")? "../../../":"../../") +this.caminho+"/"+this.arquivo;
	}
	
	
}
