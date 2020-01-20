package br.com.rsi.hub_tdd.steps.test.positivo;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsi.hub_tdd.screenshort.Generator;
import br.com.rsi.hub_tdd.screenshort.Screenshort;
import br.com.rsi.hub_tdd.steps.excel.Constant;
import br.com.rsi.hub_tdd.steps.excel.ExcelUtils;
import br.com.rsi.hub_tdd.steps.home_page.HomePage;
import br.com.rsi.hub_tdd.steps.home_page.IrParaHomePage;


public class TestBuscaProdutoComSucesso {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		driver = IrParaHomePage.abreSite();
		IrParaHomePage.aguardeElemento();

	}
	
	@Test
	public void testBuscaProdutoPelaLupa() throws Exception {

		ExcelUtils.setExcelFile(Constant.Path_Cadastro + Constant.File_Cadastro, "Planilha2");
		
		HomePage.findProduct(driver).click();
		
		HomePage.productName(driver).sendKeys(ExcelUtils.getCellData(1, 0) + Keys.ENTER);

		HomePage.productFound(driver).click();

		Screenshort.printTela(driver, Generator.dataHorParaArquvio());
		
	}

	@After
	
	public void Close() {
		IrParaHomePage.fechaSite(driver);	
	}
	
	

}
