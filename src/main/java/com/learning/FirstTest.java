package com.learning;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.navigate().refresh();
		//WebElement languageselection=driver.findElement(By.xpath("//a[@href='/customer-preferences/edit?ie=UTF8&preferencesReturnUrl=%2F&ref_=topnav_lang']/span/span[2]/span[2]"));
		WebElement languageselection=driver.findElement(By.xpath("//div[@id='icp-nav-flyout']"));
		Actions act=new Actions(driver);
		act.moveToElement(languageselection).perform();
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id, 'nav-flyout-icp')]")));
		List<WebElement> selectoneLanguage=driver.findElements(By.xpath("//div[contains(@id, 'nav-flyout-icp')]//a"));
		
		int count=selectoneLanguage.size();
		boolean found=false;
		for(int i=0;i<count;i++)
		{
			WebElement link=selectoneLanguage.get(i);
			
		if(	link.getAttribute("lang").equalsIgnoreCase("te-IN"))
		{
			link.click();
			found=true;
			break;
		}
			
		}
		
		if (found) {
            System.out.println("Language 'తెలుగు' selected successfully.");
        } else {
            System.out.println("Language 'తెలుగు' not found.");
        }
		
	
	}
}

