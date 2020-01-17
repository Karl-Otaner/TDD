package br.com.rsi.hub_tdd.steps.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsi.hub_tdd.steps.home_page.HomePage;
import br.com.rsi.hub_tdd.steps.utility.Constant;
import br.com.rsi.hub_tdd.steps.utility.ExcelUtils;
import br.com.rsi.hub_tdd.steps.utility.ProductSearch;
import br.com.rsi.hub_tdd.steps.utility.Search;

public class TestBuscaProdutoNegativa {
	private static ChromeDriver driver;
	
	@BeforeClass
	public static void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://advantageonlineshopping.com/");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"follow\"]/a[3]/img")));

		
	}
	
	@Test
	public void testBuscaProduto() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_Cadastro + Constant.File_Cadastro, "Planilha2");
		
		HomePage.findProduct(driver).click();
		
		ProductSearch.productName(driver).sendKeys(ExcelUtils.getCellData(3, 0) + Keys.ENTER);
		boolean produtofalso = driver.getPageSource().contains("bolo");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.urlToBe("http://advantageonlineshopping.com/#/search/?viewAll=keyboard"));
//	       
//        assertEquals("http://advantageonlineshopping.com/#/search/?viewAll=keyboard", driver.getCurrentUrl());
		
		assertFalse(produtofalso);
		System.out.println(produtofalso);
//		Screenshort.printTela(driver, Generator.dataHorParaArquvio());
		
	}

}
