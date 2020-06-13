package com.qvision.certificacion.agenciadeviajes.utils;

import com.codoid.products.exception.FilloException;

public class CalcularTarifa {
	public CalcularTarifa() {
		
	}

public String laTarifa() throws NumberFormatException, FilloException  {
	LeerdatosExcel leerDatosExcel=new LeerdatosExcel();
	int total=0;
	int dias=Integer.parseInt(leerDatosExcel.getNumeroDias());
	int valor=Integer.parseInt(leerDatosExcel.getTarifa());
	total=(dias+1)*valor;
	return String.valueOf(total);
}
}
