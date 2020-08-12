package com.qa.verizon.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.verizon.base.BasePage;

public class ElementUtil extends BasePage{
	
	WebDriver driver;
	JavaScriptUtil javaScriptUtil;
	public ElementUtil(WebDriver driver){
		this.driver=driver;
		javaScriptUtil = new JavaScriptUtil(driver);
	}
	/**
	 * get Title
	 * @return
	 */
	public String doGetPageTitle(){
		
		try {
			return driver.getTitle();
			
		} catch (Exception e) {
			System.out.println("some exception occured while getting the title");
		}return null;
		
	}
	public void waitForElementPresentBy(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public WebElement getElement(By locator){
		waitForElementPresentBy(locator);
		WebElement element=null;
		
		try {
			element=driver.findElement(locator);
			if (highlightelement.equals("yes")) {
				javaScriptUtil.flash(element);
			}
		} catch (Exception e) {
			System.out.println("some exception occured while getting the element" + locator);
		}return element;
		
	}
	
	public void doClick(By locator){
		
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("some exception occured while getting the element" + locator);
		}
	}
	
	public void doSendKeys(By locator, String value){
		try {
			WebElement element=getElement(locator);
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("some exception occured while getting the value" + locator);
		}
		
	}
	
	public boolean doIsDisplayed(By locator){
		
		try {
			return getElement(locator).isDisplayed();
			
		} catch (Exception e) {
			System.out.println("some exception occured while getting the isDisplayed" + locator);
		}
		return false;
		
	}
	public boolean doIsSelected(By locator){
		
		try {
			return getElement(locator).isSelected();
			
		} catch (Exception e) {
			System.out.println("some exception occured while getting the isSelected "+ locator);
		}
		return false;
		
	}
public boolean doIsEnabled(By locator){
		
		try {
			return getElement(locator).isEnabled();
			
		} catch (Exception e) {
			System.out.println("some exception occured while getting the isEnabled "+ locator);
		}
		return false;
		
	}

public String doGetText(By locator){
	try {
		return getElement(locator).getText();
		
	} catch (Exception e) {
		System.out.println("some exception occured while getting the text from the page "+ locator);
	}
	return null;
	
}
public void cleanTheBox(By locator){
	driver.findElement(locator).clear();
	
	
	

}}



