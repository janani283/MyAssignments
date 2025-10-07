package week2.day2;

public class OddIndexToUpper {

	public static void main(String[] args) {
		String test="changeme";
		char[] name=test.toCharArray();
		
		for(int i=0;i<name.length;i++) {
			
			//System.out.print(name[i]);
			
			if(i%2!=0) {
				
				char upperChar = Character.toUpperCase(name[i]);
                System.out.print(upperChar);
            				} 
			else {
                
                System.out.print(name[i]);
            }
		}
		
		

	}

}
