package br.com.rsi.hub_tdd.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsi.hub_tdd.steps.home_page.HomePage;
import br.com.rsi.hub_tdd.steps.login_page.NewUserPage;

public class PageObjectModel {
	private static WebDriver driver;

	public void testCadastraUsuario() {

//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.get("http://advantageonlineshopping.com/#/");
		
		HomePage.lnk_MyAccount(driver).click();
//		NewUser.txtbx_UserName(driver).sendKeys("Karl_Otaner2");
//		NewUser.txtbx_Password(driver).sendKeys("Aa123456");
		NewUserPage.btn_NewUser(driver).click();
		
		System.out.println("Login efetuado com sucesso, Agora vamos as compras!");
		
	}
	
}
