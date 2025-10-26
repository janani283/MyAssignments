package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FinanceYahoo {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://finance.yahoo.com/?guccounter=1");
		driver.findElement(By.xpath("//div[text()='Markets']")).click();
		driver.findElement(By.xpath("(//span[text()='Crypto'])[3]")).click();
		
			
		// getting all rows
		List<WebElement> getAllRows = driver.findElements(By.xpath("//table[@class='yf-1onk3zf bd']//tbody/tr"));
		System.out.println("Number of rows in table : " + getAllRows.size());
		
		//To iterate to print 2nd column text of all rows
		for (int i = 1; i < getAllRows.size(); i++) {

		WebElement getCurrentCol = driver.findElement(By.xpath("//table[@class='yf-1onk3zf bd']//tbody/tr[" + i + "]/td[2]"));
		String CurrencyName = getCurrentCol.getText();
		System.out.println("Row :" + i + "|" + " Crypto Currency Name is: " + CurrencyName);
		}

		//driver.quit();
		
		
		
	}

}
