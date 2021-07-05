package udemyCourse.AppiumDemo;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GeneralStore_FillingForm  extends Capabilities{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Scroling
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
		
		
		System.out.println("Git Demo");
		System.out.println("Git Demo - code");
		System.out.println("Git Demo - code2");
		

	}

}
