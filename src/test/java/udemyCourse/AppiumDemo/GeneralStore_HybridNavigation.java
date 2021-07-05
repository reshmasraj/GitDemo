package udemyCourse.AppiumDemo;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class GeneralStore_HybridNavigation extends Capabilities{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
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
		
		
		//click on the button to navigate to web
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(2000);
		
		//getContextHandles and switch context
		Set<String> contextNames = driver.getContextHandles();
		for(String contextName : contextNames) {
			System.out.println(contextName);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		//operations on webview
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("hello");
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
		
		//mobile backbutton in Android
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		//navigate back to native app
		driver.context("NATIVE_APP");

	}

}
