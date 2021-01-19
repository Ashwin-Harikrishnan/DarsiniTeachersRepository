package ObjectRepository;

import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LogoutPage extends BaseClass {

	BaseClass obj = new BaseClass();
	AndroidDriver<MobileElement> androidDriver;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Profile']")
	public AndroidElement profileBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Settings']//following::android.widget.TextView[6]")
	public AndroidElement logoutBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Okay']")
	public AndroidElement logoutBtnConfirm;

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

	public LogoutPage(AndroidDriver<MobileElement> androidDriver) {
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
