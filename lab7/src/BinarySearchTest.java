import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.Test;

public class BinarySearchTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	/** default number of odds to test on **/
	public static int NUM_ODDS = 100;
	public static int NUM_MIXED = 14;
 
	// testing arrays
	private int[] odds;
	private int[] mixed;
 
	@Before
	public void initOddsArray() 
	{
		odds = createOddsArray( NUM_ODDS );
	}
 
	@Before
	public void initMixedArray() 
	{
		mixed = createMixedArray(NUM_MIXED);
	}
 
	/**
	 * Create array with first numOdds odd numbers.
	 **/
	public static int[] createOddsArray( int numOdds )
	{
		// array for odd numbers in order
		int[] oddsArray = new int[numOdds];
 
		// current odd number
		int currentOdd = 1;
 
		// fill with odd numbers in order
		for ( int i = 0; i < oddsArray.length; i++ )
		{
			// put in current odd number
			oddsArray[i] = currentOdd;
 
			// update to next odd
			currentOdd += 2;
		}		
 
		return oddsArray;
	}
	
	public static int[] createMixedArray( int numMixed )
	{
			int[] mixedArray = new int[numMixed];
		 
				int currentMix = -10;
		 
				for ( int i = 0; i < mixedArray.length; i++ )
				{
					mixedArray[i] = currentMix;
					currentMix += 3;
				}					
				return mixedArray;		
	}	
 


	@Test
	public void test26()
	{
		// check searching for 26
		assertEquals("Searching for 26 in an array of the first 100 odds should give -1", 
				-1, // correct answer
				BinarySearch.binarySearch(odds, 26)); 	
	}
 
	@Test
	public void test13()
	{
		// check searching for 13
		assertEquals("Searching for 13 in an array of the first 100 odds should give 6", 
				6, // correct answer
				BinarySearch.binarySearch(odds, 13)); 	
	}
	
	@Test
	public void test78()
	{
		// check searching for 78
		assertEquals("Searching for 78 in an array of the first 100 odds should give -1", 
			-1, // correct answer
				BinarySearch.binarySearch(odds, 78)); 	
	}
	
	@Test
	public void test100()
	{
		// check searching for 100
		assertEquals("Searching for 100 in an array of the first 100 odds should give -1", 
			-1, // correct answer
				BinarySearch.binarySearch(odds, 100)); 	
	}
	
	@Test
	public void test186()
	{
		// check searching for 186
		assertEquals("Searching for 186 in an array of the first 100 odds should give -1", 
			-1, // correct answer
				BinarySearch.binarySearch(odds, 186)); 	
	}
	
	@Test
	public void test99()
	{
		// check searching for 99
		assertEquals("Searching for 99 in an array of the first 100 odds should give 49", 
			49, // correct answer
				BinarySearch.binarySearch(odds, 99)); 	
	}
	
	@Test
	public void test101()
	{
		// check searching for 101
		assertEquals("Searching for 101 in an array of the first 100 odds should give 50", 
			50, // correct answer
				BinarySearch.binarySearch(odds, 101)); 	
	}
	
	@Test
	public void test177(){
		// check searching for 177
		assertEquals("Searching for 177 in an array of the first 100 odds should give 88", 
			88,// correct answer
				BinarySearch.binarySearch(odds, 177)); 	
	}
	
	@Test
	public void test07(){
		// check searching for -7
		assertEquals("Searching for -7 in an array of 14 mixed numbers should give 1", 
			1,// correct answer
				BinarySearch.binarySearch(mixed, -7)); 	
	}
	
	@Test
	public void test8(){
		// check searching for 8
		assertEquals("Searching for 4 in an array of 14 mixed numbers should give 6", 
			6,// correct answer
				BinarySearch.binarySearch(mixed, 8)); 	
	}
	
	@Test
	public void test5(){
		// check searching for 5
		assertEquals("Searching for 5 in an array of 14 mixed numbers should give 5", 
			5,// correct answer
				BinarySearch.binarySearch(mixed, 5)); 	
	}
	
	@Test
	public void test04(){
		// check searching for -4
		assertEquals("Searching for -4 in an array of 14 mixed numbers should give 2", 
			2,// correct answer
				BinarySearch.binarySearch(mixed, -4)); 	
	}
	
	@Test
	public void test0100(){
		// check searching for -100 
		assertEquals("Searching for -100 in an array of 14 mixed numbers should give -1", 
			-1,// correct answer
				BinarySearch.binarySearch(mixed, -100
						)); 	
	}
	
	@Test
	public void test300(){
		// check searching for 300 
		assertEquals("Searching for 300 in an array of 14 mixed numbers should give -1", 
			-1,// correct answer
				BinarySearch.binarySearch(mixed, 300)); 	
	}
	
	@Test
	public void test05(){
		// check searching for -5 
		assertEquals("Searching for -5 in an array of 14 mixed numbers should give -1", 
			-1,// correct answer
				BinarySearch.binarySearch(mixed, -5)); 	
	}
	
	@Test
	public void test9(){
		// check searching for 300 
		assertEquals("Searching for 9 in an array of 14 mixed numbers should give -1", 
			-1,// correct answer
				BinarySearch.binarySearch(mixed, 9)); 	
	}
}
