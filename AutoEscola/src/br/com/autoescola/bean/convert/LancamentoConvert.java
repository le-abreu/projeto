package br.com.autoescola.bean.convert;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.autoescola.bean.Lancamento;
import br.com.autoescola.dao.LancamentoDAO;

public class LancamentoConvert implements Converter {

	public final static String CONVERTER_ID = "br.com.autoescola.bean.Lancamento";
	
	@Override
	public Lancamento getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("titulo", valor);
		return new LancamentoDAO().buscaPorParametro(parametros);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		return object == null ? "" : ((Lancamento) object).getTitulo();
	}

}
