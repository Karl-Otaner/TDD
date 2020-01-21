package br.com.rsi.hub_tdd.steps.test.positivo;

import static org.junit.Assert.*;


import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import br.com.rsi.hub_tdd.screenshort.Generator;
import br.com.rsi.hub_tdd.screenshort.Screenshort;
import br.com.rsi.hub_tdd.steps.PageObject.BuscaProduto;
import br.com.rsi.hub_tdd.steps.excel.Constant;
import br.com.rsi.hub_tdd.steps.excel.ExcelUtils;
import br.com.rsi.hub_tdd.steps.excel.MenssageTest;
import br.com.rsi.hub_tdd.steps.home_page.HomePage;
import br.com.rsi.hub_tdd.steps.home_page.IrParaHomePage;

public class TestBuscarProdutoNaTelaPrincipal {
	private static WebDriver driver;
	
	@BeforeMethod
	public static void setUp() { 
		
		driver = IrParaHomePage.abreSite();
		IrParaHomePage.aguardeElemento();
	}
	
	@Test
	public void testBuscaProdutoPelaTelaPrincipal() throws Exception {
		
//		Thread.sleep(2000);
		HomePage.produtoDaTelaPrincipal(driver).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
		BuscaProduto.produtoEscolido(driver).click();
		
		assertEquals("HP PRO TABLET 608 G1", MenssageTest.produtoLocalizado(driver).getText());
		Screenshort.printTela(driver, Generator.dataHorParaArquvio());
		
	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
		IrParaHomePage.fechaSite(driver);
	}

}
