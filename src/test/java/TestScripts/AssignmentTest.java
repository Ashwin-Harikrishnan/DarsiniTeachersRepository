package TestScripts;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.testng.Assert;
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

public class AssignmentTest extends BaseClass {
	ClassroomPage classroomObj;
	AssignmentPage assignmentObj;
	LoginPage loginObj;
	static TestDataImport TestDataObj;
	static ExcelDataImport excelDataObj;
	static String[] testData;
	ProfilePage logoutObj;
	String actualstring;
	String expectedstring;
	HomePage homeObj;
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
		excelDataObj.readExcel("AssignmentPage");
		homeObj = new HomePage(androidDriver);
		

	}

	@Test(priority = 0)
	public void addAssignmentTest() {
		try {
			testData = TestDataObj.getAddAssignmentData();
			loginObj.validLogin();
			classroomObj.assignmentNavigationMethod("Internal Applications Consultant");
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
	
	@Test(priority = 1)
	public void editAssignmentTest() {
		try {
		testData = TestDataObj.getEditAssignmentData();
		//loginObj.validLogin();
		//classroomObj.assignmentNavigationMethod("Central Integration Planner");
		customXpathMethod("Internal Applications Consultant").click();
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
	
	@Test(priority = 2)
	public void disableAssignmentCommentsTest() {
		try {
		
		//loginObj.validLogin();
		//classroomObj.assignmentNavigationMethod("Central Integration Planner");
		customXpathMethod("Internal Applications Consultant").click();
		classroomObj.disableAssignmentComments();
		
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	@Test(priority = 3)
	public void enableAssignmentCommentsTest() {
		try {
		
		//loginObj.validLogin();
		//classroomObj.assignmentNavigationMethod("Central Integration Planner");
		//customXpathMethod("Central Integration Planner").click();
		classroomObj.enableAssignmentComments();
		classroomObj.backBtn.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@Test(priority = 4)
	public void assignmentCommentTest() {
		try {
		testData = TestDataObj.getEditAssignmentData();
		//loginObj.validLogin();
		//classroomObj.assignmentNavigationMethod("Central Integration Planner");
		customXpathMethod("Internal Applications Consultant").click();
		classroomObj.assignmentDetailsNavigation(testData[0]);
		classroomObj.sendComment();
		//Details comment count check
		verification = classroomObj.commentCount.getText();
		actualArray.add(verification);
		expectedArray.add("Comments (1)");
	
		//Classfeed comment count
		classroomObj.detailsPageBackBtn.click();
		classroomObj.assignmentTab.click();
		verification = classroomObj.classFeedCommentCount.getText();
		actualArray.add(verification);
		expectedArray.add("1 Comment");
		
		//HomePage comment count
		classroomObj.backBtn.click();
		homeObj.homeBtn.click();
		homeObj.searchBar.sendKeys(testData[0]);
		homeObj.searchBtn.click();
		verification = homeObj.commentCountHomeFeed.getText();
		actualArray.add(verification);
		expectedArray.add("1 Comment");
		classroomObj.backBtn.click();
		
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualArray + "\nExpcted: " + expectedArray);
		assertEquals(actualArray, expectedArray);

		
	}

		
	
	@Test(priority = 5)
	public void deleteAssignmentTest() {
		try {
		//loginObj.validLogin();
		classroomObj.assignmentNavigationMethod("Internal Applications Consultant");
		//customXpathMethod("").click();
		classroomObj.deleteAssignment();
		classroomObj.backBtn.click();
		homeObj.homeBtn.click();
		sleep(500);
		homeObj.searchBar.click();
		homeObj.searchBar.sendKeys(testData[0]);
		homeObj.searchBtn.click();
		actualstring = homeObj.noResultsMessage.getText();
		expectedstring = "No results found";
		classroomObj.backBtn.click();
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
