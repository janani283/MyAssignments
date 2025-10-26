package week4.day3;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonActionHome {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("guest");
		
		
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//keyboard Actions - Keys.ENTER
		WebElement keysAct = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		keysAct.sendKeys("oneplus 9 pro",Keys.ENTER);

		
	//	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro",Keys.ENTER);
		
		//To get price of 1st product
		Thread.sleep(3000);
		List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

		for(int i=0;i<list.size();i++)
		{
			if(i==0) {
			String firstProduct = list.get(i).getText();
			System.out.println("The price of first listed Product is : " +firstProduct);
			
			String rating = driver.findElement(By.xpath("(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style']/span)[2]")).getText();
			System.out.println("The no:of customer ratings for the first listed Product is : " +rating);
			
			//To click on first products textlink
			driver.findElement(By.xpath("//a[@class='a-link-normal s-line-clamp-2 s-line-clamp-3-for-col-12 s-link-style a-text-normal']//span")).click();
			
			}
		}
		
		String parentWindowTitle = driver.getTitle();
		System.out.println("The parent window title is : " +parentWindowTitle);
		
		//To get window handles
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("The available window addresses are : " +windowHandles);
		
		//To transfer the driver focus to child window
		List<String> contactsWindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(contactsWindow.get(1));
		Thread.sleep(3000);
		//To print the title of child window
		String childTitle = driver.getTitle();
		Thread.sleep(3000);
		System.out.println("The title of child window is : " +childTitle);
		Thread.sleep(5000);
		
		
		//To take screenshot using action class
		WebElement childKey = driver.findElement(By.xpath("(//span[@class='a-declarative']//img)[2]"));
		File source= childKey.getScreenshotAs(OutputType.FILE);
		File target = new File("./data/Sample2.png");
		FileUtils.copyFile(source, target);
		
		//To add item to cart
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		
		//To check subtotal
		String cartSubTotal = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println("The cart subtotal is : " +cartSubTotal);
		
		
		//To verify the cart subtotal
		
		//if(parseInt(cartSubTotal)==279) {
		//	System.out.println("The cart subTotal is correct!!");
	//	}
		
				
	}

}
