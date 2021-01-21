package ObjectRepository;

import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeFeedAnnouncementPage extends BaseClass{
	AndroidDriver<MobileElement> androidDriver;
	String verification = "";
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Assignment Title']//following::android.widget.EditText[1]")
	public AndroidElement assignmentName;
	
	
	
	
	
	
	
	public HomeFeedAnnouncementPage(AndroidDriver<MobileElement> androidDriver){
		this.androidDriver = androidDriver;
		PageFactory.initElements(new AppiumFieldDecorator(this.androidDriver), this);	
	}
}
