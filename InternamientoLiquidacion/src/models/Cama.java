package models;

public class Cama {
	
	private String codCama;
	private double precioDia;
	private String estado; // 0: Libre, 1: Ocupada, por defecto empezará en 0
	
	public Cama(String codCama, double precioDia, String estado) {
		this.codCama = codCama;
		this.precioDia = precioDia;
		this.estado = estado;
	}

	public String getCodCama() {
		return codCama;
	}

	public void setCodCama(String codCama) {
		this.codCama = codCama;
	}

	public double getPrecioDia() {
		return precioDia;
	}

	public void setPrecioDia(double precioDia) {
		this.precioDia = precioDia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
