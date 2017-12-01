package models;

public class Atencion {

	private String codAtencion; // Similares a este => "Ate001"
	private String codPaciente; // Similares a este => "Pac001"
	private String fechaAtencion;
	private double totalPagar;
	private int estado;
	
	public Atencion(String codAtencion, String codPaciente, String fechaAtencion, double totalPagar, int estado) {
		this.codAtencion = codAtencion;
		this.codPaciente = codPaciente;
		this.fechaAtencion = fechaAtencion;
		this.totalPagar = totalPagar;
		this.estado = estado;
	}

	public String getCodAtencion() {
		return codAtencion;
	}

	public void setCodAtencion(String codAtencion) {
		this.codAtencion = codAtencion;
	}

	public String getCodPaciente() {
		return codPaciente;
	}

	public void setCodPaciente(String codPaciente) {
		this.codPaciente = codPaciente;
	}

	public String getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(String fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
