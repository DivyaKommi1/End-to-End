package com.learning;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class secondTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.navigate().refresh();
		WebElement Cs=driver.findElement(By.xpath("//a[@href=\"/gp/help/customer/display.html?nodeId=200507590&ref_=nav_cs_help\"]"));
		Cs.click();
		driver.navigate().back();
		WebElement ele=driver.findElement(By.xpath("//a[@href=\"/electronics/b/?ie=UTF8&node=976419031&ref_=nav_cs_electronics\"]"));
		ele.click();
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		WebElement lap=driver.findElement(By.xpath("//span[contains(text(),'Laptops')]"));
		lap.click();
		
		List<WebElement>ls=driver.findElements(By.xpath("//div[@id='anonCarousel1']/ol/li"));
		for(WebElement item: ls)
		{
			if(item.getAttribute("aria-posinset").equals("1"))
			{
			item.click();
			break;
			}
			
		}
	// quantity dropdown select
		
		WebElement dropdown= driver.findElement(By.id("a-autoid-0-announce"));
		dropdown.click();
		
		js.executeScript("window.scrollBy(0,300)");
		WebElement qun=driver.findElement(By.xpath("//select[@class='a-native-dropdown a-declarative']"));
		Select se=new Select(qun);
	//a-native-dropdown a-declarative
		//a-nostyle a-list-link
		//js.executeScript("arguments[0].scrollTop=arguments[0].scrollHeight, dropdown");
		int count=0;
		int max=0;
		for(WebElement option : se.getOptions())
		{
			String value = option.getAttribute("value");
			int qty=Integer.parseInt(value);
			if(qty>max)
			{
				max=qty;
			}
			
		}
		System.out.println(max);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",max);
		//Thread.sleep(5000);
		se.selectByIndex(max);
		
      WebElement addtoCart= driver.findElement(By.xpath("//input[@id='Add to Shopping Cart']"));
      addtoCart.click();	
	}}
