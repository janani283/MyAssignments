package week4.day3;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnKeyBoardAct {

	public static void main(String[] args) throws IOException, InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.snapdeal.com/");
		
		//keyboard Actions - Keys.ENTER
		WebElement keysAct = driver.findElement(By.id("inputValEnter"));
		keysAct.sendKeys("laptop");
		
		
		//keyboard Actions - 
		//To take the screenshot of current.
		//driver.getScreenshotAs();
		//To get the screenshot of webelement action.
		Thread.sleep(5000);
		File screenshortAs= keysAct.getScreenshotAs(OutputType.FILE);
		File target = new File("./data/Sample1.png");
		FileUtils.copyFile(screenshortAs, target);
		
		
	}

}
