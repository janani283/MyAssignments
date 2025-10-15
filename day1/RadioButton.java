package week3.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.messages.types.Duration;

public class RadioButton {

	public static void main(String[] args) {
		
		//Instantiate and launch the browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--guest");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.leafground.com/radio.xhtml");
		
		//Add the implicit wait
		
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));

		driver.manage().window().maximize();
		
		//Selecting the favorite browser from the radio button
		WebElement chromeSelect = driver.findElement(By.xpath("//label[text()='Chrome']"));
		chromeSelect.click();
		
		//Click again and confirm if the button is unselected
		chromeSelect.click();
		boolean isSelected = chromeSelect.isSelected();
		System.out.println("Chrome button is Enabled:"+isSelected);
		
		//Identify the radio button that is selected by default
		List <WebElement> radioButtons = driver.findElements(By.name("j_idt87:console2"));
		for(int i=0;i<radioButtons.size();i++) {
			
			WebElement radio = radioButtons.get(i);
			boolean selected = radio.isSelected();
			System.out.println("Option  Selected :"+i);
			System.out.println(selected);
			
		}
		

		//To locate radio button of age group 21-40 in browser
		WebElement ageGroup = driver.findElement(By.xpath("//label[text()='21-40 Years']/preceding-sibling::div[contains(@class,'ui-radiobutton ui-widget')]"));
		
		//To check which age group button is selected
		WebElement ageGroupDiv = ageGroup.findElement(By.tagName("div"));

        if (!ageGroupDiv.getDomAttribute("class").contains("ui-state-active")) {
        	ageGroup.click();
            System.out.println("21-40 Years age group was not selected. Now selected.");
        } else {
            System.out.println("21-40 Years age group is already selected.");
        }


	}

}
