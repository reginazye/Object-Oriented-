package datastructures;
import datastructures.StackLL;

public class StackLL<T> extends LinkedList<T>{
	
	
	private LinkedList<T> list = new LinkedList<>();
	
	/**
	 * Pushes an element onto the top of the stack.
	 */
	public void push(T data){
		list.insertLast(data);
	}
 
	/**
	 * Removes the top of the stack and returns it.
	 * @return the popped data
	 */
	public T pop(){
			LinkedListNode<T> listnode;
		if(!isEmpty()){
			listnode= list.getLastNode();
			list.deleteLast();
			return listnode.data;
		}
		return null;
	}
 
	/** 
	 * Gets the element at the top of the stack without removing it.
	 * @return the peeked data
	 */
	public T peek(){
		if (!isEmpty()){
			LinkedListNode<T> topnode = list.getLastNode();
			return topnode.data;
		}
			return null;
	}
 
	/** 
	 * Tests if the stack is empty.
	 * @return true if the stack is empty
	 */
	public boolean isEmpty(){
		return list.isEmpty();
	}
 
	/** 
	 * Returns a String representation of the stack.
	 * @return stack as String
	 */
	public String toString(){
		String s = "";
		while(!isEmpty()){
			s = s+ pop().toString();
		}
		return s;
	}
}
