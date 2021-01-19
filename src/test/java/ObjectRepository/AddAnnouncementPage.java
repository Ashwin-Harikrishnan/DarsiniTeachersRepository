package ObjectRepository;

import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddAnnouncementPage extends BaseClass{
	AndroidDriver<MobileElement> androidDriver;

	@AndroidFindBy(id = "com.darisni.teacher:id/add_button")
	public AndroidElement createAnnouncementStartBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Make an announcement']")
	public AndroidElement createAnnouncement;//After starting to create announcement
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text = 'Enter announcement title']")
	public AndroidElement announcementTitle;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text = 'Enter description']")
	public AndroidElement announcementDescription;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text = 'Upload: PDF, JPEG, TEXT']")
	public AndroidElement announcementAttachments;
	@AndroidFindBy(id = "com.darisni.teacher:id/toggle_switch")
	public AndroidElement commentsSlider;
	@AndroidFindBy(id = "com.darisni.teacher:id/toggle_switch_parent")
	public AndroidElement showParentsSlider;
	@AndroidFindBy(id = "com.darisni.teacher:id/buttonPanel")
	public AndroidElement createAnnouncementBtn;//After adding details
	@AndroidFindBy(id = "com.darisni.teacher:id/btn_positive")
	public AndroidElement createAnnouncementConfirmBtn;
	
	@AndroidFindBy(id = "com.darisni.teacher:id/toolbar_left_controller")
	public AndroidElement announcementbackBtn;
	
	public void addAnnouncement() {
		clickWait(createAnnouncementStartBtn);
		createAnnouncementStartBtn.click();
		clickWait(createAnnouncement);
		createAnnouncement.click();
		clickWait(announcementTitle);
		announcementTitle.sendKeys("Announcement");
		announcementDescription.sendKeys("Announcement Desc one");
		announcementAttachments.sendKeys("E:\\Users\\Ashwin Harikrishnan\\eclipse-workspace\\com.darsiniteacher\\Resources\\Images\\text2.png");
		/*if(COMMENTSLIDEREXCELBOOL)
		{
			commentsSlider.click();
		}
		else
		{
			System.out.println("User has not checked the checkbox");
		}
		if(PARENTSLIDEREXCELBOOL)
		{
			showParentsSlider.click();
		}
		else
		{
			System.out.println("User has not checked the checkbox");
		}*/
		createAnnouncementBtn.click();
		createAnnouncementConfirmBtn.click();
	}
	

	
	
	
	public AddAnnouncementPage(AndroidDriver<MobileElement> androidDriver){
		this.androidDriver = androidDriver;
		PageFactory.initElements(new AppiumFieldDecorator(this.androidDriver), this);	
	}
}
