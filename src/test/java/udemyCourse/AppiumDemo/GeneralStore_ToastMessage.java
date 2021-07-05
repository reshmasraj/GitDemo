package udemyCourse.AppiumDemo;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

public class GeneralStore_ToastMessage extends Capabilities {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	
		AndroidElement button = driver.findElementByClassName("android.widget.Button");
		button.click();
		
		//Toast message
		String toastMssg = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		System.out.println(toastMssg);
		Assert.assertEquals("Please enter your name", toastMssg);
		
		

	}

}
