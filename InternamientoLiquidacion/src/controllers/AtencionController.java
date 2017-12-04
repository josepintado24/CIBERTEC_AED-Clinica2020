package controllers;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import models.Atencion;

public class AtencionController {
	private ArrayList<Atencion> atencion;
	private String file;
	
	public AtencionController(String file){
		atencion = new ArrayList<Atencion>();
		this.file = file;
		cargarAtencion();
	}
	
	public int tamano(){
		return atencion.size();
	}
	
	public Atencion obtener(int i){
		return atencion.get(i);
	}
	
	public void adicionar(Atencion p){
		atencion.add(p);
	}
	
	public void guardarAtencion(){
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(file));
			String data;
			
			for(int i = 0 ; i < tamano(); i++){
				Atencion atencion = obtener(i);
				data = atencion.getCodAtencion() + "#";
				data += atencion.getCodPaciente() + "#";
				data += atencion.getFechaAtencion() + "#";
				data += atencion.getCodDetalleAtencion() + "#";
				data += atencion.getEstado() + "#";
				data += atencion.getTotalPagar() + "";
				pw.println(data);
			}
			pw.close();
		}
		catch(Exception err){
			System.out.println(err);
		}
	}
	
	public void cargarAtencion(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String read, codAtencion, codPaciente, FechaAtencion, codDetalleAtencion, estado;
			double totalPagar;
			String data[];
			while((read = br.readLine()) != null){
				data = read.split("#");
				codAtencion = data[0];
				codPaciente = data[1];
				FechaAtencion = data[2];
				codDetalleAtencion = data[3];
				estado = data[4];
				totalPagar = Double.parseDouble(data[5]);
				atencion.add(new Atencion(codAtencion, codPaciente, FechaAtencion, codDetalleAtencion, estado, totalPagar));
			}
			br.close();
		}
		catch(Exception err){
			System.out.println(err);
		}
	}
	
	public int obtenerUltimoCodigo(){
		int mayor = 0;
		for(int i = 0; i < tamano(); i++){
			int codeNum = Integer.parseInt(obtener(i).getCodAtencion().split("ATE")[1]);
			if(codeNum > mayor){
				mayor = codeNum;
			}
		}
		return mayor;
	}
	
	public Atencion Buscar(String cod){
		for(int i=0;i<tamano();i++)
			if(obtener(i).getCodAtencion().equals(cod))
				return obtener(i);
		return null;
	}
	
}
