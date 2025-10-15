package week3.day2;

public class TestData {
	
	public void enterCredentials() {
		
		System.out.println("Enter valid credentials");
	}

	public void navigateToHomePage() {
		
		System.out.println("Navigate back to HomePage");

		
	}
		
	public static void main(String[] args) {
		
		TestData credentials = new TestData();
		
		credentials.enterCredentials();
		credentials.navigateToHomePage();

	}

}
