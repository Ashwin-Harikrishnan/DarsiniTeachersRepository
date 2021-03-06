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
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Home\"]")
	public AndroidElement homeBtn;
	@AndroidFindBy(id = "com.darisni.teacher:id/search_button")
	public AndroidElement searchBtn;
	@AndroidFindBy(id = "com.darisni.teacher:id/searchView")
	public AndroidElement searchBar;
	@AndroidFindBy(id = "com.darisni.teacher:id/emptyTextView")
	public AndroidElement noResultsMessage;
	@AndroidFindBy(id = "com.darisni.teacher:id/txt_comments")
	public AndroidElement commentCountHomeFeed;
	@AndroidFindBy(id = "com.darisni.teacher:id/txtBtnEdit")
	public AndroidElement profileEditBtn;
	
	

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

	

}
