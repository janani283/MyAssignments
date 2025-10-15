package week3.day2;

public class LoginTestData extends TestData {
	
	public void EnterUserName() {
		
		System.out.println("Enter valid Username");
		
	}
	
	public void EnterPassword() {
		
		System.out.println("Enter valid Password");
		
	}

	public static void main(String[] args) {
		
		LoginTestData data = new LoginTestData();
		data.enterCredentials();
		data.navigateToHomePage();
		data.EnterUserName();
		data.EnterPassword();
		
		

	}

}
