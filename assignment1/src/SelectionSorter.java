import java.util.Arrays;

/** 
 * SelectionSorter class implements the Sorter interface.
 * @author ponbarry
 */
public class SelectionSorter implements Sorter {

	/** 
	 * Constructor
	 */
	public SelectionSorter() { 
		// nothing needs to be done
	}
	
	/**
	 * Uses the selection sort algorithm to modifies the passed-in 
	 * array so that its elements are in ascending, sorted order.
	 * Prints out the current state of array for each iteration (each 
	 * time the index marking the "sorted" section of the array is updated).
	 * Assumes that the passed-in array is an array of int elements.
	 */
	public void sortArrayInPlace(int[] array) {
		// NEEDS TO BE IMPLEMENTED

		//create the variables
		int i, j, idx, temp;

		//for all the remaining numbers in the array
		for (i=0; i<array.length-1; i++){
			//assume the initial integer is the smallest
			idx = i;
			for (j = i+1; j<array.length; j++){
				//find the new minimun
				if (array[idx] > array[j]) {
					idx = j;
				}
			}
			//if the smallest is not selected as the minimum
			if (idx != i) {
			//swap the minimum
		    temp = array[i];
			array[i]=array[idx];
			array[idx]=temp;
			}
			System.out.println("testArray2 (step" + (i+1) +"): " + Arrays.toString(array));
		}
	}
}
	



