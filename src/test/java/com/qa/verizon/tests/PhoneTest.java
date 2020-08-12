package com.qa.verizon.tests;

import org.testng.annotations.Test;

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
import com.qa.verizon.page.PhonePage;
import com.qa.verizon.page.SmartPhonePage;

public class PhoneTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	PhonePage phone;
	SmartPhonePage smartPhone;
	HomePage homepage;

	@BeforeTest
	public void Setup() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);  
		driver.get(prop.getProperty("url"));
		homepage = new HomePage(driver);
		smartPhone = homepage.selectPhonesList();
		smartPhone = homepage.SmartphonesClick();
		phone = smartPhone.choosePhone();
	}

	@Test(priority = 1)
	public void getPhonePageTitle() {
		String title = phone.getPhonePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Apple iPhone 11 Pro Max: Colors, Reviews, & More | Buy Now");
	}

	@Test(priority = 2)
	public void chooseFeatureOfPhone() {
		phone.chooseFeatures();

	}

	@Test(priority = 3)

	public void zipCode() {
		phone.zipCodeEntering();
	}

	@Test(priority = 4)
	public void chooseFeatures() throws InterruptedException {
		phone.chooseFeatures2();
	}

	@AfterTest
	public void close() {
		driver.close();
	}

}
