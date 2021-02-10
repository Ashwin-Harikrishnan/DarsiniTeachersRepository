package TestScripts;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.ArrayList;

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
	ArrayList<String> actualArray = new ArrayList<String>();
	ArrayList<String> expectedArray = new ArrayList<String>();

	@BeforeMethod
	public void setup() throws MalformedURLException {

		loginObj = new LoginPage(androidDriver);
		classroomObj = new ClassroomPage(androidDriver);
		assignmentObj = new AssignmentPage(androidDriver);
		logoutObj = new ProfilePage(androidDriver);
		TestDataObj = new TestDataImport();
		excelDataObj = new ExcelDataImport();
		
		

	}
	
	//@Test
	public void classFeedAssignmentTest() {
		try {
		excelDataObj.readExcel("AssignmentPage");
		testData = TestDataObj.getClassFeedAssignmentData();
		loginObj.validLogin();
		classroomObj.assignmentNavigationMethod("Internal Applications Consultant");
		classroomObj.assignmentTab.click();
		//ACTUAL
		verification = customXpathMethod(testData[0]).getText();
		actualArray.add(verification);
		verification = customXpathMethod(testData[1]).getText();
		actualArray.add(verification);
		verification = customXpathMethod(testData[2]).getText();
		actualArray.add(verification);
		verification = customXpathMethod(testData[3]).getText();
		actualArray.add(verification);
		verification = customXpathMethod(testData[4]).getText();
		actualArray.add(verification);
		verification = customXpathMethod(testData[5]).getText();
		actualArray.add(verification);
		verification = customXpathMethod(testData[6]).getText();
		actualArray.add(verification);

		
		//EXPECTED
		expectedArray.add(testData[0]);
		expectedArray.add(testData[1]);
		expectedArray.add(testData[2]);
		expectedArray.add(testData[3]);
		expectedArray.add(testData[4]);
		expectedArray.add(testData[5]);
		expectedArray.add(testData[6]);
		

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualArray + "\nExpcted: " + expectedArray);
		assertEquals(actualArray, expectedArray);
	
	}
	
	@Test
	public void classFeedAnnouncementTest() {
		try {
		excelDataObj.readExcel("AnnouncementPage");
		testData = TestDataObj.getClassFeedAssignmentData();
		loginObj.validLogin();
		classroomObj.assignmentNavigationMethod("Internal Applications Consultant");
		classroomObj.announcementTab.click();
		//ACTUAL
		verification = customXpathMethod(testData[0]).getText();
		actualArray.add(verification);
		verification = customXpathMethod(testData[1]).getText();
		actualArray.add(verification);
		verification = customXpathMethod(testData[2]).getText();
		actualArray.add(verification);
		verification = customXpathMethod(testData[3]).getText();
		actualArray.add(verification);
		verification = customXpathMethod(testData[4]).getText();
		actualArray.add(verification);
		

		
		//EXPECTED
		expectedArray.add(testData[0]);
		expectedArray.add(testData[1]);
		expectedArray.add(testData[2]);
		expectedArray.add(testData[3]);
		expectedArray.add(testData[4]);
	

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualArray + "\nExpcted: " + expectedArray);
		assertEquals(actualArray, expectedArray);
	
	}
	

}
