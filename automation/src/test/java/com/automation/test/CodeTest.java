package com.automation.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CodeTest {
WebDriver driver;
	
	@Test
	public void search() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Gashaw\\Documents\\file\\CodeTask\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.webstaurantstore.com");
		driver.findElement(By.xpath("//input[@id='searchval']")).sendKeys("stainless work table");
		driver.findElement(By.xpath("//button[@value='Search']")).click();
		List<WebElement> eleLink = driver.findElements(By.xpath("//a[@class='block font-semibold text-sm-1/2 leading-none mb-3 first:mt-8 max-h-10 hover:max-h-full min-h-10 overflow-hidden hover:overflow-visible md:mb-3 mt-0 md:mt-1-1/2']"));
		//Verify each link contains Table
		for(int i=0; i < eleLink.size();i++) {
			eleLink.get(i).getText().contains("Table");
		}
		
		//add the last item to cart
		driver.findElement(By.xpath("(//a[@class='block font-semibold text-sm-1/2 leading-none mb-3 first:mt-8 max-h-10 hover:max-h-full min-h-10 overflow-hidden hover:overflow-visible md:mb-3 mt-0 md:mt-1-1/2']/../..//input[@name='addToCartButton'])['"+ eleLink.size()+"']")).click();
		//view added cart
		driver.findElement(By.xpath("//a[text()='View Cart']")).click();
		//Empty the added cart
		driver.findElement(By.xpath("//a[text()='Empty Cart']")).click();
		//click on popup confirmation button
		driver.findElement(By.xpath("//button[text()='Empty Cart']")).click();
		//verify the cart is empty or not
		driver.findElement(By.xpath("//p[text()='Your cart is empty.']")).isDisplayed();
		//close the browser
		driver.quit();
		
		
	}


}
