package br.com.rsi.hub_tdd.steps.test.positivo;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsi.hub_tdd.screenshort.Generator;
import br.com.rsi.hub_tdd.screenshort.Screenshort;
import br.com.rsi.hub_tdd.steps.PageObject.DadosParaCadastroNovoUsuario;
import br.com.rsi.hub_tdd.steps.excel.Constant;
import br.com.rsi.hub_tdd.steps.excel.ExcelUtils;
import br.com.rsi.hub_tdd.steps.home_page.GeradorDeRelatorios;
import br.com.rsi.hub_tdd.steps.home_page.HomePage;
import br.com.rsi.hub_tdd.steps.home_page.IrParaHomePage;

public class TestCadastroUsuarioSucesso {
	private static WebDriver driver;
	static ExtentReports extent;
	static ExtentTest logger;
	static ExtentHtmlReporter reporter;

	@BeforeClass
	public static void setUp() {
		
		driver = IrParaHomePage.abreSite();
	}

	@Test
	public void TestCadastroNovaConta() throws Exception {
		
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

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(HomePage.imagemHome(driver)));

		assertEquals("http://www.advantageonlineshopping.com/#/", driver.getCurrentUrl());
		
		Screenshort.printTela(driver, Generator.dataHorParaArquvio());
		GeradorDeRelatorios.relatorioCadastroComSucesso();

	}

	@AfterClass
	public void tearDown() {
//		driver.close()

		IrParaHomePage.fechaSite(driver);
	}

}
