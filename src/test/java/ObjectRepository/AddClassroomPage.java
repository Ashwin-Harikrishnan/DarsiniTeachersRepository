package ObjectRepository;

import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddClassroomPage extends BaseClass{
	BaseClass obj = new BaseClass();
	AndroidDriver<MobileElement> androidDriver;
	//HomePage Homeobj = new HomePage(androidDriver);
	
	String choice;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Class']")
	public AndroidElement classBtn;
	@AndroidFindBy(id = "com.darisni.teacher:id/add_button")
	public AndroidElement addClassBtn;
	@AndroidFindBy(xpath = "//android.widget.EditText[@class= 'android.widget.EditText']")
	public AndroidElement className;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Select a subject']")
	public AndroidElement subject;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Pick a grade']")
	public AndroidElement grade;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text= '2019/2020']")
	public AndroidElement schoolYear;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Select class duration']")
	public AndroidElement duration;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text= 'Your description comes here']")
	public AndroidElement description;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Art']")
	public AndroidElement subjectName1;
	
	@AndroidFindBy(id = "com.darisni.teacher:id/buttonPanel")
	public AndroidElement submitBtn;
	@AndroidFindBy(id = "com.darisni.teacher:id/btn_positive")
	public AndroidElement confirmBtn;
	
	
	public void addClassRoom( String classNameFaker, String subjectName, String gradeName, String year, String durationString, String descriptionString) {
		try {
		sleep(1000);
		classBtn.click();
		clickWait(addClassBtn);
		addClassBtn.click();
		clickWait(className);
		className.sendKeys(classNameFaker);
		
		//subject start
		subject.click();
		sleep(1000);
		choice = subjectName;
		customXpathMethod(choice).click();
		//subject End
		
		//grade start
		grade.click();
		sleep(1000);
		choice =gradeName;
		customXpathMethod(choice).click();
		//grade end
		
		//schoolyear start
		schoolYear.click();
		sleep(1000);
		choice = year;
		customXpathMethod(choice).click();
		//schoolyear end
		
		//duration start
		duration.click();
		sleep(1000);
		choice = durationString;
		customXpathMethod(choice).click();
		//duration end
		
		description.sendKeys(descriptionString);
		submitBtn.click();
		sleep(1000);
		confirmBtn.click();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public AddClassroomPage(AndroidDriver<MobileElement> androidDriver){
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
