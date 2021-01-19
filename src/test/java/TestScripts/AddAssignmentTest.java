package TestScripts;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ObjectRepository.AddAssignmentPage;
import ObjectRepository.ClassroomPage;
import ObjectRepository.LoginPage;
import ObjectRepository.LogoutPage;
import TestData.ExcelDataImport;
import TestData.TestDataImport;

public class AddAssignmentTest extends BaseClass {
	ClassroomPage classroomObj;
	AddAssignmentPage assignmentObj;
	LoginPage loginObj;
	static TestDataImport TestDataObj;
	static ExcelDataImport excelDataObj;
	static String[] testData;
	LogoutPage logoutObj;
	String actualstring;
	String expectedstring;

	@BeforeMethod
	public void setup() throws MalformedURLException {

		loginObj = new LoginPage(androidDriver);
		classroomObj = new ClassroomPage(androidDriver);
		assignmentObj = new AddAssignmentPage(androidDriver);
		logoutObj = new LogoutPage(androidDriver);
		TestDataObj = new TestDataImport();
		excelDataObj = new ExcelDataImport();
		excelDataObj.readExcel("AssignmentPage");
		

	}

	@Test
	public void addAssignmentTest() {
		try {
			testData = TestDataObj.getAddAssignmentData();
			loginObj.validLogin();
			classroomObj.assignmentNavigationMethod("Central Integration Planner");
			assignmentObj.addAssignment(testData[0], testData[1], testData[2], testData[3]);
			sleep(1000);
			actualstring = customXpathMethod(testData[0]).getText();
			expectedstring = testData[0];

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		assertEquals(actualstring, expectedstring);

	}

	@AfterClass
	public void endTest() {
		sleep(1000);
		classroomObj.backBtn.click();
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
