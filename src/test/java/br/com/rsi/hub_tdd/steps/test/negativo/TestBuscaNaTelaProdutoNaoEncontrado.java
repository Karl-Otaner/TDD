package br.com.rsi.hub_tdd.steps.test.negativo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.testng.Assert.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import br.com.rsi.hub_tdd.screenshort.Generator;
import br.com.rsi.hub_tdd.screenshort.Screenshort;
import br.com.rsi.hub_tdd.steps.PageObject.BuscaProduto;
import br.com.rsi.hub_tdd.steps.excel.MenssageTest;
import br.com.rsi.hub_tdd.steps.home_page.HomePage;
import br.com.rsi.hub_tdd.steps.home_page.IrParaHomePage;

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
