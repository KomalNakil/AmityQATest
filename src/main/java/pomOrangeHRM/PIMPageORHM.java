package pomOrangeHRM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilityOrangeHRM.utilityClassOHRM;

public class PIMPageORHM {
	
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div[1]/input") private WebElement empName;
    @FindBy(xpath = "//*[@role='listbox']//*[@role='option']/span") private List<WebElement> listEmpName;
	@FindBy (xpath = "//button[@type='submit']") private WebElement searchButton;
	@FindBy (xpath = "(//*[@class='oxd-table-card'])") private List<WebElement> records;

	
	public PIMPageORHM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public void searchAndVerifyEmpName(WebDriver driver, String text) throws InterruptedException
	{	
		utilityClassOHRM.explicitWait(driver, empName, 3000);
		empName.sendKeys(text);
		utilityClassOHRM.wait(driver, 3000);
		
		for(WebElement e : listEmpName)
		{
			Assert.assertTrue(e.getText().toLowerCase().contains("ch"), "TC Faied as EmpName does not contain ch :"+e.getText());
		}
			
	}
	
	public void clickOnSearchAndVerifyRecords(WebDriver driver) throws InterruptedException
	{
		utilityClassOHRM.explicitWait(driver, searchButton, 3000);
		searchButton.click();
		utilityClassOHRM.wait(driver, 3000);
		for(WebElement r : records)
		{
			Assert.assertTrue(r.getText().toLowerCase().contains("ch"), "TC Faied as EmpName does not contain ch :"+r.getText());
		}
		utilityClassOHRM.wait(driver, 3000);
		
	}

}
