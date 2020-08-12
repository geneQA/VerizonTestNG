
package com.qa.verizon.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.HomePage;
import com.qa.verizon.page.PhonePage;
import com.qa.verizon.page.SmartPhonePage;

public class SmartPhoneTest {
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

	}

	@Test(priority = 1)
	public void PagetitleVerify() {
		String title = smartPhone.getHomePageTitle();
		System.out.println("Title is " + title);
		Assert.assertEquals(title, "Smartphones - Buy The Newest Cell Phones | Verizon Wireless");
	}

	@Test(priority = 2)
	public void Choosephone() {
		smartPhone.choosePhone();
	}

	@AfterTest
	public void teardown() {

		driver.quit();
	}
}


