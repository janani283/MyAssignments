package salesforce;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class EditIndividuals extends BaseClassSalesForce{

	//Dynamic Parameterization.
			@DataProvider(name="FirstName")
			public String[][] data() throws IOException{
				return EditIndiExcel.fetchData();
				
				
			}
			
		@Test(dataProvider="FirstName", dependsOnMethods= {"salesforce.CreateIndividuals.CreateIndividual"})
public void EditIndividual(String FirstName) throws InterruptedException {
		/*
		 * "Test Steps:
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Individuals from App Launcher 
4. Click on the Individuals tab 
5. Search the Individuals 'Kumar'
6. Click on the Dropdown icon and Select Edit
7.Select Salutation as 'Mr'
8.Enter the first name as 'Ganesh'.
9. Click on Save and Verify the first name as 'Ganesh'"

		 */

		//----------------To edit-------------------------------------------------------
		WebElement edit = driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon-border slds-button_icon-x-small']"));
		driver.executeScript("arguments[0].click();", edit);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[@class='highlightButton']")).click();
		driver.findElement(By.xpath("//a[@class='select']")).click();
		driver.findElement(By.xpath("//a[text()='Mrs.']")).click();
		driver.findElement(By.xpath("//input[@class='firstName compoundBorderBottom form-element__row input']")).sendKeys(FirstName);
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		Thread.sleep(3000);
		
		String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		System.out.println("The edited individual is: " +msg);
	   //Verify the first name as 'Ganesh'
	}

}

