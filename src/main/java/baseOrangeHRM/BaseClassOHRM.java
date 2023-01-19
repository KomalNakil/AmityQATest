package baseOrangeHRM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilityOrangeHRM.utilityClassOHRM;

public class BaseClassOHRM {
	protected static WebDriver driver;
	
	public void launchORHM() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", utilityClassOHRM.chromePath);
		driver = new ChromeDriver();
		driver.get(utilityClassOHRM.readPropertyFile(driver,"url"));
		driver.manage().window().maximize();
		utilityClassOHRM.wait(driver, 100);
	}
	
	
	
	public void closeORHM()
	{
		utilityClassOHRM.wait(driver, 100);
		driver.quit();
	}

}
