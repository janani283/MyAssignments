package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountWithSelect {

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
			driver.findElement(By.linkText("Accounts")).click();
			driver.findElement(By.linkText("Create Account")).click();
			
			String accountname="Aathiraa";
			driver.findElement(By.id("accountName")).sendKeys(accountname);
			
		
			driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
			
			//creating a webelement and passing it as argument by instantiating the select class
			WebElement dropdown1=driver.findElement(By.name("industryEnumId"));
			Select industry=new Select(dropdown1);
			industry.selectByVisibleText("Computer Software");
			
			WebElement dropdown2=driver.findElement(By.name("ownershipEnumId"));
			Select ownership=new Select(dropdown2);
			ownership.selectByVisibleText("S-Corporation");
			
			
			WebElement dropdown3=driver.findElement(By.name("dataSourceId"));
			Select source=new Select(dropdown3);
			source.selectByValue("LEAD_EMPLOYEE");
			
			WebElement dropdown4=driver.findElement(By.id("marketingCampaignId"));
			Select marketing=new Select(dropdown4);
			marketing.selectByIndex(6);
			
			WebElement dropdown5=driver.findElement(By.id("generalStateProvinceGeoId"));
			Select state=new Select(dropdown5);
			state.selectByValue("TX");
			
			driver.findElement(By.className("smallSubmit")).click();

			Thread.sleep(6000);
			
			String AccName= driver.findElement(By.xpath("(//span[@class='tabletext'])[3]")).getText();
			System.out.println(AccName);
			if(AccName.contains(accountname)) {
				System.out.println("Account name matches");
			} else {
				System.out.println("Account creation failed");
			}
			
			//driver.close();
			
			
			
			
			
			
			
			
	}

}
