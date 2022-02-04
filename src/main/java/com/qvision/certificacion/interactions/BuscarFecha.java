package com.qvision.certificacion.interactions;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BuscarFecha extends PageObject {
    private WebElement mesInicial;
    private WebElement btnNext;
    private List<WebElement> ltDias;
    private String mes;
    private String ano;
    private String dia;

    public BuscarFecha(WebElement mesInicial, WebElement btnNext, List<WebElement> ltDias, String mes, String ano, String dia) {
        this.mesInicial = mesInicial;
        this.btnNext = btnNext;
        this.ltDias = ltDias;
        this.mes = mes;
        this.ano = ano;
        this.dia = dia;
    }

    public void action()  {
        waitABit(3000);
        boolean a = true;
        while (a) {
            if (mesInicial.getText().contains(mes) && mesInicial.getText().contains(ano)) {
                waitABit(3000);
                for (WebElement e : ltDias) {
                    if (e.getText().equals(dia)) {
                        e.click();
                        a = false;
                    }
                }
            } else {
                btnNext.click();
            }
        }
    }

    public static void seleccionaLaFecha(WebElement mesInicial, WebElement btnNext, List<WebElement> ltDias, String mes, String ano, String dia)  {
        new BuscarFecha(mesInicial, btnNext, ltDias, mes, ano, dia).action();
    }
}
