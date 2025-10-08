package week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBookLogin {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		String url="https://www.facebook.com/";
		driver.get(url);
		driver.findElement(By.id("email")).sendKeys("testleaf.2023@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Tuna@321");	
		driver.findElement(By.name("login")).click();
		String Title=driver.getTitle();
		
		System.out.println("Title of my current browser is : " +Title);
		Thread.sleep(3000);
		
		String expTitle="Log in to FaceBook";
		if(Title==expTitle) {
			System.out.println("Browser launched successfully with url:" +url);
		}
		else {
			System.out.println("Login Failed - credential issue");
		}
		
		driver.close();
		
		
		

	}

}
