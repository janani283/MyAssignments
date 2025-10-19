package week3.day4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class Amazon {

	public static void main(String[] args) {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("guest");
		
		
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Phones",Keys.ENTER);
		List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

		for(int i=0;i<list.size();i++)
		{
			String phonelist = list.get(i).getText();
			System.out.println(phonelist);
		}
		int size = list.size();
		System.out.println("The size of List: " +size);
		}
		
		
	
}


