package models;

public class Paciente {

	private String codPaciente; // Similares a este => "Pac001"
	private String apellidos;
	private String nombres;
	private int telefono;
	private int dni;
	
	public Paciente(){}
	
	public Paciente(String codPaciente, String apellidos, String nombres){
		this.codPaciente = codPaciente;
		this.apellidos = apellidos;
		this.nombres = nombres;
	}
	
	public Paciente(String codPaciente, String apellidos, String nombres, int telefono, int dni) {
		this.codPaciente = codPaciente;
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.telefono = telefono;
		this.dni = dni;
	}

	public String getCodPaciente() {
		return codPaciente;
	}

	public void setCodPaciente(String codPaciente) {
		this.codPaciente = codPaciente;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	
}
