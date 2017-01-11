
/**
 * linked list class
 * 
 * @author ReginaYe
 *
 * @param <T>
 */
public class LinkedList<T> {
	public LinkedListNode<T> head = new LinkedListNode<T>(null, null);

	/**
	 * Get data stored in head node of list.
	 */
	public T getFirst() {
		if (head.getData()!=null){
		return head.data;
		}
		if (head.data == null){
			return head.getNext().getData();
		}
		return null;
	}

	/**
	 * Get the head node of the list.
	 */
	public LinkedListNode<T> getFirstNode() {
		if (head!=null){
		return head;
		}
		return null;
	}

	/**
	 * Get data stored in last node of list.
	 */
	public T getLast() {
		LinkedListNode<T> currentNode = head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		return currentNode.data;
	}

	/**
	 * Get the tail node of the list.
	 */
	public LinkedListNode<T> getLastNode() {
		LinkedListNode<T> currentNode = head;
		while (currentNode!=null && currentNode.next != null) {
			currentNode = currentNode.next;
		}
		return currentNode;
	}

	/**
	 * Insert a new node with data at the head of the list.
	 */
	public void insertFirst(T data) {
		// create a new node
		LinkedListNode<T> newHead = new LinkedListNode<T>(data, head);
		// make the new node head node
		head = newHead;
	}

	/**
	 * Insert a new node with data after currentNode
	 */
	public void insertAfter(LinkedListNode<T> currentNode, T data) {
		LinkedListNode<T> added = new LinkedListNode<T>(data, currentNode.next);
		currentNode.next = added;
	}

	/**
	 * Insert a new node with data at the end of the list.
	 */
	public void insertLast(T data) {
		LinkedListNode<T> last = getLastNode();
		LinkedListNode<T> added = new LinkedListNode<T>(data, null);
		if (last!=null)
		last.next = added;
	}

	/**
	 * Remove the first node
	 */
	public void deleteFirst() {
		head = head.next;
	}

	/**
	 * Remove the last node
	 */
	public void deleteLast() {
		LinkedListNode<T> currentNode = getFirstNode();
		while (currentNode.next != getLastNode()) {
			currentNode = currentNode.next;
		}
		currentNode.next = null;
	}

	/**
	 * Remove node following currentNode If no node exists (i.e., currentNode is
	 * the tail), do nothing
	 */
	public void deleteNext(LinkedListNode<T> currentNode) {
		currentNode.next = currentNode.next.next;
	}

	/**
	 * Return the number of nodes in this list.
	 */
	public int size() {
		int count = 0;
		if (!isEmpty()) {
			// at least the linked list has head, the count 1
			count = 1;
			// then count the following nodes
			
			LinkedListNode<T> temp = head;
			
			while (temp.next != null) {
				temp = temp.next;
				count++;
			}
		}
		return count;
	}

	/**
	 * Check if list is empty.
	 * 
	 * @return true if list contains no items.
	 */
	public boolean isEmpty() {
		if (head.data==null &&head.next == null) {
		//if (head.data == null) {
			return true;
		}
		return false;
	}

	/**
	 * Return a String representation of the list.
	 */
	public String toString() {
		LinkedListNode<T> currentNode = head;
		String s = "";
		// add each node and the pointers
		while (currentNode.next != null) {
			s += (currentNode.data).toString();
			s += "->";
			currentNode = currentNode.next;
		}
		// add the last node
		s = s + currentNode.toString();
		// return the full string
		return s;
	}
}
