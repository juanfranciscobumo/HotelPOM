package com.qvision.certificacion.agenciadeviajes.utils;

import java.util.List;

import org.openqa.selenium.WebElement;

public class BuscarFecha {
private WebElement mesInicial;
private WebElement btnNext;
private List<WebElement> ltDias;
private String mes;
private String ano;
private String dia;
public BuscarFecha(WebElement mesInicial, WebElement btnNext, List<WebElement> ltDias, String mes, String ano,
		String dia) {
	this.mesInicial = mesInicial;
	this.btnNext = btnNext;
	this.ltDias = ltDias;
	this.mes = mes;
	this.ano = ano;
	this.dia = dia;
}
public void seleccionarFecha() throws InterruptedException {
     Thread.sleep(3000);
	boolean a=true;
	while(a) {
	if(mesInicial.getText().contains(mes) && mesInicial.getText().contains(ano) ) {
		Thread.sleep(3000);
		for(WebElement e : ltDias) { 
			  if(e.getText().equals(dia)) { 
				  e.click();
				  a=false;    				 
			  }
			}
	}else {
		btnNext.click();
	}
	}
}
}
