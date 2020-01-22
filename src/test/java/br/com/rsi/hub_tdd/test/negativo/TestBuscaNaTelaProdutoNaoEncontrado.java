package br.com.rsi.hub_tdd.test.negativo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.testng.Assert.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import br.com.rsi.hub_tdd.PageObject.BuscaProduto;
import br.com.rsi.hub_tdd.PageObject.HomePage;
import br.com.rsi.hub_tdd.PageObject.IrParaHomePage;
import br.com.rsi.hub_tdd.excel.MenssageTest;
import br.com.rsi.hub_tdd.screenshort.Generator;
import br.com.rsi.hub_tdd.screenshort.Screenshort;

public class TestBuscaNaTelaProdutoNaoEncontrado {
	private static WebDriver driver;

	@BeforeMethod

	public static void setUp() {

		driver = IrParaHomePage.abreSite();
		IrParaHomePage.aguardeElemento();
	}

	@Test
	public void testBuscaNaTelaProdutoNaoEncontrado() {
		HomePage.outroProdutoDaTelaPrincipal(driver).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
		assertFalse(driver.getPageSource().contains("HP ELITEBOOK FOLIO"));
		Screenshort.printTela(driver, Generator.dataHorParaArquvio());
		

	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		IrParaHomePage.fechaSite(driver);

	}
}
