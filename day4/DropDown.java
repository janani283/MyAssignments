package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		//to handle the chrome notifications
				ChromeOptions options=new ChromeOptions();
				options.addArguments("guest");
				
				
				ChromeDriver driver=new ChromeDriver(options);
				driver.get("http://leaftaps.com/opentaps/");
				driver.manage().window().maximize();
				driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
				driver.findElement(By.id("password")).sendKeys("crmsfa");
				driver.findElement(By.className("decorativeSubmit")).click();
				driver.findElement(By.id("button")).click();
				driver.findElement(By.linkText("Create Lead")).click();
				driver.findElement(By.id("createLeadForm_companyName")).sendKeys("QEAGLE");
				driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Janani");
				driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("Mahendran");
				
				WebElement tools=driver.findElement(By.id("createLeadForm_dataSourceId"));
				Select option1=new Select(tools);
				option1.selectByIndex(5);
				
				WebElement Marketing=driver.findElement(By.id("createLeadForm_marketingCampaignId"));
				Select campaign=new Select(Marketing);
				campaign.selectByVisibleText("Automobile");
				
				WebElement ownership=driver.findElement(By.id("createLeadForm_ownershipEnumId"));
				Select owner=new Select(ownership);
				owner.selectByValue("OWN_CCORP");
				
				driver.findElement(By.className("smallSubmit")).click();
				
				System.out.println(driver.getTitle());
				Thread.sleep(6000);
				driver.close();
				
						
					
				
				
				
	}

}
