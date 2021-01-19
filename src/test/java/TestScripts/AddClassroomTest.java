package TestScripts;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ObjectRepository.AddClassroomPage;
import ObjectRepository.ClassroomPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.LogoutPage;
import TestData.ExcelDataImport;
import TestData.TestDataImport;

public class AddClassroomTest extends BaseClass {
	AddClassroomPage addClassObj;
	static TestDataImport TestDataObj;
	static ExcelDataImport excelDataObj;
	static String[] testData;
	LogoutPage logoutObj;
	LoginPage loginObj;
	HomePage homeObj;
	ClassroomPage classroomObj;
	String actualstring;
	String expectedstring;

	@BeforeMethod
	public void setup() throws MalformedURLException {

		loginObj = new LoginPage(androidDriver);
		classroomObj = new ClassroomPage(androidDriver);
		addClassObj = new AddClassroomPage(androidDriver);
		logoutObj = new LogoutPage(androidDriver);
		TestDataObj = new TestDataImport();
		excelDataObj = new ExcelDataImport();
		excelDataObj.readExcel("Sheet1");
		TestDataObj.setFakerData();

	}

	@Test
	public void addClassroomTest() {
		
		try {
		testData = TestDataObj.getAddClassroomData();

		loginObj.validLogin();
		addClassObj.addClassRoom(testData[0], testData[1], testData[2], testData[3], testData[4], testData[5]);
		testData = TestDataObj.getAddClassroomData();
		clickWait(homeObj.classBtn);
		System.out.println(testData[0]);
		scrollUpMob(8);
		sleep(2000);
		customXpathMethod(testData[0]).click();// finding the correct entry
		sleep(1000);
		actualstring = classroomObj.classroomVerificationText.getText();
		expectedstring = "Make an announcement or send out an assignment to your students";
		sleep(1000);
		//classroomObj.backBtn.click();
		}
		catch(Exception e) {
			
		
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		Assert.assertEquals(actualstring, expectedstring);
	}
	
	@AfterClass
	public void endTest() {
		sleep(1000);
		logoutObj.logout();
		
	}
	private static void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
