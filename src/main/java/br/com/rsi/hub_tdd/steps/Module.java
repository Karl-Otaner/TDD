package br.com.rsi.hub_tdd.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsi.hub_tdd.steps.appModulos.SignIn_Action;

public class Module {
	private static WebDriver driver;
	
	@Test
	public void testNewUser() throws Exception {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://advantageonlineshopping.com/#/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		SignIn_Action.Execute(driver);
		
//		HomePage.lnk_MyAccount(driver).click();
		
		System.out.println("Login efetuado com sucesso, Agora vamos as compras!");
//		driver.quit();
	}
	

}
