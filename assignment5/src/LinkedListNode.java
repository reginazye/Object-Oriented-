/**
 * Linked List node class
 * 
 * @author ReginaYe
 *
 * @param <T>
 */
public class LinkedListNode<T> {
	public T data;
	public LinkedListNode<T> next;
	
	/**
	 * constructor for linked list node 
	 * 
	 * @param data
	 * @param next
	 */
	public LinkedListNode(T data, LinkedListNode<T> next){
		setData(data);
		setNext(next);
	}
	
	/**
	 * Set the data stored at this node.
	 * @param data
	 */
	public void setData( T data ){
		this.data = data;
	}
	 
	/**
	 * Get the data stored at this node.
	 */
	public T getData(){
		return data;
	}
	 
	/**
	 * Set the next pointer to passed node.
	 * @param node 
	 */
	public void setNext( LinkedListNode<T> node ){
		this.next = node;
	}
	 
	/**
	 * Get (pointer to) next node.
	 */
	public LinkedListNode<T> getNext(){
		return next;
	}
	 
	/**
	 * Returns a String representation of this node.
	 */
	public String toString(){
		String s =  data.toString();
		return s;
	}
}
