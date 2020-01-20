package br.com.rsi.hub_tdd.steps.test.positivo;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsi.hub_tdd.screenshort.Generator;
import br.com.rsi.hub_tdd.screenshort.Screenshort;
import br.com.rsi.hub_tdd.steps.PageObject.DadosParaCadastroNovoUsuario;
import br.com.rsi.hub_tdd.steps.excel.Constant;
import br.com.rsi.hub_tdd.steps.excel.ExcelUtils;
import br.com.rsi.hub_tdd.steps.home_page.IrParaHomePage;
import br.com.rsi.hub_tdd.steps.home_page.HomePage;

public class TestCadastroUsuarioSucesso {
	private static WebDriver driver;

	@BeforeClass
	public static void setUp() {

		driver = IrParaHomePage.abreSite();
	}

	@Test
	public void TestNewAccont() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_Cadastro + Constant.File_Cadastro, "Planilha1");

//		GoToWeb.IrSite(driver);

//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(HomePage.clickUser(driver)));
//		Thread.sleep(2000);
		HomePage.clickUser(driver).click();
		HomePage.createNewAccount(driver).sendKeys(Keys.ENTER);

		DadosParaCadastroNovoUsuario.registerName(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		DadosParaCadastroNovoUsuario.registerEmail(driver).sendKeys(ExcelUtils.getCellData(1, 1));
		DadosParaCadastroNovoUsuario.registerPsw(driver).sendKeys(ExcelUtils.getCellData(1, 2));
		DadosParaCadastroNovoUsuario.ConfirmRegisterPsw(driver).sendKeys(ExcelUtils.getCellData(1, 3));
		DadosParaCadastroNovoUsuario.firstRegisterName(driver).sendKeys(ExcelUtils.getCellData(1, 4));
		DadosParaCadastroNovoUsuario.LastRegisterName(driver).sendKeys(ExcelUtils.getCellData(1, 5));
		DadosParaCadastroNovoUsuario.phoneRegisterNum(driver).sendKeys(ExcelUtils.getCellData(1, 6));
		DadosParaCadastroNovoUsuario.contryListbox(driver).selectByVisibleText(ExcelUtils.getCellData(1, 7));
		DadosParaCadastroNovoUsuario.cityRegister(driver).sendKeys(ExcelUtils.getCellData(1, 8));
		DadosParaCadastroNovoUsuario.addressRegister(driver).sendKeys(ExcelUtils.getCellData(1, 9));
		DadosParaCadastroNovoUsuario.regionRegister(driver).sendKeys(ExcelUtils.getCellData(1, 10));
		DadosParaCadastroNovoUsuario.postalRegister(driver).sendKeys(ExcelUtils.getCellData(1, 11));
		DadosParaCadastroNovoUsuario.iAgree(driver).click();
		DadosParaCadastroNovoUsuario.registerBtn(driver).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(HomePage.imagemHome(driver)));

		assertEquals("http://www.advantageonlineshopping.com/#/", driver.getCurrentUrl());

		Screenshort.printTela(driver, Generator.dataHorParaArquvio());
	}

	@After
	public void tearDown() {
//		driver.close()
		IrParaHomePage.fechaSite(driver);
	}

}
