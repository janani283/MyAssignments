package week3.day4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingElements {

	public static void main(String[] args) {
		
		int[] a = {1, 2, 3, 4, 10, 6, 8};
		
	//created arraylist	
		List<Integer> list = new ArrayList<Integer>();
		
	//Added array to a list	
for (int num:a) {
			
			list.add(num);
		}
		
System.out.println("The List before sorting : " +list);

Collections.sort(list);

System.out.println("The List after sorting : " +list);

//Get the range boundaries from the sorted list
int min = list.get(0);              // The smallest number (1)
int max = list.get(list.size() - 1); // The largest number (10)

System.out.println("Missing numbers between the range : " + min + " to " + max + " is below:");

// Create a list to store the missing numbers
List<Integer> missingNumbers = new ArrayList<Integer>();

// Iterate through the entire EXPECTED range (from min to max)
for (int i = min; i <= max; i++) {
    
    // Check if the current number 'i' is NOT present in the list
    if (!list.contains(i)) {
        
        // If it's not present, it is a missing element
        missingNumbers.add(i);
    }
}

// Print the results
if (missingNumbers.isEmpty()) {
    System.out.println("No missing elements found in the sequence.");
} else {
    System.out.println("The missing elements are : " + missingNumbers);
}
	}

}
