package ObjectRepository;

import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EditProfilePage extends BaseClass{
	AndroidDriver<MobileElement> androidDriver;
	
	@AndroidFindBy(id = "com.darisni.teacher:id/imageUser")
	public AndroidElement profilePicBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Choose from Library']")
	public AndroidElement chooseFromLibraryBtn;
	@AndroidFindBy(id = "com.google.android.apps.photos:id/image")
	public AndroidElement pictureToAdd;
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Photo taken on Jan 28, 2021 11:01:41 AM\"]")
	public AndroidElement selectAPicture;
	@AndroidFindBy(id = "com.darisni.teacher:id/crop_image_menu_crop")
	public AndroidElement cropPageSave;
	@AndroidFindBy(id = "com.darisni.teacher:id/toolbar_right_controller")
	public AndroidElement profileSaveBtn;
	@AndroidFindBy(id = "com.darisni.teacher:id/dialog_message")
	public AndroidElement verificationDialog;
	@AndroidFindBy(id = "com.darisni.teacher:id/btn_positive")
	public AndroidElement popupConfirmBtn;
	
	
	public EditProfilePage(AndroidDriver<MobileElement> androidDriver) {
		this.androidDriver = androidDriver;
		PageFactory.initElements(new AppiumFieldDecorator(this.androidDriver), this);
	}

	
}
