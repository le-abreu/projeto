package br.com.system.view.cadastro;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class UserSessionSecuriy {

	public void getUsuarioSessao() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
	}

	public String getDiretorioAplicacao() {
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		return externalContext.getRealPath("");
	}
}
