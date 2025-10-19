package week3.day4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyntraShopping {

	public static void main(String[] args) {
	
		ChromeOptions options=new ChromeOptions();
		options.addArguments("guest");
		
		
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.myntra.com/-");
		System.out.println("URL launched successfully");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@class='index-inputBox']")).sendKeys("bags",Keys.ENTER);
		
		//Selecting the gender from the radio button
		WebElement genderSelect = driver.findElement(By.xpath("((//input[@type='radio'])/parent::label)[1]"));
		genderSelect.click();
		System.out.println("Gender ' Men' clicked succcessfully ");
		
		//Selecting bag category
		WebElement categorySelect = driver.findElement(By.xpath("//label[contains(.,'Laptop Bag(3440)')]"));
		categorySelect.click();
		System.out.println("Category 'Laptop Bags' clicked succcessfully ");
		
		//Print the count of items found
		String bagCount = driver.findElement(By.className("title-count")).getText();
		System.out.println("The number of bags found are : " +bagCount);
		
		//Print the list of brands available
		List<WebElement> brands = driver.findElements(By.className("brand-list"));
		System.out.println("List of the product brands available are:------------------------------");
		
		for(WebElement brandlist:brands) {
			
			System.out.println(brandlist.getText());
		}

		//Print the list of names of bags
		
		List<WebElement> productNames = driver.findElements(By.className("product-product"));
		System.out.println("List of names of bags:-----------------------------------");
		
		for (WebElement bagName : productNames) {
		    System.out.println("- " + bagName.getText());
		}
		

	}

}
