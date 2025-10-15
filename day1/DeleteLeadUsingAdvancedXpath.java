package week3.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteLeadUsingAdvancedXpath {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("guest");
		
		
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		
		//Parent to child xpath
		
		driver.findElement(By.xpath("//p[@class='top']/input")).sendKeys("DemoSalesManager");
		
		//Grandparent to Child xpath
		
		driver.findElement(By.xpath("(//form[@id='login']//input)[2]")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
				
		//driver.findElement(By.xpath("(//form[@id='login']//input)[3]")).click();
		
		//Parent to child xpath
		driver.findElement(By.xpath("//div[@id='button']/a")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("777");
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Find Leads")).click();
		
		//To capture the first lead
		WebElement firstLead = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
  		String leadID = firstLead.getText();
  		System.out.println("First Lead from the resulting table:"+leadID);
  		
  		firstLead.click();
		
		//To delete lead
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
		
		//To find deleted lead
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[7]")).click();
		
		
		//Verify the presence of the message "No records to display" in the Lead List. This 
		//message confirms the successful deletion.
		
		String message = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		System.out.println("message");
		
		if (message.equals("No records to display")) {
		    System.out.println("Lead deleted Successfully");
		} else {
		    System.out.println("Lead still exists");
		}
		
		Thread.sleep(6000);
		
		driver.close();
		
		
		
		
	}

}
