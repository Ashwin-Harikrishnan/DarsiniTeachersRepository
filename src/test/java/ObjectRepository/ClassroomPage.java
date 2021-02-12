package ObjectRepository;

import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ClassroomPage extends BaseClass {
	BaseClass obj = new BaseClass();
	AndroidDriver<MobileElement> androidDriver;
	// HomePage Homeobj = new HomePage(androidDriver);

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Class']")
	public AndroidElement classBtn;
	@AndroidFindBy(id = "com.darisni.teacher:id/add_button")
	public AndroidElement createAssignmentAnnouncementStartBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Create an assignment']")
	public AndroidElement createAssignmentBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Make an announcement']")
	public AndroidElement createAnnouncementBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Make an announcement or send out an assignment to your students']")
	public AndroidElement classroomVerificationText;
	@AndroidFindBy(id = "com.darisni.teacher:id/img_back_navigation")
	public AndroidElement backBtn;
	@AndroidFindBy(id = "com.darisni.teacher:id/txt_btn_announcements")
	public AndroidElement announcementTab;
	@AndroidFindBy(id = "com.darisni.teacher:id/txt_btn_assignments")
	public AndroidElement assignmentTab;
	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id ='com.darisni.teacher:id/settingBtn']")
	public AndroidElement settingsBtn;// options for assignment/announcement
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit Assignment']")
	public AndroidElement editAssignments;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Delete']")
	public AndroidElement deleteBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit Announcement']")
	public AndroidElement editAnnouncements;
	@AndroidFindBy(id = "com.darisni.teacher:id/txt_comments")
	public AndroidElement classFeedCommentCount;
	

	// Comments
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Disable Comments']")
	public AndroidElement disableComments;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Enable Comments']")
	public AndroidElement enableComments;

	// Details Page
	@AndroidFindBy(id = "com.darisni.teacher:id/edt_send_message")
	public AndroidElement commentField;
	@AndroidFindBy(id = "com.darisni.teacher:id/img_send_button")
	public AndroidElement commentSendBtn;
	@AndroidFindBy(id = "com.darisni.teacher:id/txt_comments_count")
	public AndroidElement commentCount;
	@AndroidFindBy(id = "com.darisni.teacher:id/toolbar_left_controller")
	public AndroidElement detailsPageBackBtn;
	
	
	
	public void assignmentNavigationMethod(String className) {

		classBtn.click();
		sleep(4000);
		//scrollUpMob(10);
		clickWait(customXpathMethod(className));
		customXpathMethod(className).click();// Central Integration Planner
	}

	public void editAssignmentNavigation() {
		assignmentTab.click();
		clickWait(settingsBtn);
		settingsBtn.click();
		editAssignments.click();
		sleep(1000);
	}

	public void editAnnouncementNavigation() {
		announcementTab.click();
		clickWait(settingsBtn);
		settingsBtn.click();
		editAnnouncements.click();
		sleep(1000);
	}

	public void disableAnnouncementComments() {
		announcementTab.click();
		clickWait(settingsBtn);
		settingsBtn.click();
		disableComments.click();
		sleep(1000);
	}

	public void enableAnnouncementComments() {
		announcementTab.click();
		clickWait(settingsBtn);
		settingsBtn.click();
		enableComments.click();
		sleep(1000);
	}

	public void disableAssignmentComments() {
		assignmentTab.click();
		clickWait(settingsBtn);
		settingsBtn.click();
		disableComments.click();
		sleep(1000);
	}

	public void enableAssignmentComments() {
		assignmentTab.click();
		clickWait(settingsBtn);
		settingsBtn.click();
		enableComments.click();
		sleep(1000);
	}

	public void deleteAssignment() {
		assignmentTab.click();
		clickWait(settingsBtn);
		settingsBtn.click();
		deleteBtn.click();
		sleep(1000);
	}

	public void deleteAnnouncement() {
		announcementTab.click();
		clickWait(settingsBtn);
		settingsBtn.click();
		deleteBtn.click();
		sleep(1000);
	}
	public void announcementDetailsNavigation(String announcementName) {
		announcementTab.click();
		clickWait(settingsBtn);
		customXpathMethod(announcementName).click();
		
		
	}
	public void assignmentDetailsNavigation(String assignmentName) {
		assignmentTab.click();
		clickWait(settingsBtn);
		customXpathMethod(assignmentName).click();
		
	}
	public void sendComment() {
		commentField.sendKeys("Test Assignment 1");
		commentSendBtn.click();
	}

	public ClassroomPage(AndroidDriver<MobileElement> androidDriver) {
		this.androidDriver = androidDriver;
		PageFactory.initElements(new AppiumFieldDecorator(this.androidDriver), this);
	}

	
}
