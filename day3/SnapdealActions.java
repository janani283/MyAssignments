package week4.day3;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapdealActions {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.snapdeal.com/");
		
		//mouseHover or moveToElement.
		WebElement mouseHover = driver.findElement(By.xpath("//span[contains(text(),'Men')]"));
		
		Actions act = new Actions(driver);
		act.moveToElement(mouseHover).perform(); //without .perform(); it will not execute the action.
		
		//To click on sportshoes
		driver.findElement(By.xpath("(//span[contains(text(),'Sports')])[1]")).click();
		
		String countOfShoes = driver.findElement(By.xpath("//div[@class='category-name-wrapper clearfix ']/span")).getText();
		System.out.println("The count of men's sports shoes is : " +countOfShoes);
		
		//moveTo Training shoes
		
		WebElement trainingShoes = driver.findElement(By.xpath("(//a[@class='child-cat-node dp-widget-link hashAdded'])[3]"));
		act.moveToElement(trainingShoes).perform();
		trainingShoes.click();
		
		//To click sort by
		
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		
		
		//sort by low to high
	driver.findElement(By.xpath("//li[@class='search-li']")).click();
		//act.moveToElement(popularity).perform();
		//popularity.click();
		
		//7. Check if the list of displayed shoes are sorted correctly as per price.
		
		Thread.sleep(3000);
		List<WebElement> list = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		
		System.out.println("The size of Shoe List is: " +list.size());

		//System.out.println("The training shoes pricelist is below : ");
	
		//for(int i=0;i<list.size();i++)
		//{
		//	String shoeList = list.get(i).getText();
		//	System.out.println(shoeList);
	//	}
		
//To check if shoes are sorted as low to high (ascending)
			
		//List<WebElement> actualPrices = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		boolean isSortedCorrectly = true;
		System.out.println("Checking " + list.size() + " prices for Low-to-High sort...");

		for (int i = 0; i < list.size() - 1; i++) {

			String currentPrice = list.get(i).getText();
			String nextPrice = list.get(i + 1).getText();
			
			currentPrice = currentPrice.replaceAll("[Rrs. ,]", "");
			nextPrice = nextPrice.replaceAll("[Rrs. ,]", "");
			
			Double currentPricedouble = Double.parseDouble(currentPrice);
			Double nextPricedouble = Double.parseDouble(nextPrice);
			// If the current price is greater than the next price, the list is NOT sorted
			if (currentPricedouble > nextPricedouble) {
				isSortedCorrectly = false;
				System.out.println("Sorting not done");
				break;
			} 
			
		}
		if(isSortedCorrectly==true) {
			System.out.println("Sorted correctly as price Low to High");
		}
		
		Thread.sleep(3000);
		
		//step 8 : fix price range
		//shoe filter - by cost with from cost 
				driver.findElement(By.name("fromVal")).clear();
				driver.findElement(By.name("fromVal")).sendKeys("500");
				
				//shoe filter - by cost with to cost
				driver.findElement(By.name("toVal")).clear();
				driver.findElement(By.name("toVal")).sendKeys("700");
				
				//apply filter 
				driver.findElement(By.xpath("//div[normalize-space()='GO']")).click();
				
				Thread.sleep(1000);
				
		//step 9 : filter with color
				
				WebElement colorFilter = driver.findElement(By.xpath("//label[@for='Color_s-White%20%26%20Blue']"));
				act.scrollToElement(colorFilter).perform();
				Thread.sleep(3000);
				colorFilter.click();
				
		//step 10 : Verify all the applied filters
				
				Thread.sleep(2000);
				
				List<WebElement> shoes = driver.findElements(By.xpath("//p[@class='product-title']"));
				
				for(int i=0; i<shoes.size();i++) {
					String shoeDetails = shoes.get(i).getText().toLowerCase();
					
					if((shoeDetails.contains("white")) || (shoeDetails.contains("blue")))
					{
						
						System.out.println("Color filter applied successfully!!");
					}			
				}
				
				List<WebElement> shoePrice = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
								
				for(int i=0; i<shoePrice.size();i++) {
					
					String priceRange = shoePrice.get(i).getText().replaceAll("[Rs.  ]", "");
					
					Double priceRangedouble = Double.parseDouble(priceRange);
					
					if(priceRangedouble>=500 && priceRangedouble<=700) {
						
						System.out.println("PriceRange filter applied successfully!!");

						
					}

				}
					
		//Step 11 : Mouse hover on first resulting training shoes	
				
				WebElement FirsttrainingShoes = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
				act.moveToElement(FirsttrainingShoes).perform();
				
				driver.findElement(By.xpath("//div[@class='center quick-view-bar  btn btn-theme-secondary  ']")).click();
				
				//price and discount
				String price=driver.findElement(By.xpath("//div[@class='lfloat marR10']/span[2]")).getText();
				System.out.println("The price of the shoe: "+price);
				String discount=driver.findElement(By.xpath("//div[@class='product-discount']/span")).getText();
				System.out.println("The Discount for the shoe is: "+discount);


		//Step 12 : Take screenshot of shoes
				
				Thread.sleep(1000);
				File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				File destFile = new File("./screenshots/myShoe.png");
				FileUtils.copyFile(srcFile, destFile);
				System.out.println("My first shoe purchased successfullt");
				
				driver.quit();
					
				
		
	}

}

