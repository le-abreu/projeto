package br.com.autoescola.bean.convert;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.autoescola.bean.Cliente;
import br.com.autoescola.dao.ClienteDAO;

public class ClienteConvert implements Converter{


	public final static String CONVERTER_ID = "br.com.autoescola.bean.Cliente";

	@Override
	public Cliente getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("pessoa.nome", valor);
		return new ClienteDAO().buscaPorParametro(parametros);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		return ((Cliente) object).getNome();
	}


}
