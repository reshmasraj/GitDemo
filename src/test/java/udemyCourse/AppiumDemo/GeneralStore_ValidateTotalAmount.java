package udemyCourse.AppiumDemo;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GeneralStore_ValidateTotalAmount extends Capabilities {
	
	public static void main(String [] args) throws MalformedURLException, InterruptedException {
		

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
			
			//click add to cart of first two products
			driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
			driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(1).click();
			
			//In e-commerce sites, some cases if we click on first add to cart, then the button name changed to Added to cart. 
			//Hence the second add to cart button will have the index 0 itself hence the array size decreased by 1. Because first add to cart is removed from this array now 
			//In such cases should give the index as 0 instead of 1 for both the add to cart button.
			
			//Click on cart button
			driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
			
			Thread.sleep(2000);
			
			//get the price of two products from the list using index value	
			String price1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
			String price2 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
			
			//It will be in string and have $ symbol. remove the $ symbol to convert into double for summing the prices
			price1 = price1.substring(1);
			price2 = price2.substring(1);
			//this will eliminate $ symbol since it is at 0th index
			//substring(int beginingIndex) function will start with the char from the given index as beginning
			//we can also give the end index as substring(int beginingIndex, int endIndex) for beginning and ending characters
			
			//Convert this string to double
			double price1value = Double.parseDouble(price1);
			double price2value = Double.parseDouble(price2);
			
			double sum = price1value+price2value;
			
			//Compare with total purchase amount
			String totalPurchase = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
			totalPurchase = totalPurchase.substring(1);
			double totalPurchaseValue = Double.parseDouble(totalPurchase);
			System.out.println("Sum of price : "+sum);
			System.out.println("Total purchase Amount : "+totalPurchaseValue);
			
			Assert.assertEquals(sum, totalPurchaseValue);
			
			
			
					
					
			
			
					
			
			
			
	
	}	
}
