package POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
	@FindBy(id="username")
	WebElement usernameTextField;
	
	@FindBy(name="pwd")
	WebElement passwordTextField;
	
	@FindBy(xpath = "//div[text()='Login ']")
	WebElement loginButton;
	
	public void loginActions(String username,String password)
	{
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
		
	}
	
	
	

}
