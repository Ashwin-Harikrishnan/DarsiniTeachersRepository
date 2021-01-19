package ObjectRepository;

import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends BaseClass {
	BaseClass obj = new BaseClass();
	AndroidDriver<MobileElement> androidDriver;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Class']")
	public AndroidElement classBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Profile']")
	public AndroidElement profileBtn;

	public void assignmentNavigationMethod() {

		classBtn.click();
		sleep(4000);
		scrollUpMob(8);
		clickWait(customXpathMethod("Central Integration Planner"));
		customXpathMethod("Central Integration Planner").click();
	}

	public HomePage(AndroidDriver<MobileElement> androidDriver) {
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
