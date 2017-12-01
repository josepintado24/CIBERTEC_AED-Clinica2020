package models;

public class Medicina {
	
	private String codMedicina; // Similares a este => "Med001"
	private String nombre;
	private String laboratorio;
	private double precio;
	private int stock;
	
	public Medicina(){}
	
	public Medicina(String codMedicina, String nombre, String laboratorio, double precio, int stock) {
		this.codMedicina = codMedicina;
		this.nombre = nombre;
		this.laboratorio = laboratorio;
		this.precio = precio;
		this.stock = stock;
	}

	public String getCodMedicina() {
		return codMedicina;
	}

	public void setCodMedicina(String codMedicina) {
		this.codMedicina = codMedicina;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
