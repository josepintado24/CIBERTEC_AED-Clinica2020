package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import models.Paciente;

public class MantenimientoPacientesController {

	private ArrayList<Paciente> paciente;
	private ArrayList<Paciente> busquedaApellido;
	private String file;
	
	public MantenimientoPacientesController(String file){
		paciente = new ArrayList<Paciente>();
		busquedaApellido = new ArrayList<Paciente>();
		this.file = file;
		cargarPacientes();
	}
	
	public int tamanio(){
		return paciente.size();
	}
	
	public Paciente obtener(int i){
		return paciente.get(i);
	}
	
	public void cargarPacientes(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String read, codigo, nombre, apellidos;
			String data[];
			int telefono, dni;
			while((read = br.readLine()) != null){
				data = read.split("#");
				codigo = data[0];
				apellidos = data[1];
				nombre = data[2];
				dni = Integer.parseInt(data[3]);
				telefono = Integer.parseInt(data[4]);
				paciente.add(new Paciente(codigo, apellidos, nombre, telefono, dni));
			}
			br.close();
		}
		catch(Exception err){
			System.out.println("error");
		}
	}
	
	public void adicionar(Paciente p){
		paciente.add(p);
	}
	
	public Paciente buscarPorCodigo(String codigo) {
		for (int i = 0; i < tamanio(); i++)
			if (obtener(i).getCodPaciente().equalsIgnoreCase(codigo))
				return obtener(i);
		return null;
	}
	
	public Paciente buscarPorApellido(String apellido){
		for (int i = 0; i < tamanio(); i++){
			int resultado = obtener(i).getApellidos().indexOf(apellido);
			if(resultado != -1)
				return obtener(i);
		}
		return null;
	}
	
	public Paciente buscarPorDni(String dni){
		for (int i = 0; i < tamanio(); i++){
			if(obtener(i).getDni() == Integer.parseInt(dni))
				return obtener(i);
		}
		return null;
	}
	
	public ArrayList<Paciente> listPacientesApellidos(String apellido){
		busquedaApellido.clear();
		for(int i = 0; i < tamanio(); i++){
			String term = removeAcent(obtener(i).getApellidos());
			if(term.toLowerCase().startsWith(apellido) || term.startsWith(apellido) || term.toUpperCase().startsWith(apellido)){
				busquedaApellido.add(obtener(i));
			}
		}
		return busquedaApellido;
	}
	
	public String removeAcent(String input) {
	    String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
	    String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
	    String output = input;
	    for(int i = 0; i < original.length(); i++) {
	        output = output.replace(original.charAt(i), ascii.charAt(i));
	    }
	    return output;
	}
	
	public ArrayList<Paciente> listPacientesDni(String dni){
		busquedaApellido.clear();
		for(int i = 0; i < tamanio(); i++){
			if(Integer.toString(obtener(i).getDni()).startsWith(dni)){
				busquedaApellido.add(obtener(i));
			}
		}
		return busquedaApellido;
	}
	
	public void agregarPaciente(){
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(file));
			String data;
			
			for(int i = 0 ; i < tamanio(); i++){
				Paciente paciente = obtener(i);
				data = paciente.getCodPaciente() + "#";
				data += paciente.getApellidos() + "#";
				data += paciente.getNombres() + "#";
				data += paciente.getDni() + "#";
				data += paciente.getTelefono();
				pw.println(data);
			}
			pw.close();
		}
		catch(Exception err){
			
		}
	}
	
	public void eliminarPaciente(Paciente dropPaciente){
		paciente.remove(dropPaciente);
	}
	
	public int obtenerUltimoCodigo(){
		int mayor = 0;
		for(int i = 0; i < tamanio(); i++){
			int codeNum = Integer.parseInt(obtener(i).getCodPaciente().split("PAC")[1]);
			if(codeNum > mayor){
				mayor = codeNum;
			}
		}
		return mayor;
	}
	
}
