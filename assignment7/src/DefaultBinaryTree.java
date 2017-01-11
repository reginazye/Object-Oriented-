/**
 * default binary tree class 
 * implements the binary tree interface
 * 
 * @author ReginaYe
 *
 * @param <T>
 */
public class DefaultBinaryTree<T> implements BinaryTree<T> {
	//root of the tree created 
	public BinaryTreeNode<T> root;

/**
 * get root node of the tree
 */
	public BinaryTreeNode<T> getRoot() {
		if (root != null) {
			return root;
		}
		return null;
	}
/**
 * set the root 
 */
	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

/**
 * check if the tree is empty
 */
	public boolean isEmpty() {
		if (root == null && root.getLeftChild() == null && root.getRightChild() == null) {
			return true;
		}
		return false;
	}

/**
 * main method that creates the seven dwarves tree 
 * @param args
 */
	public static void main(String args[]) {
		DefaultBinaryTree<String> tree = new DefaultBinaryTree<String>();
		DefaultBinaryTreeNode<String> node1 = new DefaultBinaryTreeNode<String>("Happy");
		DefaultBinaryTreeNode<String> node2 = new DefaultBinaryTreeNode<String>("Doc");
		DefaultBinaryTreeNode<String> node3 = new DefaultBinaryTreeNode<String>("Sleepy");
		DefaultBinaryTreeNode<String> node4 = new DefaultBinaryTreeNode<String>("Bashful");
		DefaultBinaryTreeNode<String> node5 = new DefaultBinaryTreeNode<String>("Grumpy");
		DefaultBinaryTreeNode<String> node6 = new DefaultBinaryTreeNode<String>("Sneezy");
		tree.setRoot(node1);
		node1.setLeftChild(node2);
		node1.setRightChild(node3);
		node2.setLeftChild(node4);
		node2.setRightChild(node5);
		node3.setRightChild(node6);
	}
	
/**
 * pre-order traversal method 
 * generates and return a linkedlist
 */
	public LinkedList<T> preorderTraversal() {
		LinkedList<T> list = new LinkedList<>();
		preorderTraversal(root, list);
		return list;
	}

/**
 * pre-order traversal helper method 
 * using recursion
 * 
 * @param node
 * @param traversal
 */
	private void preorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal) {
		if (root == null)
			return;
		traversal.insertLast(node.getData());
		preorderTraversal(root.getLeftChild(), traversal);
		preorderTraversal(root.getRightChild(), traversal);
	}

/**
 * in-order traversal 
 * generate and return a linked list 
 */
	public LinkedList<T> inorderTraversal() {
		LinkedList<T> list = new LinkedList<>();
		inorderTraversal(root, list);
		return list;
	}
	
/**
 * helper method for in-order traversal
 * using recursion
 * 
 * @param node
 * @param traversal
 */
	private void inorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal) {
		if(node==null){
			return;
		}
		inorderTraversal(node.getLeftChild(), traversal);
		traversal.insertLast(node.getData());
		inorderTraversal(node.getRightChild(), traversal);
	}

/**
 * post-order traversal 
 * generate and return as linked list 
 */
	public LinkedList<T> postorderTraversal() {
		LinkedList<T> list = new LinkedList<>();
		postorderTraversal(root, list);
		return list;
	}

/**
 * helper method for post-order traversal 
 * using recursion
 * 
 * @param node
 * @param traversal
 */
	private void postorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal) {
		if (root == null)
			return;
		postorderTraversal(root.getLeftChild(), traversal);
		postorderTraversal(root.getRightChild(), traversal);
		traversal.insertLast(node.getData());
	}

}
