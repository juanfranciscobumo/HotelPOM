package com.qvision.certificacion.agenciadeviajes.utils;

import java.util.List;
import java.util.Vector;

import org.openqa.selenium.WebElement;

import com.codoid.products.exception.FilloException;

public class PrecioMasBajo {
private List<WebElement> ltPrecios;

	public PrecioMasBajo(List<WebElement> ltPrecios) {
	this.ltPrecios = ltPrecios;
}

	public Integer obtenerPrecioMasBajo() throws InterruptedException, FilloException{
		Vector<Integer> v = new Vector<Integer>();
		int aux=0;
        Thread.sleep(2000); 
			 for(WebElement e : ltPrecios) { 
			   v.add(Integer.parseInt(e.getText().replace("$","")));
				}	
			    for(int i=1;i<v.size();i++) {
			    	aux=v.get(0);
			    	if(v.get(i)<aux) {
			    		aux=v.get(i);			    		
			    	}			    	
				}
			    ManipularExcel guardarEnExcel=new ManipularExcel("TARIFAMASECONOMICA",aux, "Tarifa");
			    guardarEnExcel.grabarDatos();
			    return aux;

	}

}
