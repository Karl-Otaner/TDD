package br.com.rsi.hub_tdd.test.positivo;

import static org.junit.Assert.*;


import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import br.com.rsi.hub_tdd.PageObject.BuscaProduto;
import br.com.rsi.hub_tdd.PageObject.HomePage;
import br.com.rsi.hub_tdd.PageObject.IrParaHomePage;
import br.com.rsi.hub_tdd.excel.Constant;
import br.com.rsi.hub_tdd.excel.ExcelUtils;
import br.com.rsi.hub_tdd.excel.MenssageTest;
import br.com.rsi.hub_tdd.screenshort.Generator;
import br.com.rsi.hub_tdd.screenshort.Screenshort;

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
