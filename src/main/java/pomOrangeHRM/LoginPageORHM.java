package pomOrangeHRM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityOrangeHRM.utilityClassOHRM;

public class LoginPageORHM {
	@FindBy(xpath= "//input[@name='username']") private WebElement userName;
	@FindBy(xpath = "//input[@name='password']") private WebElement password;
	@FindBy(xpath = "//button[contains(@class,'login-button')]") private WebElement loginButton;
	
	public LoginPageORHM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(WebDriver driver) throws IOException
	{	
		userName.clear();
		userName.sendKeys(utilityClassOHRM.readPropertyFile(driver, "username"));
	}
	
	public void enterPassword(WebDriver driver) throws IOException
	{
		password.clear();
		password.sendKeys(utilityClassOHRM.readPropertyFile(driver, "password"));
	}
	
	public void clickOnLoginButton(WebDriver driver)
	{
		loginButton.click();
	}

}
