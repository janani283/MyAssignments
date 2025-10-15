package week3.day2;

public class HomePageTestData extends LoginTestData {
	
	public void Navigate() {
		
		System.out.println("Click BACK button to go to HomePage");
		
	}

	public static void main(String[] args) {
		
		HomePageTestData home = new HomePageTestData();
		home.EnterUserName();
		home.EnterPassword();
		home.enterCredentials();
		home.navigateToHomePage();
		home.Navigate();
		
		
	
		
	}

}
