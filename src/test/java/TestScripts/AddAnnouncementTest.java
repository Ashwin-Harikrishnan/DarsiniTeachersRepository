package TestScripts;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ObjectRepository.AddAnnouncementPage;
import ObjectRepository.ClassroomPage;
import ObjectRepository.LoginPage;
import ObjectRepository.LogoutPage;
import TestData.ExcelDataImport;
import TestData.TestDataImport;

public class AddAnnouncementTest extends BaseClass {
	ClassroomPage classroomObj;
	AddAnnouncementPage announcementObj;
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
		announcementObj = new AddAnnouncementPage(androidDriver);
		logoutObj = new LogoutPage(androidDriver);

		TestDataObj = new TestDataImport();
		excelDataObj = new ExcelDataImport();
		excelDataObj.readExcel("AnnouncementPage");

	}

	//@Test
	public void addAnnouncementTest() {
		try {
			testData = TestDataObj.getAddAnnouncementData();
			loginObj.validLogin();
			classroomObj.assignmentNavigationMethod("Central Integration Planner");
			announcementObj.addAnnouncement(testData[0],testData[1],testData[2],Boolean.parseBoolean(testData[3]),Boolean.parseBoolean(testData[4]));
			sleep(1000);
			actualstring = customXpathMethod(testData[0]).getText();
			expectedstring = testData[0];

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		assertEquals(actualstring, expectedstring);

	}
	//@Test
	public void editAnnoucementTest() {
		try {
		testData = TestDataObj.getEditAnnouncementData();
		loginObj.validLogin();
		classroomObj.assignmentNavigationMethod("Central Integration Planner");
		classroomObj.editAnnouncementNavigation();
		announcementObj.editAnnouncement(testData[0], testData[1], testData[2], Boolean.parseBoolean(testData[3]),Boolean.parseBoolean(testData[4]));
		System.out.println("Verification: ");
		sleep(1000);
		actualstring = customXpathMethod(testData[0]).getText();
		expectedstring = testData[0];

	} catch (Exception e) {
		System.out.println(e);
	}
	System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
	assertEquals(actualstring, expectedstring);

	}
	
	@Test
	public void disableAnnouncementCommentsTest() {
		try {
		
		loginObj.validLogin();
		classroomObj.assignmentNavigationMethod("Central Integration Planner");
		classroomObj.disableAnnouncementComments();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	//@Test
	public void enableAnnouncementCommentsTest() {
		try {
		
		loginObj.validLogin();
		classroomObj.assignmentNavigationMethod("Central Integration Planner");
		classroomObj.enableAnnouncementComments();
		}
		catch(Exception e) {
			System.out.println(e);
		}
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
