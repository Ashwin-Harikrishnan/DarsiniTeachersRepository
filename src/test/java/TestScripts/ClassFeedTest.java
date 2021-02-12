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
import ObjectRepository.LoginPage;
import ObjectRepository.ProfilePage;
import TestData.ExcelDataImport;
import TestData.TestDataImport;

public class ClassFeedTest extends BaseClass{
	ClassroomPage classroomObj;
	AssignmentPage assignmentObj;
	LoginPage loginObj;
	static TestDataImport TestDataObj;
	static ExcelDataImport excelDataObj;
	static String[] testData;
	ProfilePage logoutObj;
	String actualstring;
	String expectedstring;
	String verification = "";
	ArrayList<String> actualAssignmentArray = new ArrayList<String>();
	ArrayList<String> expectedAssignmentArray = new ArrayList<String>();
	ArrayList<String> actualAnnouncementArray = new ArrayList<String>();
	ArrayList<String> expectedAnnouncementArray = new ArrayList<String>();
	
	@BeforeMethod
	public void setup() throws MalformedURLException {

		loginObj = new LoginPage(androidDriver);
		classroomObj = new ClassroomPage(androidDriver);
		assignmentObj = new AssignmentPage(androidDriver);
		logoutObj = new ProfilePage(androidDriver);
		TestDataObj = new TestDataImport();
		excelDataObj = new ExcelDataImport();
		excelDataObj.readExcel("ClassFeed");
	}
	
	@Test(priority = 0)
	public void classFeedAssignmentTest() {
		try {
			eTest = eReports.createTest("ClassFeed assignment test");
			eTest.assignCategory("ClassFeed");
			log.info("Entered classfeed assignment test");
		testData = TestDataObj.getClassFeedAssignmentData();
		//loginObj.validLogin();
		log.info("Login complete");
		classroomObj.assignmentNavigationMethod("Internal Applications Consultant");
		classroomObj.assignmentTab.click();
		
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
		verification = customXpathMethod(testData[5]).getText();
		actualAssignmentArray.add(verification);
		verification = customXpathMethod(testData[6]).getText();
		actualAssignmentArray.add(verification);

		
		//EXPECTED
		expectedAssignmentArray.add(testData[0]);
		expectedAssignmentArray.add(testData[1]);
		expectedAssignmentArray.add(testData[2]);
		expectedAssignmentArray.add(testData[3]);
		expectedAssignmentArray.add(testData[4]);
		expectedAssignmentArray.add(testData[5]);
		expectedAssignmentArray.add(testData[6]);
		

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualAssignmentArray + "\nExpcted: " + expectedAssignmentArray);
		assertEquals(actualAssignmentArray, expectedAssignmentArray);
		log.info("Verification complete");
	}
	
	@Test(priority = 1)
	public void classFeedAnnouncementTest() {
		try {
			eTest = eReports.createTest("ClassFeed announcement test");
			eTest.assignCategory("ClassFeed");
			log.info("Entered classfeed announcement test");
		testData = TestDataObj.getClassFeedAnnouncementData();
		//loginObj.validLogin();
	//	classroomObj.assignmentNavigationMethod("Internal Applications Consultant");
		classroomObj.announcementTab.click();
		
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
		classroomObj.backBtn.click();
	

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualAnnouncementArray + "\nExpcted: " + expectedAssignmentArray);
		assertEquals(actualAnnouncementArray, expectedAssignmentArray);
		log.info("Verification complete");
	
	}
	//@AfterClass
	public void endTest() {
		sleep(1000);
		logoutObj.logout();
		
	}

}
