package br.com.autoescola.bean;

public class Document {

	private String nome;
	private String valor;
	private String tipo;

	public Document(String nome, String valor, String tipo) {
		this.nome = nome;
		this.valor = valor;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
