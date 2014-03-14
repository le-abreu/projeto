package br.com.system.cadastro.view;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.system.cadastro.model.enumaretor.Classificador;

@RequestScoped
@ManagedBean(name = "classificadorBean")
public class ClassificadorBean implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Classificador> getClassificadorEnum() {
		return Arrays.asList(Classificador.values());
	} 
	
}