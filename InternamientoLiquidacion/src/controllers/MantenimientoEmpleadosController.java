package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import models.Empleado;
import models.Paciente;

public class MantenimientoEmpleadosController {

	private ArrayList<Empleado> empleado;
	private String file;
	
	public MantenimientoEmpleadosController(String file){
		this.empleado = new ArrayList<Empleado>();
		this.file = file;
		cargarEmpleados();
	}
	
	public int tamanio(){
		return empleado.size();
	}
	
	public Empleado obtener(int i){
		return empleado.get(i);
	}
	
	public void adicionar(Empleado emp){
		empleado.add(emp);
	}
	
	public Empleado buscarPorCodigo(String codigo) {
		for (int i = 0; i < tamanio(); i++)
			if (obtener(i).getCodEmpleado().equalsIgnoreCase(codigo))
				return obtener(i);
		return null;
	}
	
	public Empleado buscarPorApellido(String apellido){
		for (int i = 0; i < tamanio(); i++){
			int resultado = obtener(i).getApellidos().indexOf(apellido);
			if(resultado != -1)
				return obtener(i);
		}
		return null;
	}
	
	public Empleado buscarPorDni(String dni){
		for (int i = 0; i < tamanio(); i++){
			if(obtener(i).getDni() == Integer.parseInt(dni))
				return obtener(i);
		}
		return null;
	}
	
	public Empleado buscarPorCargo(String cargo){
		for(int i = 0; i < tamanio(); i++){
			int resultado = obtener(i).getCargo().indexOf(cargo);
			if(resultado != -1)
				return obtener(i);
		}
		return null;
	}
	
	public Empleado buscarPorUsuario(String user){
		for(int i = 0; i < tamanio(); i++){
			if(obtener(i).getUser().contentEquals(user)){
				return obtener(i);
			}
		}
		return null;
	}
	
	public int obtenerUltimoCodigo(){
		int mayor = 0;
		for(int i = 0; i < tamanio(); i++){
			int codeNum = Integer.parseInt(obtener(i).getCodEmpleado().split("EMP")[1]);
			if(codeNum > mayor){
				mayor = codeNum;
			}
		}
		return mayor;
	}
	
	public void eliminarEmpleado(Empleado dropEmpleado){
		empleado.remove(dropEmpleado);
	}
	
	public void agregarEmpleado(){
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(file));
			String data;
			
			for(int i = 0 ; i < tamanio(); i++){
				Empleado empleado = obtener(i);
				data = empleado.getCodEmpleado() + "#";
				data += empleado.getNombre() + "#";
				data += empleado.getApellidos() + "#";
				data += empleado.getDni() + "#";
				data += empleado.getTelefono() + "#";
				data += empleado.getCargo() + "#";
				data += empleado.getUser() + "#";
				data += empleado.getPassword();
				pw.println(data);
			}
			pw.close();
		}
		catch(Exception err){
			System.out.println(err);
		}
	}
	
	public void cargarEmpleados(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String read, codigo, nombre, apellidos, cargo, user, password;
			String data[];
			int telefono, dni;
			while((read = br.readLine()) != null){
				data = read.split("#");
				codigo = data[0];
				nombre = data[1];
				apellidos = data[2];
				dni = Integer.parseInt(data[3]);
				telefono = Integer.parseInt(data[4]);
				cargo = data[5];
				user = data[6];
				password = data[7];
				empleado.add(new Empleado(codigo, nombre, apellidos, telefono, dni, cargo, user, password));
			}
			br.close();
		}
		catch(Exception err){
			System.out.println("error: " + err);
		}
	}
	
}
