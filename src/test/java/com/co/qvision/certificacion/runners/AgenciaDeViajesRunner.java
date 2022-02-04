package com.co.qvision.certificacion.runners;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/AgenciaDeViajes.feature",
        glue = "com/co/qvision/certificacion/steps",
        snippets = CAMELCASE)
public class AgenciaDeViajesRunner {

}
