package br.com.rsi.hub_tdd.steps.test;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.rsi.hub_tdd.steps.Generator;
import br.com.rsi.hub_tdd.steps.Screenshort;
import br.com.rsi.hub_tdd.steps.home_page.GoToWeb;
import br.com.rsi.hub_tdd.steps.home_page.HomePage;
import br.com.rsi.hub_tdd.steps.utility.Constant;
import br.com.rsi.hub_tdd.steps.utility.ExcelUtils;
import br.com.rsi.hub_tdd.steps.utility.ProductSearch;

public class TestBuscaProdutoPositiva {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		driver = GoToWeb.abreSite();
		GoToWeb.aguardeElemento();

	}
	
	@Test
	public void testBuscaProduto() throws Exception {

		ExcelUtils.setExcelFile(Constant.Path_Cadastro + Constant.File_Cadastro, "Planilha2");
		
		HomePage.findProduct(driver).click();
		
		ProductSearch.productName(driver).sendKeys(ExcelUtils.getCellData(1, 0) + Keys.ENTER);
		ProductSearch.productFound(driver).click();
		Screenshort.printTela(driver, Generator.dataHorParaArquvio());
		
	}

	@After
	
	public void Close() {
		GoToWeb.fechaSite(driver);
//		
	}
	
	

}
