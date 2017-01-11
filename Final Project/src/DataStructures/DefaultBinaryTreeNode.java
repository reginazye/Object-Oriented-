package DataStructures;
/**
 * Tree Node class implemented for the Binary Tree
 * 
 * @author ReginaYe
 *
 * @param <T>
 */
public class DefaultBinaryTreeNode<T> implements BinaryTreeNode<T> {

	public T data;
	public BinaryTreeNode<T> left;
	public BinaryTreeNode<T> right;

	/**
	 * constructor for the tree node class
	 * 
	 * @param data
	 */
	public DefaultBinaryTreeNode(T data) {
		this.data = data;
		left = null;
		right = null;
	}

	/**
	 * retrieve the data from the tree node
	 */
	public T getData() {
		return data;
	}

	/**
	 * set data for the tree node
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * return the left child of the node
	 */
	public BinaryTreeNode<T> getLeftChild() {
		return left;
	}

	/**
	 * return the right child of the node
	 */
	public BinaryTreeNode<T> getRightChild() {
		return right;
	}

	/**
	 * with a parameter, set the left child value of the tree node
	 */
	public void setLeftChild(BinaryTreeNode<T> left) {
		this.left = left;
	}

	/**
	 * with a parameter, set the right child value of the tree node
	 */
	public void setRightChild(BinaryTreeNode<T> right) {
		this.right = right;
	}

	/**
	 * see if the node is a leaf, which means no children on both sides
	 */
	public boolean isLeaf() {
		if (left == null && right == null) {
			return true;
		}
		return false;
	}
}
