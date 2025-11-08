package salesforce;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




public class CreateIndividuals extends BaseClassSalesForce {
/*
 * "Test Steps:
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Individuals from App Launcher
4. Click on the Dropdown icon in the Individuals tab
5. Click on New Individual
6. Enter the Last Name as 'Kumar'
7.Click save and verify Individuals Name"

 */
	
	//Dynamic Parameterization.
		@DataProvider(name="LastName")
		public String[][] data() throws IOException{
			return CreateIndiExcel.fetchData();
			
			
		}
		
	@Test(dataProvider="LastName")
	public void CreateIndividual(String LastName) {
		
	WebElement New = driver.findElement(By.xpath("//a[@class='forceActionLink']/div"));
	New.click();
		
	driver.findElement(By.xpath("//input[contains(@class,'lastName compound')]")).sendKeys(LastName);
	driver.findElement(By.xpath("//button[@title='Save']/span")).click();
	String message = driver.findElement(By.xpath("//span[@class='uiOutputText']")).getText();
	System.out.println("The name of individual created is: "+message);
	//verify Individuals Name
	if(message.contains("Mahendran")) {
		System.out.println("The individual name is created correctly!");
	}
}
}
