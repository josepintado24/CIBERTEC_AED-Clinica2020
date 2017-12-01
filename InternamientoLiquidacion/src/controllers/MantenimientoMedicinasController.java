package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import models.Medicina;

public class MantenimientoMedicinasController {

	private ArrayList<Medicina> medicina;
	private String file;
	
	public MantenimientoMedicinasController(String file){
		medicina = new ArrayList<Medicina>();
		this.file = file;
	}
	
	public int tamanio(){
		return medicina.size();
	}
	
	public Medicina obtener(int i){
		return medicina.get(i);
	}
	
	public void adicionar(Medicina p){
		medicina.add(p);
	}
	
	public Medicina buscarPorCodigo(String codigo){
		for(int i = 0; i < tamanio(); i++){
			if(obtener(i).getCodMedicina().equalsIgnoreCase(codigo)){
				return obtener(i);
			}
		}
		return null;
	}
	
	public Medicina buscarPorNombre(String nombre){
		for (int i = 0; i < tamanio(); i++){
			int resultado = obtener(i).getNombre().indexOf(nombre);
			if(resultado != -1)
				return obtener(i);
		}
		return null;
	}
	
	public Medicina buscarPorLaboratorio(String laboratorio){
		for (int i = 0; i < tamanio(); i++){
			int resultado = obtener(i).getLaboratorio().indexOf(laboratorio);
			if(resultado != -1)
				return obtener(i);
		}
		return null;
	}
	
	public void ingresarMedicina(Medicina newMedicina){
		medicina.add(newMedicina);
	}
	
	public void eliminarMedicina(Medicina dropMedicina){
		medicina.remove(dropMedicina);
	}
	
	public void agregarMedicina(){
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(file));
			String data;
			
			for(int i = 0 ; i < tamanio(); i++){
				Medicina medicina = obtener(i);
				data = medicina.getCodMedicina() + "#";
				data += medicina.getNombre() + "#";
				data += medicina.getLaboratorio() + "#";
				data += medicina.getPrecio() + "#";
				data += medicina.getStock();
				pw.println(data);
			}
			pw.close();
		}
		catch(Exception err){
			
		}
	}
	
	public void cargarMedicinas(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String read, codigo, nombre, laboratorio;
			double precio;
			int stock;
			String data[];
			while((read = br.readLine()) != null){
				data = read.split("#");
				codigo = data[0];
				nombre = data[1];
				laboratorio = data[2];
				precio = Double.parseDouble(data[3]);
				stock = Integer.parseInt(data[4]);
				medicina.add(new Medicina(codigo, nombre, laboratorio, precio, stock));
			}
			br.close();
		}
		catch(Exception err){
			System.out.println("error" + err);
		}
	}
	
	public int obtenerUltimoCodigo(){
		int mayor = 0;
		for(int i = 0; i < tamanio(); i++){
			int codeNum = Integer.parseInt(obtener(i).getCodMedicina().split("MED")[1]);
			if(codeNum > mayor){
				mayor = codeNum;
			}
		}
		return mayor;
	}
	
}
