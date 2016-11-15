import java.util.Arrays;

/**
 * Binary Search
 * 
 * @author ReginaYe
 * 
 **/

public class BinarySearch {
	/**
	 * create a search method that shows if an integer is in an array if the
	 * integer is part of the array, return the index, if not, return -1
	 **/
	public static int binarySearch(int[] sorted, int test) {
		// check if the integer is part of the array, then return the index
		for (int n = 0; n < sorted.length; n++) {
			if (sorted[n] == test) {
				return n;
			}
		}
		// if the test integer is not in the array, return -1
		return -1;
	}

	/**
	 * How to do binary search using recursion If the test integer is equal to
	 * the lower index or the higher index, or equal to the mean value, return
	 * the index,
	 * 
	 * 
	 **/
	private static int binarySearch(int[] sorted, int test, int loIndex, int hiIndex) {
		// see if the test integer is equal to the lower index
		if (sorted[loIndex] == test) {
			return loIndex;
		}
		// see if the test integer is equal to the higher index
		if (sorted[hiIndex] == test) {
			return hiIndex;
		}
		/**
		 * compare the test integer to the mean value of the array if the test
		 * integer is greater than the test array, then only search the greater
		 * half, vice versa
		 */
		if (test > (int) Math.ceil(sorted[loIndex + hiIndex] / 2)) {
			// change the lower bound to the mean value
			loIndex = (int) Math.ceil(sorted[loIndex + hiIndex] / 2);
		}
		if (test < (int) Math.ceil(sorted[loIndex + hiIndex] / 2)) {
			/// change the upper bound to the mean value
			hiIndex = (int) Math.ceil(sorted[loIndex + hiIndex] / 2);
		}
		// now search the shortened array
		sorted = Arrays.copyOfRange(sorted, loIndex, hiIndex);
		// return the index or -1
		return binarySearch(sorted, test);
	}

	/**
	 * start an array of the first 100 odd integers
	 */
	private static void oddTester() {
		int[] intArray = new int[100];
		for (int num = 1; num < 200; num += 2) {
			intArray[num / 2] = num;
		}
		/**
		 * start another array of the test integers
		 */
		int[] testArray = new int[] { 26, 78, 100, 186, 13, 99, 101, 177 };
		/**
		 * test if the answer is in the array of 100 odd integers 
		 */
		for (int idx = 0; idx < testArray.length; idx++) {
			int answer = binarySearch(intArray, testArray[idx]);
			System.out.println("searching for " + testArray[idx] + ": " + answer);
		}

	}

	/**
	 * call oddTester
	 * @param args
	 */
	public static void main(String[] args) {
		oddTester();
	}

}
