package com.qa.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.ElementUtil;

public class SmartPhonePage extends BasePage{
	
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	//locator:
By selectedPhone= By.xpath("//div[@id='tile_dev12400034']//div[@class='tile-top']");
	
public SmartPhonePage(WebDriver driver) {
	this.driver=driver;
	elementUtil=new ElementUtil(driver);	
	
}	
	
public String getHomePageTitle(){
	return elementUtil.doGetPageTitle();
	}

public PhonePage choosePhone(){
	
	elementUtil.doClick(selectedPhone);
	return new PhonePage(driver);
}
	

}
