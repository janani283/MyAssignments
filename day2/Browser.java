package week3.day2;

public class Browser {
	
	public String browserName;
	public String browserVersion;
	
	public void openURL() {
		System.out.println("The url is launched");
	}
	
	public void closeBrowser() {
		System.out.println("The browser is closed");
			}
	
	public void navigateBack() {
		System.out.println("The page goes to the previous page");
	}
	

	public static void main(String[] args) {

		
		Browser browser = new Browser();
		browser.openURL();
		browser.navigateBack();
		browser.closeBrowser();
		
	}

}
