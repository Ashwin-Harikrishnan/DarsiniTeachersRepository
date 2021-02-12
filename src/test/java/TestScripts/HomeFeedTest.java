package TestScripts;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ObjectRepository.AssignmentPage;
import ObjectRepository.ClassroomPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProfilePage;
import TestData.ExcelDataImport;
import TestData.TestDataImport;

public class HomeFeedTest extends BaseClass{
	ClassroomPage classroomObj;
	AssignmentPage assignmentObj;
	LoginPage loginObj;
	HomePage homeObj;
	static TestDataImport TestDataObj;
	static ExcelDataImport excelDataObj;
	static String[] testData;
	ProfilePage logoutObj;
	String actualstring;
	String expectedstring;
	String verification = "";
	ArrayList<String> actualAnnouncementArray = new ArrayList<String>();
	ArrayList<String> expectedAnnouncementArray = new ArrayList<String>();
	ArrayList<String> actualAssignmentArray = new ArrayList<String>();
	ArrayList<String> expectedAssignmentArray = new ArrayList<String>();

	@BeforeMethod
	public void setup() throws MalformedURLException {

		loginObj = new LoginPage(androidDriver);
		classroomObj = new ClassroomPage(androidDriver);
		assignmentObj = new AssignmentPage(androidDriver);
		logoutObj = new ProfilePage(androidDriver);
		TestDataObj = new TestDataImport();
		excelDataObj = new ExcelDataImport();
		homeObj = new HomePage(androidDriver);
		excelDataObj.readExcel("HomeFeed");
		
		

	}
	
	@Test(priority = 1)
public void HomeFeedAnnouncementTest() {
		try {
			
		testData = TestDataObj.getHomeFeedAnnouncementData();
		eTest = eReports.createTest("Announcement homefeed test");
		eTest.assignCategory("Homefeed");
		log.info("Entered Announcement homefeed test");
		loginObj.validLogin();
		homeObj.searchBar.sendKeys(testData[0]);
		homeObj.searchBtn.click();
		
		log.info("Entered verification method");
		//ACTUAL
		verification = customXpathMethod(testData[0]).getText();
		actualAnnouncementArray.add(verification);
		verification = customXpathMethod(testData[1]).getText();
		actualAnnouncementArray.add(verification);
		verification = customXpathMethod(testData[2]).getText();
		actualAnnouncementArray.add(verification);
		verification = customXpathMethod(testData[3]).getText();
		actualAnnouncementArray.add(verification);
		verification = customXpathMethod(testData[4]).getText();
		actualAnnouncementArray.add(verification);

		
		//EXPECTED
		expectedAnnouncementArray.add(testData[0]);
		expectedAnnouncementArray.add(testData[1]);
		expectedAnnouncementArray.add(testData[2]);
		expectedAnnouncementArray.add(testData[3]);
		expectedAnnouncementArray.add(testData[4]);
		

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualAnnouncementArray + "\nExpcted: " + expectedAnnouncementArray);
		assertEquals(actualAnnouncementArray, expectedAnnouncementArray);
		log.info("Verification complete");
	
	}

	@Test(priority = 0)
	public void HomeFeedAssignmentTest() {
			try {
			
			testData = TestDataObj.getHomeFeedAssignmentData();
			eTest = eReports.createTest("Assignment homefeed test");
			eTest.assignCategory("Homefeed");
			log.info("Entered Assignment homefeed test");
			loginObj.validLogin();
			sleep(2000);
			homeObj.searchBar.sendKeys(testData[0]);
			homeObj.searchBtn.click();
			
			log.info("Entered verification method");
			//ACTUAL
			verification = customXpathMethod(testData[0]).getText();
			actualAssignmentArray.add(verification);
			verification = customXpathMethod(testData[1]).getText();
			actualAssignmentArray.add(verification);
			verification = customXpathMethod(testData[2]).getText();
			actualAssignmentArray.add(verification);
			verification = customXpathMethod(testData[3]).getText();
			actualAssignmentArray.add(verification);
			verification = customXpathMethod(testData[4]).getText();
			actualAssignmentArray.add(verification);
			System.out.println("ACTUAL: "+actualAssignmentArray);
			
			//EXPECTED
			expectedAssignmentArray.add(testData[0]);
			expectedAssignmentArray.add(testData[1]);
			expectedAssignmentArray.add(testData[2]);
			expectedAssignmentArray.add(testData[3]);
			expectedAssignmentArray.add(testData[4]);
			System.out.println("EXPECTED: "+expectedAssignmentArray);

			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println("Actual: " + actualAssignmentArray + "\nExpcted: " + expectedAssignmentArray);
			assertEquals(actualAssignmentArray, expectedAssignmentArray);
			log.info("Verification complete");
		}
	
	//@AfterClass
	public void endTest() {
		sleep(1000);
		logoutObj.logout();
		
	}

}
