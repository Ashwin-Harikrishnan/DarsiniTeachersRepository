package ObjectRepository;

import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddAssignmentPage extends BaseClass{
	AndroidDriver<MobileElement> androidDriver;
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Assignment Title']//following::android.widget.EditText[1]")
	public AndroidElement assignmentName;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Assignment Title']//following::android.widget.EditText[2]")
	public AndroidElement assignmentDescription;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Assignment Title']//following::android.widget.EditText[3]")
	public AndroidElement assignmentFileUpload;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Assignment Title']//following::android.widget.EditText[4]")
	public AndroidElement assignmentDatepicker;
	@AndroidFindBy(id = "com.darisni.teacher:id/toggle_switch")
	public AndroidElement commentsSlider;
	@AndroidFindBy(id = "com.darisni.teacher:id/toggle_switch_parent")
	public AndroidElement showParentsSlider;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Create']")
	public AndroidElement assignmentConfirm;
	@AndroidFindBy(id = "com.darisni.teacher:id/btn_positive")
	public AndroidElement assignmentPopupConfirm;
	@AndroidFindBy(id = "com.darisni.teacher:id/add_button")
	public AndroidElement createAssignmentStartBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Create an assignment']")
	public AndroidElement createAssignmentBtn;
	@AndroidFindBy(id = "com.darisni.teacher:id/txt_card_title")
	public AndroidElement assignmentNameVerification;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Update']")
	public AndroidElement updateAssignmentBtn;
	@AndroidFindBy(id = "android:id/button2")
	public AndroidElement datePickerCancelBtn;
	

	
	
	public void addAssignment(String assignmentTitle, String assignmentDesc, String assignmentFile, String Date, boolean Comments, boolean showParents) {
		clickWait(createAssignmentStartBtn);
		createAssignmentStartBtn.click();
		clickWait(createAssignmentBtn);
		createAssignmentBtn.click();
		clickWait(assignmentName);
		assignmentName.sendKeys(assignmentTitle);
		assignmentDescription.sendKeys(assignmentDesc);
		assignmentFileUpload.sendKeys(assignmentFile);
		assignmentDatepicker.sendKeys(Date);
		
		if(Comments)
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
		assignmentConfirm.click();
		assignmentPopupConfirm.click();
		
	}
	
	public void editAssignment(String assignmentTitle, String assignmentDesc, String assignmentFile, String Date, boolean Comments, boolean showParents) {
		
		assignmentName.sendKeys(assignmentTitle);
		assignmentDescription.sendKeys(assignmentDesc);
		assignmentFileUpload.sendKeys(assignmentFile);
		assignmentDatepicker.sendKeys(Date);
		assignmentDatepicker.click();
		datePickerCancelBtn.click();
		if(Comments)
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
		updateAssignmentBtn.click();
		
		
	}
	
	public AddAssignmentPage(AndroidDriver<MobileElement> androidDriver){
		this.androidDriver = androidDriver;
		PageFactory.initElements(new AppiumFieldDecorator(this.androidDriver), this);	
	}
	
}
