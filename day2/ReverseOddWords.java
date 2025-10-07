package week2.day2;

public class ReverseOddWords {

	public static void main(String[] args) {
		
		String test="I am a software tester";
		
		String[] word=test.split(" ");
			

			for(int i=0;i<word.length;i++) {

				if(i%2 != 0) {
					
					String wordtoreverse=word[i];
					System.out.println(wordtoreverse);
					
					
				}
					
				
			}

		}


	

}
