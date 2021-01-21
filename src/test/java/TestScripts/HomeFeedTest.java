package TestScripts;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ObjectRepository.AddAssignmentPage;
import ObjectRepository.ClassroomPage;
import ObjectRepository.LoginPage;
import ObjectRepository.LogoutPage;
import TestData.ExcelDataImport;
import TestData.TestDataImport;

public class HomeFeedTest extends BaseClass{
	ClassroomPage classroomObj;
	AddAssignmentPage assignmentObj;
	LoginPage loginObj;
	static TestDataImport TestDataObj;
	static ExcelDataImport excelDataObj;
	static String[] testData;
	LogoutPage logoutObj;
	String actualstring;
	String expectedstring;
	String verification = "";
	ArrayList<String> actualArray = new ArrayList<String>();
	ArrayList<String> expectedArray = new ArrayList<String>();

	@BeforeMethod
	public void setup() throws MalformedURLException {

		loginObj = new LoginPage(androidDriver);
		classroomObj = new ClassroomPage(androidDriver);
		assignmentObj = new AddAssignmentPage(androidDriver);
		logoutObj = new LogoutPage(androidDriver);
		TestDataObj = new TestDataImport();
		excelDataObj = new ExcelDataImport();
		
		

	}
	
	//@Test
public void HomeFeedAnnouncementTest() {
		try {
			excelDataObj.readExcel("AnnouncementPage");
		testData = TestDataObj.getHomeFeedAnnouncementData();
		loginObj.validLogin();
		
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
	@Test
	public void HomeFeedAssignmentTest() {
			try {
			excelDataObj.readExcel("AssignmentPage");
			testData = TestDataObj.getHomeFeedAssignmentData();
			loginObj.validLogin();
			
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
			System.out.println("ACTUAL: "+actualArray);
			
			//EXPECTED
			expectedArray.add(testData[0]);
			expectedArray.add(testData[1]);
			expectedArray.add(testData[2]);
			expectedArray.add(testData[3]);
			expectedArray.add(testData[4]);
			System.out.println("EXPECTED: "+expectedArray);

			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println("Actual: " + actualArray + "\nExpcted: " + expectedArray);
			assertEquals(actualArray, expectedArray);

			
			
		}

}
