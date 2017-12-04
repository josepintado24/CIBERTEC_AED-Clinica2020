package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import models.Internamiento;

public class InternamientoPacientesController {

	private ArrayList<Internamiento> internamiento;
	private ArrayList<Internamiento> busquedaInternado;
	private ArrayList<Internamiento> internamientoPagadoBuscar;
	private String file;
	
	public InternamientoPacientesController(String file){
		internamiento = new ArrayList<Internamiento>();
		busquedaInternado = new ArrayList<Internamiento>();
		internamientoPagadoBuscar = new ArrayList<Internamiento>();
		this.file = file;
		cargarInternamientos();
	}
	
	public int tamanio(){
		return internamiento.size();
	}
	
	public Internamiento obtener(int i){
		return internamiento.get(i);
	}
	
	public void adicionar(Internamiento p){
		internamiento.add(p);
	}
	
	public Internamiento buscarPorCodigoInternamiento(String codigo) {
		for (int i = 0; i < tamanio(); i++)
			if (obtener(i).getCodInternamiento().equalsIgnoreCase(codigo))
				return obtener(i);
		return null;
	}
	
	public Internamiento buscarPorCodigoPaciente(String codigo) {
		for (int i = 0; i < tamanio(); i++)
			if (obtener(i).getCodPaciente().equalsIgnoreCase(codigo))
				return obtener(i);
		return null;
	}
	
	public Internamiento buscarPorCodigoCama(String codigo) {
		for (int i = 0; i < tamanio(); i++)
			if (obtener(i).getCodCama().equalsIgnoreCase(codigo))
				return obtener(i);
		return null;
	}
	
	public ArrayList<Internamiento> listInternadoCodigoInternamiento(String codigo){
		busquedaInternado.clear();
		for(int i = 0; i < tamanio(); i++){
			if(obtener(i).getCodInternamiento().startsWith(codigo))
				busquedaInternado.add(obtener(i));
		}
		return busquedaInternado;
	}
	
	public ArrayList<Internamiento> listInternadoCodigoPaciente(String codigo){
		busquedaInternado.clear();
		for(int i = 0; i < tamanio(); i++){
			if(obtener(i).getCodPaciente().startsWith(codigo))
				busquedaInternado.add(obtener(i));
		}
		return busquedaInternado;
	}
	
	public ArrayList<Internamiento> listInternadoCodigoCama(String codigo){
		busquedaInternado.clear();
		for(int i = 0; i < tamanio(); i++){
			if(obtener(i).getCodCama().startsWith(codigo))
				busquedaInternado.add(obtener(i));
		}
		return busquedaInternado;
	}
	
	public ArrayList<Internamiento> listInternadoPagado(){
		busquedaInternado.clear();
		for(int i = 0; i < tamanio(); i++){
			if(obtener(i).getEstado().equalsIgnoreCase("Alta"))
				busquedaInternado.add(obtener(i));
		}
		return busquedaInternado;
	}
	
	public ArrayList<Internamiento> listInternadoPagadoBuscarCodInternamiento(String codigo){
		internamientoPagadoBuscar.clear();
		for(int i = 0; i < busquedaInternado.size(); i++){
			if(busquedaInternado.get(i).getCodInternamiento().startsWith(codigo))
				internamientoPagadoBuscar.add(busquedaInternado.get(i));
		}
		return internamientoPagadoBuscar;
	}
	
	public ArrayList<Internamiento> listInternadoPagadoBuscarCodPaciente(String codigo){
		internamientoPagadoBuscar.clear();
		for(int i = 0; i < busquedaInternado.size(); i++){
			if(busquedaInternado.get(i).getCodPaciente().startsWith(codigo))
				internamientoPagadoBuscar.add(busquedaInternado.get(i));
		}
		return internamientoPagadoBuscar;
	}
	
	public ArrayList<Internamiento> listInternadoPagadoBuscarCodCama(String codigo){
		internamientoPagadoBuscar.clear();
		for(int i = 0; i < busquedaInternado.size(); i++){
			if(obtener(i).getCodCama().startsWith(codigo))
				internamientoPagadoBuscar.add(obtener(i));
		}
		return internamientoPagadoBuscar;
	}
	
	public void agregarInternamiento(){
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(file));
			String data;
			
			for(int i = 0 ; i < tamanio(); i++){
				Internamiento internamiento = obtener(i);
				data = internamiento.getCodInternamiento() + "#";
				data += internamiento.getCodPaciente() + "#";
				data += internamiento.getNombre() + "#";
				data += internamiento.getCodCama() + "#";
				data += internamiento.getFechaIngreso() + "#";
				data += internamiento.getHoraIngreso() + "#";
				data += internamiento.getFechaSalida() + "#";
				data += internamiento.getHoraSalida() + "#";
				data += internamiento.getEstado();
				pw.println(data);
			}
			pw.close();
		}
		catch(Exception err){
			System.out.println(err);
		}
	}
	
	public void cargarInternamientos(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String read, codInternamiento, codPaciente, nombre, codCama, fechaIngreso, horaIngreso, fechaSalida, horaSalida, estado;
			String data[];
			while((read = br.readLine()) != null){
				data = read.split("#");
				codInternamiento = data[0];
				codPaciente = data[1];
				nombre = data[2];
				codCama = data[3];
				fechaIngreso = data[4];
				horaIngreso = data[5];
				fechaSalida = data[6];
				horaSalida = data[7];
				estado = data[8];
				internamiento.add(new Internamiento(codInternamiento, codPaciente, nombre, codCama, fechaIngreso, horaIngreso, fechaSalida, horaSalida, estado));
			}
			br.close();
		}
		catch(Exception err){
			System.out.println(err);
		}
	}
	
	public void eliminarInternamiento(Internamiento dropInternamiento){
		internamiento.remove(dropInternamiento);
	}
	
	public int obtenerUltimoCodigo(){
		int mayor = 0;
		for(int i = 0; i < tamanio(); i++){
			int codeNum = Integer.parseInt(obtener(i).getCodInternamiento().split("INT")[1]);
			if(codeNum > mayor){
				mayor = codeNum;
			}
		}
		return mayor;
	}
	
}
