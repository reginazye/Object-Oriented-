import java.util.Arrays;

/** 
 * InsertionSorter class implements the Sorter interface.
 * @author Regina Ye
 */
public class InsertionSorter implements Sorter {

	/** 
	 * Constructor
	 */
	public InsertionSorter() { 
		// nothing needs to be done
	}
	
	/**
	 * Uses the insertion sort algorithm to modify the passed-in array
	 * so that its elements are in ascending, sorted order.
	 * Prints out the current state of array for each iteration (each 
	 * time the index marking the "sorted" section of the array is updated). 
	 * Assumes that the passed-in array is an array of int elements.
	 */
	public void sortArrayInPlace(int[] array) {
		
		// NEEDS TO BE IMPLEMENTED

		//going through the whole array
		for (int j= 1; j<array.length; j++)	{
			//select one integer
			int key = array[j];
			//initiate the comparison integer
			int i= j-1;

			//if the selected integer is smaller than neighbour,
			while (i>=0 && array[i]>key){
				//push back the bigger integer
				array[i+1]=array[i];
				i--;
			}
			//now insert the selected 
			array[i+1]=key;
			System.out.println("testArray1: " + Arrays.toString(array));
		}

	}
	
	

}
