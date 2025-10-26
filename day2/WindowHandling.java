package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandling {

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
				driver.findElement(By.xpath("//div[@id='label']/a")).click();
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();
				driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
				
				//from widget click
				driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();
				Thread.sleep(3000);
				//To print address of the browsers
				Set<String> allWindows = driver.getWindowHandles();
				System.out.println("The available window addresses are : " +allWindows);
				
				//To transfer the driver focus to child window
				List<String> contactsWindow = new ArrayList<String>(allWindows);
				driver.switchTo().window(contactsWindow.get(1));
				
				//To print the title of child window
				String childTitle = driver.getTitle();
				System.out.println("The title of child window is : " +childTitle);
				
				Thread.sleep(3000);
				
				//To select first entry from child window
				driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody/tr/td/div/a")).click();
				
								
				//transfer the driverfocus from child window to parent window.
				
				driver.switchTo().window(contactsWindow.get(0));
				
				System.out.println("Returned to parent window and title is : " +driver.getTitle());
				Thread.sleep(3000);
				//To widget click
				//problem with step 58, not executing
				driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
				Thread.sleep(2000);
				
				//create new variable for handling child window again
				Set<String> allWindows1 = driver.getWindowHandles();
				List<String> contactsWindow2 = new ArrayList<String>(allWindows1);


				
				//To transfer the driver focus to child window again
				driver.switchTo().window(contactsWindow2.get(1));
				Thread.sleep(3000);
				System.out.println("Again transferred to child window and title is : " +driver.getTitle());
				
				//To select 2nd entry from child window
				driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']/tbody/tr/td/div/a)[5]")).click(); 

				//transfer the driverfocus from child window to parent window.
				
				driver.switchTo().window(contactsWindow.get(0));
				
				System.out.println("Returned to parent window and title is : " +driver.getTitle());
				Thread.sleep(3000);
				
				//To click merger button
				driver.findElement(By.xpath("//a[text()='Merge']")).click();
				
				Alert alert1 = driver.switchTo().alert();
				alert1.accept();
				
				String finalPageTitle = driver.getTitle();
				System.out.println("The final Title is : " +finalPageTitle);
				
				if(finalPageTitle.contains("CRM")) {
					System.out.println("The title is verified : " +finalPageTitle);
				}
				
				
	}
}			
				
				
				