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
	//HomePage Homeobj = new HomePage(androidDriver);

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
	public AndroidElement settingsBtn;//options for assignment/announcement
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit Assignment']")
	public AndroidElement editAssignments;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit Announcement']")
	public AndroidElement editAnnouncements;
	
	

	public void assignmentNavigationMethod(String className) {

		classBtn.click();
		sleep(4000);
		scrollUpMob(10);
		clickWait(customXpathMethod(className));
		customXpathMethod(className).click();//Central Integration Planner
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
	
	public ClassroomPage(AndroidDriver<MobileElement> androidDriver) {
		this.androidDriver = androidDriver;
		PageFactory.initElements(new AppiumFieldDecorator(this.androidDriver), this);
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