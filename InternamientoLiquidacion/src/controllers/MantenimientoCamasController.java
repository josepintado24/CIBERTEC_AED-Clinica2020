package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import models.Cama;
import models.Paciente;

public class MantenimientoCamasController {

	private ArrayList<Cama> cama;
	private String file;
	
	public MantenimientoCamasController(String file){
		cama = new ArrayList<Cama>();
		this.file = file;
		cargarPacientes();
//		cama.add(new Cama(1, 25, 0));
//		cama.add(new Cama(2, 30, 1));
//		cama.add(new Cama(3, 40, 0));
	}
	
	public int tamanio(){
		return cama.size();
	}
	
	public Cama obtener(int i){
		return cama.get(i);
	}
	
	public Cama buscar(String nroCama){
		for(int i = 0; i < tamanio(); i++){
			if(obtener(i).getCodCama().equalsIgnoreCase(nroCama)){
				return obtener(i);
			}
		}
		return null;
	}
	
	public void ingresarCama(Cama newCama){
		cama.add(newCama);
	}
	
	public void eliminarCama(Cama dropCama){
		cama.remove(dropCama);
	}
	
	public int obtenerUltimoCodigo(){
		int mayor = 0;
		for(int i = 0; i < tamanio(); i++){
			int codeNum = Integer.parseInt(obtener(i).getCodCama().split("CAM")[1]);
			if(codeNum > mayor){
				mayor = codeNum;
			}
		}
		return mayor;
	}
	
	public void adicionar(Cama p){
		cama.add(p);
	}
	
	public void agregarCamas(){
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(file));
			String data;
			
			for(int i = 0; i < tamanio(); i++){
				Cama cama = obtener(i);
				data = cama.getCodCama() + "#";
				data += cama.getPrecioDia() + "#";
				data += cama.getEstado();
				pw.println(data);
			}
			pw.close();
		}
		catch(Exception err){
			
		}
	}
	
	public void cargarPacientes(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String read, codigo, estado;
			double precio;
			String data[];
			while((read = br.readLine()) != null){
				data = read.split("#");
				codigo = data[0];
				precio = Double.parseDouble(data[1]);
				estado = data[2];
				cama.add(new Cama(codigo, precio, estado));
			}
			br.close();
		}
		catch(Exception err){
			System.out.println("error");
		}
	}
	
	public Cama buscarPorCodigo(String codigo) {
		for (int i = 0; i < tamanio(); i++)
			if (obtener(i).getCodCama().equalsIgnoreCase(codigo))
				return obtener(i);
		return null;
	}
	
	public Cama buscarPorEstado(String estado){
		for (int i = 0; i < tamanio(); i++)
			if(obtener(i).getEstado().equalsIgnoreCase(estado))
				return obtener(i);
		return null;
	}
	
}
