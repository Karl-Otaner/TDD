package br.com.rsi.hub_tdd.test.positivo;

import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import br.com.rsi.hub_tdd.PageObject.HomePage;
import br.com.rsi.hub_tdd.PageObject.IrParaHomePage;
import br.com.rsi.hub_tdd.excel.Constant;
import br.com.rsi.hub_tdd.excel.ExcelUtils;
import br.com.rsi.hub_tdd.screenshort.Generator;
import br.com.rsi.hub_tdd.screenshort.Screenshort;


public class TestBuscaProdutoPelaLupaComSucesso {
	private static WebDriver driver;
	
	@BeforeMethod
	public static void setUp() {
		driver = IrParaHomePage.abreSite();
		IrParaHomePage.aguardeElemento();

	}
	
	@Test
	public void testBuscaProdutoPelaLupaComSucesso() throws Exception {

		ExcelUtils.setExcelFile(Constant.Path_Cadastro + Constant.File_Cadastro, "Planilha2");
		
		HomePage.findProduct(driver).click();
		
		HomePage.productName(driver).sendKeys(ExcelUtils.getCellData(1, 0) + Keys.ENTER);

		HomePage.productFound(driver).click();

		Screenshort.printTela(driver, Generator.dataHorParaArquvio());
		
	}

	@AfterMethod
	
	public void Close() {
		IrParaHomePage.fechaSite(driver);	
	}
	
	

}
