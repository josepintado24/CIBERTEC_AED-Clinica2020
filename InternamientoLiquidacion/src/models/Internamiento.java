package models;

public class Internamiento {

	private String codInternamiento; // Similares a este => "Int001"
	private String codPaciente; // Similares a este => "Pac001"
	private String nombre;
	private String codCama;
	private String fechaIngreso;
	private String horaIngreso;
	private String fechaSalida;
	private String horaSalida;
	private String estado;
	
	public Internamiento(String codInternamiento, String codPaciente, String nombre, String codCama, String fechaIngreso, String horaIngreso, String fechaSalida, String horaSalida, String estado) {
		this.codInternamiento = codInternamiento;
		this.codPaciente = codPaciente;
		this.nombre = nombre;
		this.codCama = codCama;
		this.fechaIngreso = fechaIngreso;
		this.horaIngreso = horaIngreso;
		this.fechaSalida = fechaSalida;
		this.horaSalida = horaSalida;
		this.estado = estado;
	}

	public String getCodInternamiento() {
		return codInternamiento;
	}

	public void setCodInternamiento(String codInternamiento) {
		this.codInternamiento = codInternamiento;
	}

	public String getCodPaciente() {
		return codPaciente;
	}

	public void setCodPaciente(String codPaciente) {
		this.codPaciente = codPaciente;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getCodCama() {
		return codCama;
	}

	public void setCodCama(String codCama) {
		this.codCama = codCama;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(String horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
