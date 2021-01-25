package TestScripts;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ObjectRepository.AddAssignmentPage;
import ObjectRepository.ClassroomPage;
import ObjectRepository.HomePage;
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
	HomePage homeObj;

	@BeforeMethod
	public void setup() throws MalformedURLException {

		loginObj = new LoginPage(androidDriver);
		classroomObj = new ClassroomPage(androidDriver);
		assignmentObj = new AddAssignmentPage(androidDriver);
		logoutObj = new LogoutPage(androidDriver);
		TestDataObj = new TestDataImport();
		excelDataObj = new ExcelDataImport();
		excelDataObj.readExcel("AssignmentPage");
		homeObj = new HomePage(androidDriver);
		

	}

	//@Test(priority = 0)
	public void addAssignmentTest() {
		try {
			testData = TestDataObj.getAddAssignmentData();
			loginObj.validLogin();
			classroomObj.assignmentNavigationMethod("Central Integration Planner");
			assignmentObj.addAssignment(testData[0], testData[1], testData[2], testData[3],Boolean.parseBoolean(testData[4]),Boolean.parseBoolean(testData[5]));
			sleep(1000);
			actualstring = customXpathMethod(testData[0]).getText();
			expectedstring = testData[0];
			classroomObj.backBtn.click();

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		assertEquals(actualstring, expectedstring);

	}
	
	//@Test(priority = 1)
	public void editAssignmentTest() {
		try {
		testData = TestDataObj.getEditAssignmentData();
		//loginObj.validLogin();
		//classroomObj.assignmentNavigationMethod("Central Integration Planner");
		customXpathMethod("Central Integration Planner").click();
		classroomObj.editAssignmentNavigation();
		assignmentObj.editAssignment(testData[0], testData[1], testData[2], testData[3],Boolean.parseBoolean(testData[4]),Boolean.parseBoolean(testData[5]));
		sleep(1000);
		actualstring = customXpathMethod(testData[0]).getText();
		expectedstring = testData[0];
		classroomObj.backBtn.click();

	} catch (Exception e) {
		System.out.println(e);
	}
	System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
	assertEquals(actualstring, expectedstring);

	}
	
	//@Test(priority = 2)
	public void disableAssignmentCommentsTest() {
		try {
		
		//loginObj.validLogin();
		//classroomObj.assignmentNavigationMethod("Central Integration Planner");
		customXpathMethod("Central Integration Planner").click();
		classroomObj.disableAssignmentComments();
		
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	//@Test(priority = 3)
	public void enableAssignmentCommentsTest() {
		try {
		
		//loginObj.validLogin();
		//classroomObj.assignmentNavigationMethod("Central Integration Planner");
		//customXpathMethod("Central Integration Planner").click();
		classroomObj.enableAssignmentComments();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	@Test
	public void deleteAssignmentTest() {
		try {
		//loginObj.validLogin();
		//classroomObj.assignmentNavigationMethod("Central Integration Planner");
		//customXpathMethod("Central Integration Planner").click();
		classroomObj.deleteAssignment();
		classroomObj.backBtn.click();
		homeObj.homeBtn.click();
		sleep(500);
		homeObj.searchBar.click();
		homeObj.searchBar.sendKeys(testData[0]);
		homeObj.searchBtn.click();
		actualstring = homeObj.noResultsMessage.getText();
		expectedstring = "No results found";
		
		}
	 catch (Exception e) {
		System.out.println(e);
	}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		Assert.assertEquals(expectedstring, actualstring);
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
