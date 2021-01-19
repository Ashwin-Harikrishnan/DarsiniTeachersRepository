package BaseClass;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import io.appium.java_client.touch.offset.PointOption;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	public static AndroidDriver<MobileElement> androidDriver;

	@BeforeSuite
	public void setUP() {
		mobileDriver();
	}

	public void mobileDriver() {
		for (int i = 0; i < 5; i++) {
			try {
				DesiredCapabilities caps = new DesiredCapabilities();
				caps = new DesiredCapabilities();
				caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0.0");
				caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
				caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "900");
				caps.setCapability(MobileCapabilityType.APP,
						"E:\\\\Random Crap\\\\Work\\\\Downloads\\\\Darisni Teachers - v1.52 - UAT.apk");
				// URL url = new URL("http://127.0.0.1:4723/wd/hub");
				androidDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
				break;
			} catch (SessionNotCreatedException e) {
				System.out.println("Error occurred while creating session, retrying...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void deviceLoginCheck(WebElement element) {
		for (int i = 1; i < 5; i++) {
			WebDriverWait wait = new WebDriverWait(androidDriver, 20);

			System.out.println("upload");
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
	}

	public void clickWait(WebElement element) {

		for (int i = 1; i < 5; i++) {
			WebDriverWait wait = new WebDriverWait(androidDriver, 20);

			System.out.println("Cannot be clicked yet");
			wait.until(ExpectedConditions.visibilityOf(element));
		}
	}

	public WebElement customXpathMethod(String customNameString) {

		WebElement customName = androidDriver
				.findElement(By.xpath("//android.widget.TextView[@text='" + customNameString + "']"));
		return customName;
	}

	public void scrollUpMob(int howManySwipes) {
		org.openqa.selenium.Dimension size = androidDriver.manage().window().getSize();
		int startVerticalY = (int) (size.height * 0.4);
		int endVerticalY = (int) (size.height * 0.21);
		int startVerticalX = (int) (size.width / 2.1);
		try {
			for (int i = 1; i <= howManySwipes; i++) {
				new TouchAction<>(androidDriver).press(point(startVerticalX, startVerticalY))
						.waitAction(waitOptions(ofSeconds(2))).moveTo(point(startVerticalX, endVerticalY)).release()
						.perform();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
