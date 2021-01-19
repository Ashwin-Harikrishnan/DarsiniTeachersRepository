package ObjectRepository;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends BaseClass{
	BaseClass obj = new BaseClass();
	AndroidDriver<MobileElement> androidDriver;
	
	String choice;
	
	@AndroidFindBy(id = "com.darisni.teacher:id/txt_login")
	public AndroidElement loginStart;
	@AndroidFindBy(id = "com.darisni.teacher:id/edtInput")
	public AndroidElement emailInput;
	@AndroidFindBy(id = "com.darisni.teacher:id/edt_text_id")
	public AndroidElement passwordInput;
	@AndroidFindBy(id = "com.darisni.teacher:id/enterBtn")
	public AndroidElement loginBtn;
	@AndroidFindBy(id = "com.darisni.teacher:id/dialog_message")
	public AndroidElement errorMessageElement;
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	public AndroidElement permissionBtn1;
	@AndroidFindBy(id = "com.darisni.teacher:id/btn_positive")
	public AndroidElement deviceLimitBtn;
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
	public AndroidElement permissionBtn2;
	
	
	
	
	public void validLogin() {
		try {
		sleep(1000);
		WebDriverWait wait = new WebDriverWait(androidDriver, 20);
		/*wait.until(ExpectedConditions.visibilityOf(loginStart));
		wait.until(ExpectedConditions.elementToBeClickable(loginStart));*/
		sleep(5000);
		//clickWait(loginStart);
		loginStart.click();
		emailInput.sendKeys("chinchugs+2@gmail.com");
		passwordInput.sendKeys("4916");
		loginBtn.click();
		sleep(1000);
		//deviceLoginCheck(deviceLimitBtn);
		if(deviceLimitBtn.isDisplayed()) {
			deviceLimitBtn.click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(permissionBtn1));
		permissionBtn1.click();
		wait.until(ExpectedConditions.elementToBeClickable(permissionBtn2));
		permissionBtn2.click();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public LoginPage(AndroidDriver<MobileElement> androidDriver){
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
