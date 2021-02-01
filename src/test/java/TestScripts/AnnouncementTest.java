package TestScripts;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ObjectRepository.AnnouncementPage;
import ObjectRepository.ClassroomPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProfilePage;
import TestData.ExcelDataImport;
import TestData.TestDataImport;

public class AnnouncementTest extends BaseClass {
	ClassroomPage classroomObj;
	AnnouncementPage announcementObj;
	LoginPage loginObj;
	HomePage homeObj;
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
		announcementObj = new AnnouncementPage(androidDriver);
		logoutObj = new ProfilePage(androidDriver);
		homeObj = new HomePage(androidDriver);
		TestDataObj = new TestDataImport();
		excelDataObj = new ExcelDataImport();
		excelDataObj.readExcel("AnnouncementPage");

	}

	@Test(priority = 0)
	public void addAnnouncementTest() {
		try {
			eTest = eReports.createTest("Add Announcement");
			eTest.assignCategory("Announcement");
			System.out.println("addAnnouncementTest START");
			testData = TestDataObj.getAddAnnouncementData();
			loginObj.validLogin();
			classroomObj.assignmentNavigationMethod("Internal Applications Consultant");
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
			eTest = eReports.createTest("Edit Announcement");
			eTest.assignCategory("Announcement");
			customXpathMethod("Internal Applications Consultant").click();
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
			eTest = eReports.createTest("Disable comments test");
			eTest.assignCategory("Announcement");
			customXpathMethod("Internal Applications Consultant").click();
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
			eTest = eReports.createTest("Enable comments Test");
			eTest.assignCategory("Announcement");
			customXpathMethod("Internal Applications Consultant").click();
			classroomObj.enableAnnouncementComments();
			classroomObj.backBtn.click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test(priority = 4)
	public void announcementCommentTest() {
		try {
		testData = TestDataObj.getEditAnnouncementData();
		//loginObj.validLogin();
		//classroomObj.assignmentNavigationMethod("Internal Applications Consultant");
		eTest = eReports.createTest("Announcement comment test");
		eTest.assignCategory("Announcement");
		customXpathMethod("Internal Applications Consultant").click();
		classroomObj.announcementDetailsNavigation(testData[0]);
		classroomObj.sendComment();
		
		//Details comment count check
		verification = classroomObj.commentCount.getText();
		actualArray.add(verification);
		expectedArray.add("Comments (1)");
	
		//Classfeed comment count
		classroomObj.detailsPageBackBtn.click();
		classroomObj.announcementTab.click();
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

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualArray + "\nExpcted: " + expectedArray);
		assertEquals(actualArray, expectedArray);

		
	}


	@Test(priority = 5)
	public void deleteAnnouncementTest() {
		try {
			testData = TestDataObj.getEditAnnouncementData();
			//loginObj.validLogin();
			//classroomObj.assignmentNavigationMethod("Internal Applications Consultant");
			eTest = eReports.createTest("Delete Announcement");
			eTest.assignCategory("Announcement");
			customXpathMethod("Internal Applications Consultant").click();
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

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		Assert.assertEquals(expectedstring, actualstring);
	}

	//@AfterClass
	public void endTest() {
		sleep(1000);
		// classroomObj.backBtn.click();
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
