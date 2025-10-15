package week3.day2;

public class TextField extends WebElement {

	public void getText() {
		
		System.out.println("This is the Text");
	}
	
	
	public static void main(String[] args) {
		
		TextField text = new TextField();
		
		text.setText("This is TextField class");
		text.Click();
		text.getText();
		
		
	}

}
