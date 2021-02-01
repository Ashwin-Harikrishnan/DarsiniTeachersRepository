package ObjectRepository;

import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AnnouncementPage extends BaseClass{
	AndroidDriver<MobileElement> androidDriver;

	@AndroidFindBy(id = "com.darisni.teacher:id/add_button")
	public AndroidElement createAnnouncementStartBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Make an announcement']")
	public AndroidElement createAnnouncement;//After starting to create announcement
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Announcement Title']//following::android.widget.EditText[1]")
	public AndroidElement announcementTitle;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Announcement Title']//following::android.widget.EditText[2]")
	public AndroidElement announcementDescription;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Announcement Title']//following::android.widget.EditText[3]")
	public AndroidElement announcementAttachments;
	@AndroidFindBy(id = "com.darisni.teacher:id/toggle_switch")
	public AndroidElement commentsSlider;
	@AndroidFindBy(id = "com.darisni.teacher:id/toggle_switch_parent")
	public AndroidElement showParentsSlider;
	@AndroidFindBy(id = "com.darisni.teacher:id/buttonPanel")
	public AndroidElement createAnnouncementBtn;//After adding details
	@AndroidFindBy(id = "com.darisni.teacher:id/btn_positive")
	public AndroidElement createAnnouncementConfirmBtn;
	@AndroidFindBy(id = "com.darisni.teacher:id/buttonPanel")
	public AndroidElement editAnnouncementBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Browse From Resource Library']")
	public AndroidElement browseUploadBtn;
	@AndroidFindBy(id = "com.darisni.teacher:id/go_button")
	public AndroidElement uploadConfirmBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Test']")
	public AndroidElement TestUploadFile;
	@AndroidFindBy(id = "com.darisni.teacher:id/toolbar_left_controller")
	public AndroidElement announcementbackBtn;
	
	
	
	
	
	public void addAnnouncement(String title, String Desc, String upload, boolean comments, boolean showParents) {
		clickWait(createAnnouncementStartBtn);
		createAnnouncementStartBtn.click();
		clickWait(createAnnouncement);
		createAnnouncement.click();
		clickWait(announcementTitle);
		announcementTitle.sendKeys(title);
		announcementDescription.sendKeys(Desc);
		announcementAttachments.click();
		browseUploadBtn.click();
		sleep(1000);
		scrollUpMob(2);
		clickWait(TestUploadFile);
		TestUploadFile.click();
		uploadConfirmBtn.click();
		if(comments)
		{
			System.out.println("User has not checked the checkbox");
		}
		else
		{
			commentsSlider.click();
			
		}
		if(showParents)
		{
			System.out.println("User has not checked the checkbox");
		}
		else
		{
		showParentsSlider.click();
			
		}
		createAnnouncementBtn.click();
		createAnnouncementConfirmBtn.click();
	}
	public void editAnnouncement(String title, String Desc, String upload, boolean comments, boolean showParents) {
		
		clickWait(announcementTitle);
		announcementTitle.click();
		announcementTitle.sendKeys(title);
		announcementDescription.sendKeys(Desc);
		announcementAttachments.click();
		browseUploadBtn.click();
		sleep(1000);
		scrollUpMob(2);
		clickWait(TestUploadFile);
		TestUploadFile.click();
		uploadConfirmBtn.click();
		if(comments)
		{
			System.out.println("User has not checked the checkbox");
		}
		else
		{
			commentsSlider.click();
			
		}
		if(showParents)
		{
			System.out.println("User has not checked the checkbox");
		}
		else
		{
		showParentsSlider.click();
			
		}
		editAnnouncementBtn.click();
	
	}
	

	
	
	
	public AnnouncementPage(AndroidDriver<MobileElement> androidDriver){
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
