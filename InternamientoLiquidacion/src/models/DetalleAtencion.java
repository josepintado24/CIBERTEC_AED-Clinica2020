package models;

public class DetalleAtencion {

	private String codDetalleAtencion; // Similares a este => "Dea001"
	private String codAtencion; // Similares a este => "Ate001"
	private String codMedicina; // Similares a este => "Med001"
	private int cantidad;
	private double precioUnitario;
	private double totalPagar;
	
	public DetalleAtencion(String codDetalleAtencion, String codAtencion, String codMedicina, int cantidad, double precioUnitario, double totalPagar) {
		this.codDetalleAtencion = codDetalleAtencion;
		this.codAtencion = codAtencion;
		this.codMedicina = codMedicina;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.totalPagar = totalPagar;
	}

	public double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}

	public String getCodAtencion() {
		return codAtencion;
	}

	public void setCodAtencion(String codAtencion) {
		this.codAtencion = codAtencion;
	}

	public String getCodDetalleAtencion() {
		return codDetalleAtencion;
	}

	public void setCodDetalleAtencion(String codDetalleAtencion) {
		this.codDetalleAtencion = codDetalleAtencion;
	}

	public String getCodMedicina() {
		return codMedicina;
	}

	public void setCodMedicina(String codMedicina) {
		this.codMedicina = codMedicina;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	public double TotalPagar(){
		return cantidad*precioUnitario;
	}
	
}