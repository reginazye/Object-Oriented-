import java.util.Arrays;

/** 
 * BubbleSorter class implements the Sorter interface.
 * @author ponbarry
 */
public class BubbleSorter implements Sorter {

	/** 
	 * Constructor
	 */
	public BubbleSorter() { 
		// nothing needs to be done
	}
	
	/**
	 * Uses the bubble sort algorithm to modify the passed-in array
	 * so that its elements are in ascending, sorted order.
	 * Prints out the current state of array each time any two 
	 * elements swap places. 
	 * Assumes that the passed-in array is an array of int elements.
	 */
	public void sortArrayInPlace(int[] array) {
		
		// NEEDS TO BE IMPLEMENTED
		//initiate a storage integer 
		int temp;

		//going through all the pairs of integers
		for(int i=0; i<array.length-1; i++) {
			//always in pairs, therefore one more in index number
			for (int j=1; j<array.length-i; j++) {
				//if the smaller number is in the back
				if (array[j-1] > array[j]){
					//swap the smaller number so it comes first in the array
					temp = array[j-1];
					array[j-1] = array[j];
					array[j]=temp;
				}
			}
			System.out.println("testArray3 (step" + (i+1) +"): " + Arrays.toString(array));
		}
		
	}
	
	


}
