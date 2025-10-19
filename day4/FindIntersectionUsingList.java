package week3.day4;

import java.util.ArrayList;
import java.util.List;

public class FindIntersectionUsingList {

	public static void main(String[] args) {
		
		int[] a={3,2,11,4,6,7};
		
		int[] b={1,2,8,4,9,7};

		List<Integer> commonList = new ArrayList<Integer>();
		
		for(int i=0; i<a.length;i++) {
			
			for(int j=0;j<b.length;j++) {
				
				if(a[i]==b[j]) {
					commonList.add(a[i]);
					
				}
				
			}
		}
		
		System.out.println("Intersection of both the array is : " + commonList);		
			
	}

}
