package TestScripts;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ObjectRepository.LoginPage;

public class LoginTest extends BaseClass {
	LoginPage loginObj;

	@BeforeMethod
	public void setup() throws MalformedURLException {
		loginObj = new LoginPage(androidDriver);
		
	}
	
	@Test
	public void loginTest() {
		loginObj.validLogin();
	}
}
