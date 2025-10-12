package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		
		ChromeDriver driver = new ChromeDriver(options);
		String url = "http://leaftaps.com/opentaps/";
		driver.get(url);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.id("button")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("Google");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Aathira");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Suganthan");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("Aara");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("QA");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("I am a selenium Tester");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("Aathira@gmail.com");
		
		
		WebElement dropdown1=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select state=new Select(dropdown1);
		state.selectByVisibleText("New York");
		
		driver.findElement(By.className("smallSubmit")).click();
		driver.findElement(By.className("subMenuButton")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("createLeadForm_description")).clear();
		
		driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("Having 6yrs experience.");
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
		String LandingPageTitle= driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
		System.out.println(LandingPageTitle);
		
		Thread.sleep(6000);
		
		driver.close();
		
		

	}

}
