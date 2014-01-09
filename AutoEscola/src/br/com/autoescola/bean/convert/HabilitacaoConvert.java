package br.com.autoescola.bean.convert;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.autoescola.bean.Habilitacao;
import br.com.autoescola.dao.HabilitacaoDAO;

public class HabilitacaoConvert implements Converter{


	public final static String CONVERTER_ID = "br.com.autoescola.bean.Habilitacao"; 

	@Override
	public Habilitacao getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("cliente.nome", valor);
		return new HabilitacaoDAO().buscaPorParametro(parametros);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		return ((Habilitacao) object).getCliente().getNome();
	}


}
