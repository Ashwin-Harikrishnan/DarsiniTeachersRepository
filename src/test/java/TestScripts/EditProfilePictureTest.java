package TestScripts;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ObjectRepository.AssignmentPage;
import ObjectRepository.ClassroomPage;
import ObjectRepository.EditProfilePage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProfilePage;
import TestData.ExcelDataImport;
import TestData.TestDataImport;

public class EditProfilePictureTest extends BaseClass{
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
	EditProfilePage editprofileObj;
	ProfilePage profilePageObj;
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
		editprofileObj = new EditProfilePage(androidDriver);
		profilePageObj = new ProfilePage(androidDriver);
		

	}

	
	//@Test
	public void editProfilePictureTest() {
		try {
		loginObj.validLogin();
		sleep(500);
		homeObj.profileBtn.click();
		logoutObj.profileEditBtn.click();
		editprofileObj.profilePicBtn.click();
		editprofileObj.chooseFromLibraryBtn.click();
		editprofileObj.pictureToAdd.click();
		editprofileObj.selectAPicture.click();
		editprofileObj.cropPageSave.click();
		editprofileObj.profileSaveBtn.click();
		expectedstring = "Your profile has been updated successfully";
		actualstring = editprofileObj.verificationDialog.getText();
		System.out.println("Profile picture successfully changed");

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		assertEquals(actualstring, expectedstring);
	}
	
	@Test
	public void changePasswordTest() {
		loginObj.validLogin();
		sleep(500);
		homeObj.profileBtn.click();
		scroll("Version 1.52 - UAT");
		logoutObj.changePassword.click();
		profilePageObj.changePassword();
		
	}
	
	private static void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void scroll(String visibleText) {
		androidDriver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))");
	}
}
