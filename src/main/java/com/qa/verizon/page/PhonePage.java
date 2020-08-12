package com.qa.verizon.page;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.verizon.util.ElementUtil;

public class PhonePage {
	WebDriver driver;
	ElementUtil elementUtil;
	
	//locators
	
	By color =By.xpath("//div[@class='deviceConfig padTop6 border_bottomBlack padBottom30']//div[4]//div[1]");
	By capacity = By.xpath("//p[contains(text(),'512GB')]");
	By payment= By.xpath("//div[contains(@class,'cursorPointer height100p positionRelative border_grayThree')]//div[@class='pad8 noRightPad']");
	By continu= By.id("ATC-Btn");
	By zipcodeCheckBox= By.id("zipcodeCheckbox");
	By zipCode= By.id("zipcode");
	By confirmButton= By.className("defaultPrimaryCTA");
	By newCustomer = By.xpath("//button[@class='modalButton fontSize_12 NHaasDS55Rg background_FF onlyRightMargin margin8']");
	By next = By.xpath("//button[@class='button margin30 onlyTopMargin primary']");
	By tradeIn= By.xpath("//button[@class='pad12 cursorPointer positionRelative border_grayThree width100 textAlignLeft']//p[@class='body'][contains(text(),'No')]");
	By deviceProtection= By.id("declineDeviceSelectProtecionBtn");
	By secondDeviceProtection= By.xpath("//button[@class='secondary button cancelProtectionButton']");
	By selectPlanList= By.xpath("//button[contains(@aria-label, 'Get More Unlimited')]");
	By chooseJetPack= By.xpath("//button[@class='button secondary width100 m-promo-button noThanks']");
	//By bothDeviceChoose= By.xpath("//button[@class='button secondary floatLeft margin30 onlyLeftMargin onlyDesktop']");
	By savecart= By.xpath("//div[@class='displayCartLinks margin30 onlyTopMargin onlyDesktop']//a[@class='saveCartPadding'][contains(text(),'Save cart')]");
	By emailsending= By.name("email");
	By emailsavingBtn= By.xpath("//button[contains(text(),'Save')]");
	By closingBtn= By.xpath("//button[@class='closeButton floatRight']//*[local-name()='svg']");


	//Constructor
	
	public PhonePage (WebDriver driver) {
		this.driver=driver;
		elementUtil= new ElementUtil(driver);
		
	}
	public String getPhonePageTitle() {
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains("Apple iPhone 11 Pro Max: Colors, Reviews, & More | Buy Now"));
		return elementUtil.doGetPageTitle();
		
	}
	public void chooseFeatures(){
		elementUtil.doClick(color);
		elementUtil.doClick(capacity);
		elementUtil.doClick(payment);
		elementUtil.doClick(continu);
	}
	public void zipCodeEntering(){
		elementUtil.doClick(zipcodeCheckBox);
		elementUtil.cleanTheBox(zipCode);
		elementUtil.doSendKeys(zipCode, "75082");
		elementUtil.doClick(confirmButton);
	}
	public void  chooseFeatures2() throws InterruptedException {
		elementUtil.doClick(newCustomer);
		elementUtil.doClick(next);
		elementUtil.doClick(tradeIn);
		elementUtil.doClick(deviceProtection);
		elementUtil.doClick(secondDeviceProtection);
		Thread.sleep(5000);
		elementUtil.doClick(selectPlanList);
		elementUtil.doClick(chooseJetPack);
		//elementUtil.doClick(bothDeviceChoose);
		Thread.sleep(5000);
		elementUtil.doClick(savecart);
		elementUtil.doSendKeys(emailsending,"fatihgene@gmail.com");
		elementUtil.doClick(emailsavingBtn);
		elementUtil.doClick(closingBtn);
		
		
	}

}

