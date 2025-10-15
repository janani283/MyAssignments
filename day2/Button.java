package week3.day2;

public class Button extends WebElement {
	
	public void Submit() {
		
		System.out.println("Submit the button");
	}

	public static void main(String[] args) {
		Button submit = new Button();
		
		submit.Click();
		submit.setText("Welcome!!");
		submit.Submit();
		

	}

}
