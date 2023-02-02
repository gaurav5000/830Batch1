package POMRepo;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToVerifyHomePageTitle {
	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		String expectedTitle="Enter";

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");
		
		LoginPage login = new LoginPage(driver);
		login.loginActions("admin", "manager");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains("Enter"));
		
		HomePage home = new HomePage(driver);
		String actualTitle = home.verifyHomePageTitle();
		
		if(actualTitle.contains(expectedTitle))
		{
			System.out.println("Pass:The title is verified");
		}
		else
		System.out.println("Fail:The title is not verified");
		home.logoutAction();
		driver.quit();
	}
}
