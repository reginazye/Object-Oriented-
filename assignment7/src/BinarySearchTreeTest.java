import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Binary Search Tree Test	
 * 
 * @author ReginaYe
 *
 */
public class BinarySearchTreeTest
{
	//initiate the variables
	public static final int NUM_ELEMENTS = 500;
	private Integer[] randomArray;
	private BinarySearchTree<Integer> randomBST;
 
	/**
	 * cast the exceptions
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		setupRandomArray();
	}
	
	/**
	 * set up a random array and
	 * make a binary search tree according to it
	 */
	private void setupRandomArray()
	{
		randomArray = new Integer[NUM_ELEMENTS]; // random integers
		for (int i = 0; i < randomArray.length; i++)
			randomArray[i] = new Integer((int) (Math.random() * 10000) + 1);
		//make a binary search tree of the random numbers
		randomBST = new DefaultBinarySearchTree<Integer>();
		for (int i = 0; i < randomArray.length; i++){
			randomBST.insert(randomArray[i]);
		}
	//print out the tree in order traversal 
	System.out.println("random inorder traversal is: " + randomBST.inorderTraversal().toString());
	}
 
 
/**
 * test if the generated linked list matches 
 * the in order traversal of the binary search tree 
 */
	@Test
	public void testTraversal()
	{
		LinkedList<Integer> inorderTraversal = randomBST.inorderTraversal();
 
		// check that it's in order
		assertEquals("random BST in order", true, isOrdered(inorderTraversal));
	}
 
/** 
 * check if the list is ordered 
 * @param list
 * @return
 */
	private boolean isOrdered(LinkedList<Integer> list)
	{
		LinkedListNode<Integer> current = list.getFirstNode();
		if (current.getNext() == null)
		{
			// list has size 1, so it's ordered
			return true;
		} else
		{
			// list has size > 1
			LinkedListNode<Integer> currentNext = current.getNext();
 
			while (current.getNext() != null)
			{
				// compare the two
				if (current.getData().compareTo(currentNext.getData()) > 0)
					return false;
				// otherwise, update
				current = current.getNext();
				currentNext = currentNext.getNext();
			}
 
			// if we get here, it was ordered
			return true;
 
		}
	}

/**
 * test if an element exists in the tree, 
 * the search method is tested 
 */
	@Test
	public void testEltExists()
	{
		int randomIdx = (int) Math.floor(Math.random() * randomArray.length);
		System.out.println(randomBST.search(randomArray[randomIdx]));
		assertEquals("search for element in random tree",
				randomArray[randomIdx],
				randomBST.search(randomArray[randomIdx]).getData());
	}

/**
 * test if the search method returns null 
 * if searching an out of the array element
 */
	@Test
	public void testEltNotExist()
	{
		assertEquals("search for element not in random tree", null,
				randomBST.search(new Integer(0)));
	}
 
/**
 * test if the minimal number from the binary search tree 
 * matches the smallest of the array 
 */
	@Test
	public void testMin()
	{
		System.out.println( "Min in random tree is: " + randomBST.minElement() );
		assertEquals( "Testing min in random tree", findMin(randomArray),
				randomBST.minElement() );
	}
 
/**
 * test if the find max method successfully finds the maximum number in the array and tree  
 */
	@Test
	public void testMax()
	{
		System.out.println( "Max in random tree is: " + randomBST.maxElement() );
		assertEquals( "Testing max in random tree", findMax(randomArray),
				randomBST.maxElement() );
	}
 
/**
 * find the minimal number in an array 
 * @param a
 * @return minimal number in an array
 */
	private Integer findMin( Integer[] a )
	{
		// start min at first element
		Integer min = a[0];
 
		// look through the rest of the array
		for ( int i = 1; i < a.length; i++ )
			// if found something smaller
			if ( a[i].compareTo( min ) < 0 )
				// save it
				min = a[i];
 
		// return result
		return min;	
	}

/**
 * find the max number in an array 
 * @param a
 * @return the maximal number in the array
 */
	private Integer findMax( Integer[] a )
	{
		// start max at first element
		Integer max = a[0];
 
		// look through the rest of the array
		for ( int i = 1; i < a.length; i++ )
			// if found something smaller
			if ( a[i].compareTo( max ) > 0 )
				// save it
				max = a[i];
		// return result
		return max;	
	}
}