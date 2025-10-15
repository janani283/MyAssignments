package week3.day3homeassignments;

import java.util.Arrays;

public class FindMissingElement {

	public static void main(String[] args) {

		int[] arr =  {1, 4,3,2,8,6,7};
		
		Arrays.sort(arr);
		
		for(int i=1 ; i<arr.length;i++) {
			
					
			if(arr[i] != arr[i-1]+1) {
				
				int missingnumber = arr[i-1]+1;
			System.out.println("The missing number is : " +missingnumber);
			break;
			
			}
		}
	}

}
