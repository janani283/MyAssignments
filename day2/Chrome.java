package week3.day2;

public class Chrome extends Browser {
	
	public void openCognito() {
		System.out.println("The browser opens in cognito mode");
	}
	
	public void clearCache() {
		System.out.println("The cache is cleared");
	}

	public static void main(String[] args) {
		
		Chrome chrome = new Chrome();
		chrome.openCognito();
		chrome.clearCache();
		chrome.openURL();
		chrome.closeBrowser();

	}

}
