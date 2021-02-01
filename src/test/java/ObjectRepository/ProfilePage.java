package ObjectRepository;

import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfilePage extends BaseClass {

	BaseClass obj = new BaseClass();
	AndroidDriver<MobileElement> androidDriver;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Profile']")
	public AndroidElement profileBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Settings']//following::android.widget.TextView[6]")
	public AndroidElement logoutBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Okay']")
	public AndroidElement logoutBtnConfirm;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Change Password']")
	public AndroidElement changePassword;
	@AndroidFindBy(id = "com.darisni.teacher:id/txtBtnEdit")
	public AndroidElement profileEditBtn;
	
	//ChangePassword Repository
	@AndroidFindBy(xpath = "//android.widget.EditText[@text = 'Enter your old password']")
	public AndroidElement oldPasswordField;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'New password']//following::android.widget.EditText[1]")
	public AndroidElement newPasswordField;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Confirm Password']//following::android.widget.EditText")
	public AndroidElement newPasswordFieldConfirm;
	@AndroidFindBy(id = "com.darisni.teacher:id/enterBtn")
	public AndroidElement confirmBtn;
	

	public void logout() {
		profileBtn.click();
		scroll("Version 1.52 - UAT");
		clickWait(logoutBtn);
		logoutBtn.click();

		clickWait(logoutBtnConfirm);
		logoutBtnConfirm.click();
		sleep(3000);
		androidDriver.quit();
	}
	
	public void changePassword() {
		oldPasswordField.sendKeys("4916");
		newPasswordField.sendKeys("491600");
		newPasswordFieldConfirm.sendKeys("491600");
	}

	public ProfilePage(AndroidDriver<MobileElement> androidDriver) {
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

	public void scroll(String visibleText) {
		androidDriver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))");
	}
}
