public class BinarySearch
{
	
	/** 
	 * Searches the sorted array for the test number between loIndex and hiIndex, inclusive. 
	 * If test is found, returns its index; otherwise, returns -1.
	 **/
	private static int binarySearch( int[] sorted, int test, int loIndex, int hiIndex )
	{
		// base case 
		if ( hiIndex < loIndex )
			// we didn't find it!
			return -1;
		// recursive case
		else
		{
			// find the middle index
			int mid = (hiIndex + loIndex)/2; // okay to truncate (round down)
			
			// check if the mid point is actually the value we want
			if ( test == sorted[mid] )
				// we found it!
				return mid;
			// otherwise, check if the test is lower than mid
			else if ( test < sorted[mid] )
				// recursively search the lower half by keeping the loIndex
				// but setting hiIndex to be mid-1
				return binarySearch( sorted, test, loIndex, mid-1 );
			// otherwise, test could only be in the upper half
			else
				// recursively search the upper half by keeping the hiIndex
				// but setting loIndex to be mid+1
				return binarySearch( sorted, test, mid+1, hiIndex );
		}
	}

	/** 
	 * Searches the sorted array for the test object between loIndex and hiIndex, inclusive. If test is found, returns its index; otherwise, returns -1.
	 **/
	public static int binarySearch( int[] sorted, int test )
	{
		// start the recursion between first and last indices
		return binarySearch( sorted, test, 0, sorted.length -1 );
	}

}
	
//	/**
//	 * Create array with first numOdds odd numbers.
//	 **/
//	public static int[] createOddsArray( int numOdds ) 
//	{
//		// array for odd numbers in order
//		int[] odds = new int[numOdds];
//		
//		// current odd number
//		int currentOdd = 1;
//		
//		// fill with odd numbers in order
//		for ( int i = 0; i < odds.length; i++ )
//		{
//			// put in current odd number
//			odds[i] = currentOdd;
//			
//			// update to next odd
//			currentOdd += 2;
//		}
//		
//		return odds;
//	}
//	
//	/**
//	 * Test with an array of the first 100 odd numbers.
//	 **/
//	public static void oddTester()
//	{
//		// first 100 odd numbers
//		int[] odds100 = createOddsArray( 100 );
//		
//		// tester
//		int[] testerOdds = {26, 78 ,100, 186, 13, 99, 101, 177};
//		
//		// check for each tester value
//		for ( int i = 0; i < testerOdds.length; i++ )
//		{
//			System.out.println( "searching for " + testerOdds[i] + 
//				": " + binarySearch( odds100, testerOdds[i] ) );
//		}
//	}
//	
//	/**
//	 * Test binary search with first 100 odds.
//	 **/
//	public static void main( String[] args )
//	{
//		oddTester();
//		
//	}
//}