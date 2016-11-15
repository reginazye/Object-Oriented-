import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for Linked List
 * 
 * @author ReginaYe
 *
 */
public class LinkedListTest {
	LinkedList<String> testList1;
	LinkedList<String> testList2;

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	/**
	 * the initial linked list
	 */
	@Before
	public void TestList1() {
		testList1 = new LinkedList<String>();
		testList1.insertFirst("c");
		testList1.insertAfter(testList1.head, "d");
		testList1.insertAfter((testList1.head).next, "e");
	}

	/**
	 * test if the linked list is empty
	 */
	@Test
	public void testIsEmpty() {
		assertFalse(testList1.isEmpty());
	}

	/**
	 * test the GetFirst method
	 */
	@Test
	public void testGetFirst() {
		assertEquals("c", testList1.getFirst());
	}

	/**
	 * test the GetFirstNode method
	 */
	@Test
	public void testGetFirstNode() {
		assertEquals(testList1.getFirstNode(), testList1.head);
	}

	/**
	 * test for getLast method
	 */
	@Test
	public void getLast() {
		assertEquals("e", testList1.getLast());
	}

	/**
	 * test for getting the last node
	 */
	@Test
	public void testGetLastNode() {
		assertEquals("e", testList1.getLastNode().getData());
	}

	/**
	 * test for getting the size of linked list
	 */
	@Test
	public void testSize() {
		assertEquals(3, testList1.size());
	}

	/**
	 * test if insert first works correctly
	 */
	@Test
	public void testInsertFirst() {
		testList1.insertFirst("a");
		assertEquals("a", testList1.getFirst());
	}

	/**
	 * test if insert after works correctly
	 */
	@Test
	public void testInsertAfter() {
		testList1.insertAfter(testList1.getFirstNode(), "b");
		assertEquals("b", (testList1.head).next.data);
	}

	/**
	 * test if insert last works correctly
	 */
	@Test
	public void testInsertLast() {
		testList1.insertLast("f");
		assertEquals("f", testList1.getLast());
	}

	/**
	 * test if delte first works correctly
	 */
	@Test
	public void testDeleteFirst() {
		testList1.deleteFirst();
		assertEquals("d", testList1.getFirst());
	}

	/**
	 * test if delete last works correctly
	 */
	@Test
	public void testDeleteLast() {
		testList1.deleteLast();
		assertEquals("d", testList1.getLast());
	}

	/**
	 * test if the list can be converted to string correctly
	 */
	@Test
	public void testToString() {
		assertEquals("c->d->e", testList1.toString());
	}

	/**
	 * the mega test that has multiple steps
	 */
	@Test
	public void megaTest() {
		// create a new empty linked list and test if it is empty
		testList2 = new LinkedList<String>();
		assertTrue("STEP 1", testList2.isEmpty());

		// step 2, insert a at the beginning
		testList2.insertFirst("a");
		assertEquals("STEP 2", "a", testList2.toString());

		// step 3, insert v at the beginning
		testList2.insertFirst("v");
		assertEquals("STEP 3", "v->a", testList2.toString());

		// step 4, insert a at the beginning
		testList2.insertFirst("a");
		assertEquals("STEP 4", "a->v->a", testList2.toString());

		// step 5, insert i at the beginning
		testList2.insertFirst("l");
		assertEquals("STEP 5", "l->a->v->a", testList2.toString());

		// step 6, insert o at the beginning
		testList2.insertFirst("o");
		assertEquals("STEP 6", "o->l->a->v->a", testList2.toString());

		// step 7, insert i at the beginning
		testList2.insertFirst("i");
		assertEquals("STEP 7", "i->o->l->a->v->a", testList2.toString());

		// step 8, insert j after the node following the head node
		testList2.insertAfter(testList2.head.next, "j");
		assertEquals("STEP 8", "i->o->j->l->a->v->a", testList2.toString());

		// step 9, insert e after the node following the head node
		testList2.insertAfter(testList2.head.next, "e");
		assertEquals("STEP 9", "i->o->e->j->l->a->v->a", testList2.toString());

		// step 10, insert v after the node following the head node
		testList2.insertAfter(testList2.head.next, "v");
		assertEquals("STEP 10", "i->o->v->e->j->l->a->v->a", testList2.toString());

		// step 11, insert l after the head node
		testList2.insertAfter(testList2.head, "l");
		assertEquals("STEP 11", "i->l->o->v->e->j->l->a->v->a", testList2.toString());

		// step 12, delete the node after the node after the node after the node
		// after the node after the head node.
		testList2.deleteNext(testList2.head.next.next.next);
		assertEquals("STEP 12", "i->l->o->v->j->l->a->v->a", testList2.toString());
	}
}
