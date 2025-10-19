package week3.day4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindingSecondLargestNumberinList {

	public static void main(String[] args) {
		
		int[] a = {3, 2, 11, 4, 6, 7};
		
		List<Integer> list = new ArrayList<Integer>();
		
		for (int num:a) {
			
			list.add(num);
		}
			
		Collections.sort(list);
		
		System.out.println("The sorted list is : " +list);
		
		System.out.println("The size of list is " +list.size( ));
		

		System.out.println("The second largest number in list is : " +list.get(list.size() - 2));

	}

}
