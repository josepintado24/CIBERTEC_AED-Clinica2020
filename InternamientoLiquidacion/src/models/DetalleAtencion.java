package models;

public class DetalleAtencion {

	private String codAtencion; // Similares a este => "Ate001"
	private String codMedicina; // Similares a este => "Med001"
	private int cantidad;
	private double precioUnitario;
	
	public DetalleAtencion(String codAtencion, String codMedicina, int cantidad, double precioUnitario) {
		this.codAtencion = codAtencion;
		this.codMedicina = codMedicina;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}

	public String getCodAtencion() {
		return codAtencion;
	}

	public void setCodAtencion(String codAtencion) {
		this.codAtencion = codAtencion;
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
	
}