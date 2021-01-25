package TestScripts;

import static org.testng.Assert.assertEquals;


import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ObjectRepository.AddAnnouncementPage;
import ObjectRepository.ClassroomPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.LogoutPage;
import TestData.ExcelDataImport;
import TestData.TestDataImport;


public class AddAnnouncementTest extends BaseClass {
	ClassroomPage classroomObj;
	AddAnnouncementPage announcementObj;
	LoginPage loginObj;
	HomePage homeObj;
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
		announcementObj = new AddAnnouncementPage(androidDriver);
		logoutObj = new LogoutPage(androidDriver);
		homeObj = new HomePage(androidDriver);
		TestDataObj = new TestDataImport();
		excelDataObj = new ExcelDataImport();
		excelDataObj.readExcel("AnnouncementPage");

	}

	@Test(priority = 0)
	public void addAnnouncementTest() {
		try {
			testData = TestDataObj.getAddAnnouncementData();
			loginObj.validLogin();
			classroomObj.assignmentNavigationMethod("Central Integration Planner");
			announcementObj.addAnnouncement(testData[0], testData[1], testData[2], Boolean.parseBoolean(testData[3]),
					Boolean.parseBoolean(testData[4]));
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

	@Test(priority = 1)
	public void editAnnoucementTest() {
		try {
			testData = TestDataObj.getEditAnnouncementData();
			// loginObj.validLogin();
			// classroomObj.assignmentNavigationMethod("Central Integration Planner");
			customXpathMethod("Central Integration Planner").click();
			classroomObj.editAnnouncementNavigation();
			announcementObj.editAnnouncement(testData[0], testData[1], testData[2], Boolean.parseBoolean(testData[3]),
					Boolean.parseBoolean(testData[4]));
			System.out.println("Verification: ");
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

	@Test(priority = 2)
	public void disableAnnouncementCommentsTest() {
		try {

			// loginObj.validLogin();
			// classroomObj.assignmentNavigationMethod("Central Integration Planner");
			customXpathMethod("Central Integration Planner").click();
			classroomObj.disableAnnouncementComments();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test(priority = 3)
	public void enableAnnouncementCommentsTest() {
		try {

			// loginObj.validLogin();
			// classroomObj.assignmentNavigationMethod("Central Integration Planner");
			customXpathMethod("Central Integration Planner").click();
			classroomObj.enableAnnouncementComments();
			classroomObj.backBtn.click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	
	@Test(priority = 4)
	public void deleteAnnouncementTest() {
		try {
		testData = TestDataObj.getEditAnnouncementData();
		//loginObj.validLogin();
		//classroomObj.assignmentNavigationMethod("Central Integration Planner");
		customXpathMethod("Central Integration Planner").click();
		classroomObj.deleteAnnouncement();
		sleep(500);
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
	//@AfterClass
	public void endTest() {
		sleep(1000);
		//classroomObj.backBtn.click();
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
