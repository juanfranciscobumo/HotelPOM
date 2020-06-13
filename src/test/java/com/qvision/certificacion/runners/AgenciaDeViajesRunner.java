package com.qvision.certificacion.runners;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import com.qvision.certificacion.agenciadeviajes.utils.BeforeSuite;
import com.qvision.certificacion.agenciadeviajes.utils.DataToFeature;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(features="src/test/resources/features/AgenciaDeViajes.feature", 
glue="com/co/qvision/certificacion/steps/", 
snippets=SnippetType.CAMELCASE)
public class AgenciaDeViajesRunner {
	private AgenciaDeViajesRunner() {
		
	}
	@BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles("./src/test/resources/features/AgenciaDeViajes.feature");
    }
}
