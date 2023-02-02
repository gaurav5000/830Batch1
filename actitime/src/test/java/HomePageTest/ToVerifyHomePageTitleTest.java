package HomePageTest;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import GenericUtility.BaseClass;
import POMRepo.HomePage;

public class ToVerifyHomePageTitleTest extends BaseClass{
	@Test
	
	public void toVerifyHomePageTitleTest () {		
		String expectedTitle="actiTIME - Enter Time-Track";
		
		wUtils.waitForHomePageTitleTest(driver, 20, expectedTitle);		
		HomePage home = new HomePage(driver);
		String actualTitle = home.verifyHomePageTitle();		
		Assert.assertEquals(actualTitle, expectedTitle);		
		System.out.println("Pass:The title is  verified");		
	}
}
