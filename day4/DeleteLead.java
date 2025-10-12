package week2.day4;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteLead {

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
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Find Leads")).click();
			
			String FirstLead_id = driver.findElement(By.linkText("10018")).getText();
			System.out.println("The 1st Lead id is : " +FirstLead_id);
			
			driver.findElement(By.linkText("10018")).click();
			driver.findElement(By.linkText("Delete")).click();
			System.out.println("The first lead got deleted");
			
			driver.findElement(By.linkText("Find Leads")).click();
			driver.findElement(By.id("ext-gen246")).sendKeys("10018");
			driver.findElement(By.id("ext-gen334")).click();
			
			//Verify the presence of the message "No records to display" in the Lead List. This 
			//message confirms the successful deletion.
			
			WebElement LastPageText = driver.findElement(By.linkText("//div[@id='ext-gen437']"));
			String message = LastPageText.getText();
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
