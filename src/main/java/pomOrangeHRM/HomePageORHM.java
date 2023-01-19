package pomOrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityOrangeHRM.utilityClassOHRM;

public class HomePageORHM {
	@FindBy (xpath = "(//a[@class='oxd-main-menu-item'])[2]") private WebElement PIM;
	@FindBy (xpath = "(//a[@class='oxd-main-menu-item'])[1]") private WebElement Admin;
	@FindBy (xpath = "//p[@class='oxd-userdropdown-name']") private WebElement adminName;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a") private WebElement logoutOption;
	
	public HomePageORHM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnPIM(WebDriver driver)
	{
		PIM.click();
	}
	
	public void clickOnAdmin(WebDriver driver)
	{
		Admin.click();
	}
	
	public void logoutORHM(WebDriver driver)
	{
		adminName.click();
		utilityClassOHRM.wait(driver, 50);
		logoutOption.click();
	}

}
