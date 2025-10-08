package week2.day3;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateLead {

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
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("SeniorLead");
		driver.findElement(By.className("smallSubmit")).click();
		String ActualTitle=driver.getTitle();
		System.out.println("Title of current browser: " +ActualTitle);
		
		Thread.sleep(3000);
		
		String expTitle="Create Account | opentaps CRM";
				if(ActualTitle==expTitle) {
					System.out.println("The Lead Created");
				} else {
					System.out.println("Error");
				}
		//driver.close();

		
		
		
		
		
		
	}
}