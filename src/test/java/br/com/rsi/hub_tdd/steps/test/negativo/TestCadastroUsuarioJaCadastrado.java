package br.com.rsi.hub_tdd.steps.test.negativo;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsi.hub_tdd.screenshort.Generator;
import br.com.rsi.hub_tdd.screenshort.Screenshort;
import br.com.rsi.hub_tdd.steps.PageObject.DadosParaCadastroNovoUsuario;
import br.com.rsi.hub_tdd.steps.excel.Constant;
import br.com.rsi.hub_tdd.steps.excel.ExcelUtils;
import br.com.rsi.hub_tdd.steps.excel.MenssageTest;
import br.com.rsi.hub_tdd.steps.home_page.IrParaHomePage;
import br.com.rsi.hub_tdd.steps.home_page.HomePage;

public class TestCadastroUsuarioJaCadastrado {
	private static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		driver = IrParaHomePage.abreSite();

	}

	@Test
	public void TestNewAccont() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_Cadastro + Constant.File_Cadastro, "Planilha1");

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

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,200)");
		
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
		

		assertEquals("User name already exists", MenssageTest.registeredUsere(driver).getText());
		Screenshort.printTela(driver, Generator.dataHorParaArquvio());
	}

	@After
	public void tearDown() throws InterruptedException {
		IrParaHomePage.fechaSite(driver);
	}

}
