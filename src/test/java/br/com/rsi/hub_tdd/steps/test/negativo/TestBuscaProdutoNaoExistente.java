package br.com.rsi.hub_tdd.steps.test.negativo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsi.hub_tdd.screenshort.Generator;
import br.com.rsi.hub_tdd.screenshort.Screenshort;
import br.com.rsi.hub_tdd.steps.excel.Constant;
import br.com.rsi.hub_tdd.steps.excel.ExcelUtils;
import br.com.rsi.hub_tdd.steps.home_page.HomePage;
import br.com.rsi.hub_tdd.steps.home_page.IrParaHomePage;

public class TestBuscaProdutoNaoExistente {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		
		driver = IrParaHomePage.abreSite();

		
	}
	
	@Test
	public void testBuscaProduto() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_Cadastro + Constant.File_Cadastro, "Planilha2");
		
		HomePage.findProduct(driver).click();
		
		HomePage.productName(driver).sendKeys(ExcelUtils.getCellData(2, 0) + Keys.ENTER);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		assertTrue(driver.getPageSource().contains("No results for"));

		Screenshort.printTela(driver, Generator.dataHorParaArquvio());
		
	}
@After
	
	public void Close() {
		IrParaHomePage.fechaSite(driver);
	}

}
