package com.qvision.certificacion.agenciadeviajes.utils;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class LeerdatosExcel {
	public String getNumeroDias() throws FilloException {
		Fillo fillo=new Fillo();
		String dias = null;
		Connection connection = fillo.getConnection(
				"src\\\\test\\resources\\datadriven\\AgenciaDeViajes.xlsx");
		String strQuery = "Select * from Tarifa where ID=1";
		Recordset recordset = connection.executeQuery(strQuery);

		while (recordset.next()) {
			dias = recordset.getField("NUMERODEDIAS");
		}
		recordset.close();
		connection.close();
		return dias;
	}
	public String getTarifa() throws FilloException {
		Fillo fillo=new Fillo();
		String tarifa = null;
		Connection connection = fillo.getConnection(
				"src\\\\test\\resources\\datadriven\\AgenciaDeViajes.xlsx");
		String strQuery = "Select * from Tarifa where ID=1";
		Recordset recordset = connection.executeQuery(strQuery);

		while (recordset.next()) {
			tarifa = recordset.getField("TARIFAMASECONOMICA");
		}
		recordset.close();
		connection.close();
		return tarifa;
	}
}
