package com.qvision.certificacion.agenciadeviajes.utils;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

public class ManipularExcel {
	private String nombre;
	private int dato;
	private String hoja;

	public ManipularExcel(String nombre, int dato, String hoja) {
		this.nombre = nombre;
		this.dato = dato;
		this.hoja = hoja;
	}

	public void grabarDatos() throws FilloException {
System.out.println(hoja);
		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection(
				"src\\test\\resources\\datadriven\\AgenciaDeViajes.xlsx");
		String strQuery = "Update " + hoja + " Set " + nombre + "='" + dato + "' where ID=1";
		connection.executeUpdate(strQuery);
		connection.close();
	}

}
