package pomOrangeHRM;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import net.bytebuddy.utility.RandomString;
import utilityOrangeHRM.utilityClassOHRM;

public class AdminPageOHRM {
	@FindBy (xpath = "(//span[contains(@class,'oxd-topbar-body-nav-tab-item')])[2]") private WebElement Job;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/ul/li[2]/a") private WebElement payGrades;
	@FindBy (xpath = "(//button[@type='button'])[2]") private WebElement AddButton;
	@FindBy (xpath = "(//input[@class='oxd-input oxd-input--active'])[2]") private WebElement payName;
	@FindBy (xpath = "//button[@type='submit']") private WebElement saveButton1;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/div/div[1]/div/button") private WebElement addCurrencyButton;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/form/div[1]/div/div/div/div[2]/div/div/div[1]") private WebElement currencyName;
	@FindBy (xpath = "(//input[contains(@class,'oxd-input oxd-input--active')])[3]") private WebElement minSalary;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/div/div[2]/input") private WebElement maxSalary;
	@FindBy (xpath = "(//button[@type='submit'])[2]") private WebElement saveButton2;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/form/div[1]/div/div/div/div[2]/div/div/div[1]") private WebElement INR;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/form/div[1]/div/div/div/div[2]/div/div") private WebElement textBox;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div/div") private List<WebElement> currencyBox;
	@FindBy (xpath = "(//div[@role='row'])[2]") private WebElement currencyRecord;
	@FindBy (xpath = "(//div[@role='cell'])[2]") private WebElement currency;
	@FindBy (xpath = "(//div[@role='cell'])[3]") private WebElement min;
	@FindBy (xpath = "(//div[@role='cell'])[4]") private WebElement max;
	
	
	public AdminPageOHRM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void addCurrency(WebDriver driver) throws InterruptedException
	{	
		utilityClassOHRM.explicitWait(driver, Job, 3000);
		Job.click();
		utilityClassOHRM.explicitWait(driver, payGrades, 3000);
		payGrades.click();
		utilityClassOHRM.explicitWait(driver,AddButton, 3000);
		AddButton.click();
		utilityClassOHRM.explicitWait(driver, payName, 3000);
		String s = RandomString.make(2);
		payName.sendKeys("Indian Rupee"+s);
		//If currency name is already saved its not accepting it again and 
		//script was breaking so just to make sure further TC flow used RandomString 
		//to get new currency name every time the script will execute and flow will not break
		utilityClassOHRM.explicitWait(driver, saveButton1, 3000);
		saveButton1.click();
		utilityClassOHRM.explicitWait(driver, addCurrencyButton, 3000);
		addCurrencyButton.click();
		utilityClassOHRM.explicitWait(driver, textBox, 3000);
		Actions act = new Actions(driver);
	    act.click(textBox).perform();
	       for(int i=1; i<=58; i++)
	       {
	    	   act.sendKeys(Keys.ARROW_DOWN).perform();
	    	   
	       }
	       act.sendKeys(Keys.ENTER).perform();
	       
	       utilityClassOHRM.explicitWait(driver, minSalary, 3000);
	       minSalary.sendKeys("30000");
	       utilityClassOHRM.explicitWait(driver, maxSalary, 3000);
	       maxSalary.sendKeys("100000");
	       utilityClassOHRM.explicitWait(driver, saveButton2, 3000);
	       saveButton2.click();
	}
	
	public void getTextFromCurrencyBox(WebDriver driver)
	{
		for(WebElement c : currencyBox)
		{
			System.out.print(c.getText());
		}
	}
	
	public void VerifyVisibilityOfcurrencyRecord(WebDriver driver)
	{	
		utilityClassOHRM.explicitWait(driver, currencyRecord, 3000);
		Assert.assertTrue(currencyRecord.isDisplayed(),"Tc Failed as Record not Displayed.");
		Assert.assertEquals("Indian Rupee", currency.getText(),"Tc failed as currency value not matched" );
		Assert.assertEquals("30000.00", min.getText(), "Tc failed as minSalary value not matched");
		Assert.assertEquals("100000.00", max.getText(),"Tc failed as maxSalary value not matched" );
				
	}
	

	
	
}
