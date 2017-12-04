package models;

public class Atencion {

	private String codAtencion; // Similares a este => "Ate001"
	private String codPaciente; // Similares a este => "Pac001"
	private String fechaAtencion;
	private String codDetalleAtencion;
	private String estado;
	private double totalPagar;
	
	public Atencion(String codAtencion, String codPaciente, String fechaAtencion, String codDetalleAtencion, String estado, double totalPagar) {
		this.codAtencion = codAtencion;
		this.codPaciente = codPaciente;
		this.fechaAtencion = fechaAtencion;
		this.codDetalleAtencion = codDetalleAtencion;
		this.estado = estado;
		this.totalPagar = totalPagar;
	}

	public double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}

	public String getCodDetalleAtencion() {
		return codDetalleAtencion;
	}

	public void setCodDetalleAtencion(String codDetalleAtencion) {
		this.codDetalleAtencion = codDetalleAtencion;
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


	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}