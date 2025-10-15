package week3.day2;

public class CheckBoxButton extends Button {

	public void ClickCheckButton() {
		
		System.out.println("Check Box is clicked");
	}
	
	
	public static void main(String[] args) {
		CheckBoxButton click = new CheckBoxButton();
		click.Submit();
		click.setText("Hi");
		click.Click();
	}

}
