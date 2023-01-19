package testOrangeHRM;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseOrangeHRM.BaseClassOHRM;
import pomOrangeHRM.AdminPageOHRM;
import pomOrangeHRM.HomePageORHM;
import pomOrangeHRM.LoginPageORHM;
import utilityOrangeHRM.utilityClassOHRM;

public class TestClass2ORHM extends BaseClassOHRM{
 
	
	LoginPageORHM login;
	HomePageORHM home;
	AdminPageOHRM admin;
	
	@BeforeClass
	  public void launchORHMApp() throws IOException, InterruptedException {
		launchORHM();
		Thread.sleep(500);
		login = new LoginPageORHM(driver);
		home = new HomePageORHM(driver);
		admin = new AdminPageOHRM(driver);
		utilityClassOHRM.wait(driver, 200);
	  }
	@BeforeMethod
	  public void loginToORHM() throws IOException {
		utilityClassOHRM.wait(driver, 1000);
		login.enterUserName(driver);
		login.enterPassword(driver);
		login.clickOnLoginButton(driver);
		utilityClassOHRM.wait(driver, 500);
	  }

  @Test
  public void VerifyAddPayGrades() throws InterruptedException, IOException
  {
//	  home.clickOnAdmin(driver);
//	  utilityClassOHRM.wait(driver, 500);
//	  admin.addCurrency(driver);
//	  admin.getTextFromCurrencyBox(driver);
//	  admin.VerifyVisibilityOfcurrencyRecord(driver);	
//	  utilityClassOHRM.takeScreenShot(driver, "cRecord");
	  //-----
	  home.clickOnAdmin(driver);
	  utilityClassOHRM.wait(driver, 500);
	  admin.addCurrency(driver);
	  admin.getTextFromCurrencyBox(driver);
	  Assert.assertTrue(admin.getStatusOfCurrencyRecord(driver),"Tc Failed as Record not Displayed.");
	  Assert.assertEquals("Indian Rupee", admin.getTextFromCurrency(driver),"Tc failed as currency value not matched" );
	  Assert.assertEquals("30000.00",admin.getTextFromMinSallary(driver), "Tc failed as minSalary value not matched");
	  Assert.assertEquals("100000.00", admin.getTextFromMaxSallary(driver),"Tc failed as maxSalary value not matched" );
	  utilityClassOHRM.takeScreenShot(driver, "cRecord");
	 
	 
  }

  @AfterMethod
  public void logoutORHM() throws InterruptedException {
	  utilityClassOHRM.wait(driver, 3000);
	  home.logoutORHM(driver);
  }

  

  @AfterClass
  public void closeChromeBrowser() {
	 closeORHM();
  }

}
