package week3.day2;

public class RadioButton extends Button {
	
	public void SelectRadioButton() {
		
		System.out.println("RadioButton selected");
	}

	public static void main(String[] args) {
		
		RadioButton radio = new RadioButton();
		radio.SelectRadioButton();
		radio.Submit();
		radio.Click();
		radio.setText("Hello");
		

	}

}
