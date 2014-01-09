package br.com.autoescola.bean.convert;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.autoescola.bean.Endereco;
import br.com.autoescola.dao.EnderecoDAO;

public class EnderecoConvert implements Converter{


	public final static String CONVERTER_ID = "br.com.autoescola.bean.Endereco";

	@Override
	public Endereco getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		return new EnderecoDAO().buscaPorParametro(valor, null, null, null, null, null, null);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		return ((Endereco) object).getCliente() == null ? ((Endereco) object).getFuncionario().getNome(): ((Endereco) object).getCliente().getNome();
	}


}
