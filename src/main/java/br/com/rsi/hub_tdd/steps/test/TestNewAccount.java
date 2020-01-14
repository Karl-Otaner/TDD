package br.com.rsi.hub_tdd.steps.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.rsi.hub_tdd.steps.home_page.CreateNewAccount;
import br.com.rsi.hub_tdd.steps.home_page.HomePage;

public class TestNewAccount {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = HomePage.acessChrome();
	}

	@Test
	public void TestNewAccount() {
		new CreateNewAccount(driver)
		.
	}
	
	
	@After
	public void tearDown() {
		
	}
}
