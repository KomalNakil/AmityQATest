package testOrangeHRM;

import org.testng.annotations.Test;

import baseOrangeHRM.BaseClassOHRM;
import pomOrangeHRM.HomePageORHM;
import pomOrangeHRM.LoginPageORHM;
import pomOrangeHRM.PIMPageORHM;
import utilityOrangeHRM.utilityClassOHRM;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.testng.annotations.AfterClass;

public class TestClassORHM extends BaseClassOHRM{
	
	LoginPageORHM login;
	HomePageORHM home;
	PIMPageORHM pim;
	
	@BeforeClass
	  public void launchORHMApp() throws IOException, InterruptedException {
		launchORHM();
		utilityClassOHRM.wait(driver, 3000);
		login = new LoginPageORHM(driver);
		home = new HomePageORHM(driver);
		pim = new PIMPageORHM(driver);
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
  public void VerifySerchWithPartialText() throws IOException, InterruptedException {
	  home.clickOnPIM(driver);
	  utilityClassOHRM.wait(driver, 500);
	  pim.searchAndVerifyEmpName(driver, "ch");
	  utilityClassOHRM.wait(driver, 3000);
	  pim.clickOnSearchAndVerifyRecords(driver); 
	  utilityClassOHRM.takeScreenShot(driver, "partialTextSearch");
  }
  
  @AfterMethod
  public void logoutORHM() throws InterruptedException {
	  Thread.sleep(500);
	  home.logoutORHM(driver);
  }

  @AfterClass
  public void closeChromeBrowser() {
	 closeORHM();
  }

}
