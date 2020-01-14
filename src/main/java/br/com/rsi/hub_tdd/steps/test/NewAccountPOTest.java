package br.com.rsi.hub_tdd.steps.test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsi.hub_tdd.steps.home_page.CreateNewAccount;
import br.com.rsi.hub_tdd.steps.home_page.Web;
import br.com.rsi.hub_tdd.steps.login_page.HomePage;
import br.com.rsi.hub_tdd.steps.utility.Constant;
import br.com.rsi.hub_tdd.steps.utility.ExcelUtils;


public class NewAccountPOTest {
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
//		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://advantageonlineshopping.com/#/");
		ExcelUtils.setExcelFile(Constant.Path_Cadastro + Constant.File_Cadastro, "Planilha1");
	}
	
	
	@Test
	public void TestNewAccount() throws Exception {
		
		
		HomePage.clickUser(driver).click();
		HomePage.newAccount(driver).sendKeys(Keys.ENTER);
		
		
		CreateNewAccount.registerName(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		CreateNewAccount.registerEmail(driver).sendKeys(ExcelUtils.getCellData(1, 1));
//		CreateNewAccount.registerPsw(driver).sendKeys(ExcelUtils.getCellData(1, 2));
//		CreateNewAccount.ConfirmRegisterPsw(driver).sendKeys(ExcelUtils.getCellData(1, 3));
//		CreateNewAccount.firstRegisterName(driver).sendKeys(ExcelUtils.getCellData(1, 4));
//		CreateNewAccount.LastRegisterName(driver).sendKeys(ExcelUtils.getCellData(1, 5));
//		CreateNewAccount.phoneRegisterNum(driver).sendKeys(ExcelUtils.getCellData(1, 6));
//		CreateNewAccount.contryListbox(driver).selectByVisibleText(ExcelUtils.getCellData(1, 7));
//		CreateNewAccount.cityRegister(driver).sendKeys(ExcelUtils.getCellData(1, 8));
//		CreateNewAccount.addressRegister(driver).sendKeys(ExcelUtils.getCellData(1, 9));
//		CreateNewAccount.regionRegister(driver).sendKeys(ExcelUtils.getCellData(1, 10));
//		CreateNewAccount.postalRegister(driver).sendKeys(ExcelUtils.getCellData(1, 11));
//		CreateNewAccount.iAgree(driver).click();
//		CreateNewAccount.registerBtn(driver).click();
//		
	}
	

//	boolean displayed = driver.findElement(By.xpath("//span[@class='hi-user containMiniTitle ng-binding']")).isDisplayed();
//	System.out.println(displayed);					
//	Assert.assertTrue(displayed);
//	String screenshortArquivo = "C:\\Users\\carlos.silva\\ToolsQA\\TDD\\TDD\\Screenshort/"
//			+ Generator.dataHorParaArquvio() + test.getMethodName() +".png";
//	Screenshort.printTela(driver, screenshortArquivo);
	
	@After
	public void tearDown() {
		
	}
}