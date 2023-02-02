package GenericUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import POMRepo.HomePage;
import POMRepo.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public WebDriverUtility wUtils=new WebDriverUtility();
	
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("DataBase Connection established");
	}
	@BeforeClass
	public void bcConfig()
	{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");	
	}
	@BeforeMethod
	public void bmConfig()
	{
		LoginPage login = new LoginPage(driver);
		login.loginActions("admin", "manager");
		}
	@AfterMethod
	public void amConfig()
	{

		 HomePage home = new HomePage(driver);
		home.logoutAction();
	}
	@AfterClass
	public void acConfig()
	{
			driver.quit();
	}
	@AfterSuite
	public void asConfig()
	{
		System.out.println("DataBase Connection closed");
	}
	

}
