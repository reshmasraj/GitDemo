package udemyCourse.AppiumDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;

public class GeneralStore_MobileGestures extends Capabilities {
	
	public static void main(String [] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Scrolling
		AndroidElement country = driver.findElementById("android:id/text1");
		country.click();
		String text = "Argentina";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\""+text+"\").instance(0))"));
		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		
		//Enter text, radio button and button
		AndroidElement name = driver.findElementByClassName("android.widget.EditText");
		name.sendKeys("Reshma");
		AndroidElement gen = driver.findElementByXPath("//android.widget.RadioButton[@text='Female']");
		gen.click();
		AndroidElement button = driver.findElementByClassName("android.widget.Button");
		button.click();
		
		//add to cart first product
		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
		//Click on cart button
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		//Tap on checkbox
		AndroidElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		
		//Longpress
		AndroidElement terms = driver.findElement(By.xpath("//android.widget.TextView[@text='Please read our terms of conditions']"));
		t.longPress(longPressOptions().withElement(element(terms)).withDuration(ofSeconds(2))).release().perform();
		
		//click on the close button in the pop up
		driver.findElement(By.id("android:id/button1")).click();
		
		//click on the button to navigate to web
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
	}

}
