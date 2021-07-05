package udemyCourse.AppiumDemo;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

public class GeneralStore_ScrollingProductList  extends Capabilities{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
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
		
		//Dynamic scrolling
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
		
		//For clicking particular Add to cart button
		
		//getting the total list of products displyed in the screen
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		//checking whether the product is the mentioned one
		for(int i=0;i<count;i++) {
			String pname = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(pname.equals("Jordan 6 Rings")) {
				//if the name matches then from the list of add to cart button we are passing the value of i as index and clicking on the same button
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}				
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		Thread.sleep(2000);
		
        String prodActName = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        System.out.println(prodActName);
        Assert.assertEquals("Jordan 6 Rings", prodActName);
        
		
		

	}

}
