package br.com.system.view.cadastro;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.system.cadastro.model.enumaretor.SexoEnum;

@ViewScoped
@ManagedBean(name = "enumBean")
public class EnumBean implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<SexoEnum> getSexoEnum() {
		return Arrays.asList(SexoEnum.values());
	}
	
}