package br.com.autoescola.handler;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.autoescola.bean.Cargo;
import br.com.autoescola.dao.CargoDAO;

@RequestScoped
@ManagedBean(name = "cargoHandler")
public class CargoHandler implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cargo cargo = new Cargo();
	private CargoDAO cargoDAO = new CargoDAO();

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Cargo> getCargos() {
		return cargoDAO.lista();
	}
	
	public Cargo getNovoCargo() {
		return new Cargo();
	}
	
	public String persistirCargo(){
		cargoDAO.update(cargo);
		cargo = new Cargo();
		return "sucesso";
	}

}