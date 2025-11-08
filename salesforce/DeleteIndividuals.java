package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class DeleteIndividuals extends BaseClassSalesForce {

	@Test(dependsOnMethods= {"salesforce.CreateIndividuals.CreateIndividual","salesforce.EditIndividuals.EditIndividual"})
	public void DeleteIndividual() throws InterruptedException {
		/*
		 * "Test Steps:
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Individuals from App Launcher
4. Click on the Individuals tab 
5. Search the Individuals 'Kumar'
6. Click on the Dropdown icon and Select Delete
7.Click on the Delete option in the displayed popup window.
8. Verify Whether Individual is Deleted using Individual last name"

		 */
		
	//-----	Delete button clicking-------------------
		
		WebElement dropdown = driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon-border slds-button_icon-x-small']"));
		driver.executeScript("arguments[0].click();", dropdown);
		Thread.sleep(3000);
		

		WebElement delete = driver.findElement(By.xpath("(//a[@class='highlightButton']/div)[2]"));
		driver.executeScript("arguments[0].click();", delete);
		Thread.sleep(3000);
		
		//-----to confirm delete----------------
		WebElement delete2 = driver.findElement(By.xpath("//button[@title='Delete']/span"));
		driver.executeScript("arguments[0].click();", delete2);
		Thread.sleep(2000);
			
	
		String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		 System.out.println(msg);
			
				
		if(msg.contains("deleted")) {
			System.out.println("The individual is deleted");
		}
	}

}
