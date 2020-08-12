package com.qa.verizon.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.HomePage;
import com.qa.verizon.page.SmartPhonePage;

public class HomePageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	
	
	@BeforeTest
	public void Setup() throws InterruptedException{
		basePage = new BasePage();
		prop=basePage.init_properties();
		String browserName= prop.getProperty("browser");
		driver=basePage.init_driver(browserName);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		homePage= new HomePage(driver);		
	
	}
	@Test(priority=1, description= "Verizon: Wireless, Internet, TV and Phone Services | Official Site")
	public void verifyHomePageTitle(){
	String title= 	homePage.getHomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Verizon: Wireless, Internet, TV and Phone Services | Official Site");
	}
	@Test(priority=2, description= "Select phone list")
	public void selectPhoneList(){
		
		homePage.selectPhonesList();
	}
	
	@Test(priority=3, description="Smart phones click")
	public void smartPhoneClick(){
		homePage.SmartphonesClick();
		
	}
	
	@AfterTest
	public void tearDown(){
	driver.quit();
	}

}

