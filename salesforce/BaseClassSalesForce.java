package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClassSalesForce {

	public ChromeDriver driver;
	
	public ChromeOptions options; 
	
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void precondition(String url, String username, String password) throws InterruptedException {
		
		//to handle the chrome notifications
		
		options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--user-data-dir=C:\\Users\\janan\\salesforcecache");

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();
		
		//driver.findElement(By.linkText("Remind Me Later")).click();
		
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement scroll = driver.findElement(By.xpath("//p[text()='Party Consent']"));
		driver.executeScript("arguments[0].scrollIntoView();", scroll);
		WebElement individual = driver.findElement(By.xpath("//p[text()='Individuals']"));
		driver.executeScript("arguments[0].click();", individual);
		Thread.sleep(3000);
	}
	
	@AfterMethod
	
	public void postcondition() {
		driver.close();
		
		
	}
	
}
