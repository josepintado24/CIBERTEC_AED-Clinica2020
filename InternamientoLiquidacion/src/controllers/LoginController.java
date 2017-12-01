package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import controllers.MantenimientoEmpleadosController;
import models.Empleado;

public class LoginController {

	private String file;
	MantenimientoEmpleadosController empleados = new MantenimientoEmpleadosController("empleados.txt");
	
	public LoginController(String file){
		this.file = file;
		nameUser();
	}
	
	public void saveUser(String user){
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(file));
			pw.println(user);
			pw.close();
		}
		catch(Exception err){
			System.out.println("saveUser error: " + err);
		}
	}
	
	public String getUser(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String read, user;
			while((read = br.readLine()) != null){
				user = read;
				return user;
			}
			br.close();
		}
		catch(Exception err){
			System.out.println("getUser error: " + err);
		}
		return null;
	}
	
	public String nameUser(){
		try {
			String user = getUser();
			Empleado searchEmpleado = empleados.buscarPorUsuario(user);
			if(searchEmpleado != null){
				return searchEmpleado.getNombre();
			}
		}
		catch(Exception err){
			System.out.println("Error en nameUser: " + err);
		}
		return null;
	}
	
}
