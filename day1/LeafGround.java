package week3.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LeafGround {

			
		public static void main(String[] args) throws InterruptedException {
			
			ChromeOptions options=new ChromeOptions();
			options.addArguments("guest");
			
			
			ChromeDriver driver=new ChromeDriver(options);
			String url = "https://leafground.com/button.xhtml";
			driver.get(url);
			driver.manage().window().maximize();
			
			//parent to child xpath
			driver.findElement(By.xpath("//button[@name='j_idt88:j_idt90']/span")).click();
			
			//Verify the Title of WebPage
			
			String pageTitle = driver.getTitle();
			
			if (pageTitle.equals("Dashboard")) {
			
				System.out.println("Page Title verified as:"+pageTitle);
			}
			
			//To navigate to previous page
			driver.navigate().back();
			
			//Verify if the Confirm button isDisabled() - 
			
			boolean isEnabled = driver.findElement(By.xpath("//span[text()='Disabled']/parent::button")).isEnabled();
			System.out.println("The button is Enabled : "+isEnabled);
			
			
			//Find the position of the button with text submit
			
			WebElement submitButtonPosition = driver.findElement(By.xpath("//span[text()='Submit']/parent::button"));
			System.out.println("The position of the button submit is : " +submitButtonPosition.getLocation());
			
			
			//Find the color of the save button
			WebElement saveButtoncolor = driver.findElement(By.xpath("//span[contains(text(),'Save')]/parent::button"));
			System.out.println("The background color of SAVE button is : " +saveButtoncolor.getCssValue("background-color"));
			
			//Find the height and width of the save button
			
			WebElement saveButton = driver.findElement(By.xpath("//span[contains(text(),'Save')]/parent::button"));
			int height = saveButton.getSize().getHeight();
			int width = saveButton.getSize().getWidth();
			
			System.out.println("The height of the save button:"+height);
			
			System.out.println("The width of the save button:"+width);
			
			
			//driver.close();
			
			Thread.sleep(3000);

	}

}
