
public class QueueLL<T> implements Queue<T>{

	private LinkedList<T> list = new LinkedList<>();;

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public T peek() {
		return list.getFirst();
		
	}

	public T dequeue() {
		LinkedListNode<T> listnode;
		if(!isEmpty()){
			listnode= list.getFirstNode();
			list.deleteFirst();
			return listnode.getData();
		}
		return null;
	}

	public void enqueue(T data) {
		list.insertLast(data);
	}

}
