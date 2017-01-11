/**
 * Default Binary Search Tree	
 * 
 * @author ReginaYe
 *
 * @param <T>
 */
public class DefaultBinarySearchTree<T extends Comparable<T>> extends DefaultBinaryTree<T>
		implements BinarySearchTree<T> {

/**
 * insert data in the binary search tree
 */
	public void insert(T data){
		if (root == null){
			root = new DefaultBinaryTreeNode<T>(data);
		}
		else{
		insertHelper(data, (DefaultBinaryTreeNode<T>) root);
		}
	}
	
/**
 * insert helper method, 
 * using recursion 
 * 
 * @param data
 * @param root
 */
	private void insertHelper(T data, DefaultBinaryTreeNode<T> root){
		if (data.compareTo(root.getData())>0 && !root.isLeaf() && root.getRightChild()!=null){
			insertHelper(data, (DefaultBinaryTreeNode<T>) root.getRightChild());
		}
		if (data.compareTo(root.getData())<0 && !root.isLeaf() && root.getLeftChild()!=null){
			insertHelper(data, (DefaultBinaryTreeNode<T>) root.getLeftChild());
		}
		if (data.compareTo(root.getData())>0 && root.getRightChild()==null){
			root.setRightChild(new DefaultBinaryTreeNode<T>(data));
		}
		if (data.compareTo(root.getData())<0 && root.getLeftChild()==null){
			root.setLeftChild(new DefaultBinaryTreeNode<T>(data));
		}
	}

/**
 * search if an element exists in the tree 
 * @return the node if found 
 */
	public BinaryTreeNode<T> search(T data) {
		return searchHelper(data, (DefaultBinaryTreeNode<T>) root);
	}
	
/**
 * search helper method 
 * using recursion
 * 
 * @param data
 * @param root
 * @return the node found
 */
	private DefaultBinaryTreeNode<T> searchHelper(T data, DefaultBinaryTreeNode<T> root){
		if(root!=null && data == root.getData()){
			return root;
		}
		if (data!=root.getData() && root.isLeaf()){
			return null;
		}
		if (data.compareTo(root.getData())>0 && root.getRightChild()!=null){
			return searchHelper(data, (DefaultBinaryTreeNode<T>) root.getRightChild());
		}
		if (data.compareTo(root.getData())<0 && root.getLeftChild()!=null){
			return searchHelper(data, (DefaultBinaryTreeNode<T>) root.getLeftChild());
		}
		return null;
	}

/**
 * find the minimal element in the binary search tree
 */
	public T minElement(){
		DefaultBinaryTreeNode<T> temp = (DefaultBinaryTreeNode<T>) root;
		while(temp.getLeftChild()!=null){
			temp = (DefaultBinaryTreeNode<T>) temp.getLeftChild();
		}
		return temp.getData();
	}

/**
 * find the maximal element in the binary search tree
 */
	public T maxElement() {
		DefaultBinaryTreeNode<T> temp = (DefaultBinaryTreeNode<T>) root;
		while(temp.getRightChild()!=null){
			temp = (DefaultBinaryTreeNode<T>) temp.getRightChild();
		}
		return temp.getData();	
	}
}
