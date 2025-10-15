package week3.day2;

public class MethodOverloading {
	
	public void reportStep(String msg, String status) {
		
		System.out.println(msg +" "+status);
		
	}

	public void reportStep(String msg, String status, boolean snapshot) {
		
		System.out.println(msg+" "+status+" "+snapshot);
		
	}
	public static void main(String[] args) {
		
		MethodOverloading call = new MethodOverloading();
		
		call.reportStep("Browser Launching", "Ready");
		
		call.reportStep("Browser", "Not Ready" , false);
		
	}

}
