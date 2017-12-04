package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import models.DetalleAtencion;

public class DetalleAtencionController {
	
	private ArrayList<DetalleAtencion> detalle;
	private ArrayList<DetalleAtencion> listDetalle;
	private String file;

	public DetalleAtencionController(String file) {
		detalle = new ArrayList<DetalleAtencion>();
		listDetalle = new ArrayList<DetalleAtencion>();
		this.file = file;
		cargarDetalle();
	}

	public int tamano() {
		return detalle.size();
	}

	public DetalleAtencion obtener(int i) {
		return detalle.get(i);
	}

	public void adicionar(DetalleAtencion p) {
		detalle.add(p);
	}

	public void guardarDetalle() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(file));
			String data;

			for (int i = 0; i < tamano(); i++) {
				DetalleAtencion detalle = obtener(i);
				data = detalle.getCodDetalleAtencion() + "#";
				data += detalle.getCodAtencion() + "#";
				data += detalle.getCodMedicina() + "#";
				data += detalle.getCantidad() + "#";
				data += detalle.getPrecioUnitario() + "#";
				data += detalle.TotalPagar();
				pw.println(data);
			}
			pw.close();
		} catch (Exception err) {
			System.out.println(err);
		}
	}

	public void cargarDetalle() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String read, codAtencion, codDetalleAtencion, codMedicina;
			int cantidad;
			double PrecioUnitario, totalPagar;
			String data[];
			while ((read = br.readLine()) != null) {
				data = read.split("#");
				codDetalleAtencion = data[0];
				codAtencion = data[1];
				codMedicina = data[2];
				cantidad = Integer.parseInt(data[3].trim());
				PrecioUnitario = Double.parseDouble(data[4].trim());
				totalPagar = Double.parseDouble(data[5].trim());
				detalle.add(new DetalleAtencion(codDetalleAtencion, codAtencion, codMedicina, cantidad, PrecioUnitario, totalPagar));
			}
			br.close();
		} catch (Exception err) {
			System.out.println(err);
		}
	}

	public DetalleAtencion buscarPorCodigo(String codigo) {
		for (int i = 0; i < tamano(); i++)
			if (obtener(i).getCodDetalleAtencion().equalsIgnoreCase(codigo))
				return obtener(i);
		return null;
	}
	
	public ArrayList<DetalleAtencion> buscarPorCodigoAtencion(String codigo){
		listDetalle.clear();
		for (int i = 0; i < tamano(); i++)
			if (obtener(i).getCodAtencion().equalsIgnoreCase(codigo))
				listDetalle.add(obtener(i));
		return listDetalle;
	}

}
