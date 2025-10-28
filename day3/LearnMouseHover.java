package week4.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnMouseHover {

	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.snapdeal.com/");
		
		//mouseHover or moveToElement.
		WebElement mouseHover = driver.findElement(By.xpath("//span[contains(text(),'Men')]"));
		
		Actions act = new Actions(driver);
		act.moveToElement(mouseHover).perform(); //without .perform(); it will not execute the action.
		
		Thread.sleep(3000);
		//scrollToElement - //div[text()='Policy Info']
		WebElement scrollTo = driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-search search-Icon grey-bbb'])[5]"));
		
		act.scrollToElement(scrollTo).perform();
			
	

	}

}
