package week4.day3;

import java.time.Duration;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class AutomateUsingAction {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("guest");
		
		
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		System.out.println("URL launched successfully");
		
		
		//getting title of current page
		String homeTitle = driver.getTitle();
		System.out.println("The title of current page is : " +homeTitle);
		
		//scroll to the element
		WebElement scrollToElement = driver.findElement(By.xpath("//a[text()='Conditions of Use & Sale']"));
		
		Actions action = new Actions(driver);
		action.scrollToElement(scrollToElement);
		scrollToElement.click();
		
		
		String conditionTitle = driver.getTitle();
		System.out.println("The condition title is : " +conditionTitle);
		
		if(homeTitle!=conditionTitle) {
			System.out.println("condition of use element clicked successfully");
			
		}
		}
	
	}


