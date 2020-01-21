package br.com.rsi.hub_tdd.steps.relatorios;

import java.io.IOException;

import org.apache.commons.logging.impl.Log4JLogger;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class GeradorCadastroSucesso {
	static ExtentReports extent;
    static ExtentTest logger;
    static ExtentHtmlReporter reporter;
	
    	
	public static void relatorioCadastroComSucesso() throws IOException {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./RelatoriosTest/RelatorioDeTestSucesso.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		logger = extent.createTest("CadastroComSucesso"); 
		logger.log(Status.INFO, "Novo Usuario");
		logger.log(Status.PASS, "Sucesso");
		
		extent.flush();
		ExtentTest logger1 = extent.createTest("Falha no Test");
		logger1.log(Status.FAIL, "Falha na verificacao do teste");
//		logger1.fail("Falhou devido a algum problema");
		extent.flush();
	}
	
	
	

}
