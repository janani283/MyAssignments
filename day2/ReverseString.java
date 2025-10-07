package week2.day2;

public class ReverseString {

	public static void main(String[] args) {
		String companyName="TestLeaf";
		char[] name=companyName.toCharArray();
		
		
		for(int i=name.length-1;i>=0;i--) {
//		for(int i=name.length-8;i<=7;i++) {

			System.out.print(name[i]);
	}
		
}
}