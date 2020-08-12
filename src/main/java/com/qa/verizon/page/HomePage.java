package com.qa.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.ElementUtil;

public class HomePage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	
 
	By phoneslist=By.xpath("//div[@class='gnav20-primary-menu gnav20-grouping']");
	By smartphones= By.xpath("//*[@id='gnav20-Shop-L3-1'][2]");
	
	
	public HomePage(WebDriver driver){
		
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	public String getHomePageTitle(){
		
		return elementUtil.doGetPageTitle();
	}
	
	public SmartPhonePage selectPhonesList() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBe(phoneslist, "Shop"));
		
		WebElement phonelist=driver.findElement(phoneslist);
		
		Actions actions=new Actions(driver);
		actions.moveToElement(phonelist).build().perform();
		return new  SmartPhonePage(driver);
		
	}
	public SmartPhonePage SmartphonesClick(){
		elementUtil.doClick(smartphones);
		return new SmartPhonePage(driver);
	}
	
}

	
	


