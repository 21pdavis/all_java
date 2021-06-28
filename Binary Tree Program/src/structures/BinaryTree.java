package structures;

/*
 * Paul Davis
 * 4/2/2021
 * Binary Tree Program
 * This program takes in integers and sorts them into a balanced binary tree, 
 * allowing the user to input and remove numbers as well as output 
 * inorder, preorder, postorder, and level order traversals.
 */

import java.util.ArrayList;
import java.util.NoSuchElementException;

@SuppressWarnings("unused")
public class BinaryTree {
	private Node root;
	// boolean used in insertion
	private boolean nodeJustAdded; 
	
	/*
	 * Initialize tree as empty
	 */
	public BinaryTree() {
		root = null;
		nodeJustAdded = false;
	}

	/*
	 * Simple static method to return the greater int of two int parameters
	 */
	public static int max(int n1, int n2) {
		return n1 > n2 ? n1 : n2;
	}

	/*
	 * BST node that constitutes the tree and connects to other nodes
	 */
	private class Node {
		private Integer data; // number stored in Node
		private int height; // highest number of child connections descending from node
		private Node left; // pointer to left child of node
		private Node right; // pointer to right child of node
		private Node parent; // pointer to parent of node

		public Node(int data) {
			this.data = data;
			this.height = 0;
			this.left = null;
			this.right = null;
			this.parent = null;
		}

		public void setData(Integer data) {
			this.data = data;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}
	
	public void printHeight() {
		System.out.println(root.right.height);
	}

	/*
	 * Public method to insert a node into the BST from outside the class. Because
	 * classes outside the BST do not have access to the root node, this method's
	 * purpose is to pass in the data and root node into the recursive method that
	 * actually inserts the nodes into the tree as well as return. Returns true if
	 * an item was inserted.
	 */
	public boolean addElement(int data) {
		root = addElementRecursive(data, root);
		return nodeJustAdded;
	}

	/*
	 * Recursive method to recur down the tree and insert node in proper place (left
	 * if new data < data in current node and vice versa). Method then recurs back
	 * up the tree, updating height and parent values along the way
	 */
	private Node addElementRecursive(int data, Node node) {
		nodeJustAdded = false;

		if (node == null) {
			node = new Node(data);
			/*
			 * Marks successful creation of node, no chance to be changed after final
			 * insert, as node is returned after.
			 */
			nodeJustAdded = true; 
			// since new node is leaf, can just return node without checking balance
			return node; 
		} else if (data < node.data) {
			node.setLeft(addElementRecursive(data, node.left));
			node.left.setParent(node);
		} else if (data > node.data) {
			node.setRight(addElementRecursive(data, node.right));
			node.right.setParent(node);
		}

		/*
		 * increase height by 1 along the path that was recurred down each time a node
		 * is added (does not execute on first insertion)
		 */
		node.setHeight(max(getHeight(node.left), getHeight(node.right)) + 1);

		return checkBalance(node);
	}

	/*
	 * Similar to addElement, removeElement is a public method to allow deletion
	 * from outside of the BST class. Calls removeElementPrivate
	 */
	public void removeElement(int key) {
		root = removeElementPrivate(key, root);
	}

	/*
	 * Private recursive method to remove an element and return unchanged root.
	 * There are Three cases: Case 1: Current has no children. If current node is a
	 * left or right child and set corresponding parent pointer to null. If root
	 * node, just set to null Case 2: Current has 1 child. Get child of current
	 * node, reassign to be child of current's parent, replacing current (and update
	 * height and parents accordingly). Case 3: Current has 2 children. Get inorder
	 * successor of current, store its data. Recursively call delete on inorder
	 * successor to eliminate duplicate node. Finally, replace current's data value
	 * with inorder successor's. Current is preserved in this case, so no need for
	 * updating of height or parents. Return root.
	 */
	private Node removeElementPrivate(int key, Node root) {
		Node current = find(key, root);
		if (current == null) {
			throw new NoSuchElementException("Element does not exist");
		}
		Node parent = current.parent;

		// If current has no children
		if (current.left == null && current.right == null) {
			if (current == root)
				root = null;
			else if (parent.left == current) {
				parent.setLeft(null);
			} else if (parent.right == current) {
				parent.setRight(null);
			}
			if(parent != null) {
				if(parent.right == null && parent.left == null) {
					parent.setHeight(0);
				}
			}
		}

		// If current has 1 child
		else if ((current.left == null && current.right != null) || (current.left != null && current.right == null)) {
			// initialize new node temp to existing child of current
			Node child = current.left == null ? current.right : current.left; 
			if (current == root) {
				root = child;
				root.setParent(null);
			} else {
				if (parent.left == current) {
					parent.setLeft(child);
					child.setParent(parent);
					parent.setHeight(child.height + 1);
				} else {
					parent.setRight(child);
					child.setParent(parent);
					parent.setHeight(child.height + 1);
				}
			}
		}

		// if current has 2 children
		else {
			Node nextInorder = findSubMin(current.right);
			Integer data = nextInorder.data;
			removeElementPrivate(nextInorder.data, root);
			current.setData(data);
		}

		return root;
	}

	/*
	 * Public method to remove the minimum value in BST. Iteratively trace down to
	 * leftmost node in tree, call removeElement on it
	 */
	public void removeMin() throws TreeIsEmptyException {
		if (isEmpty()) {
			throw new TreeIsEmptyException("Tree is Empty");
		}

		Node current = root;

		while (current.left != null) {
			current = current.left;
		}

		removeElement(current.data);
	}

	/*
	 * Public method to remove the maximum value in BST. Iteratively trace down to
	 * rightmost node in tree, call removeElement on it
	 */
	public void removeMax() throws TreeIsEmptyException {
		if (isEmpty()) {
			throw new TreeIsEmptyException("Tree is Empty");
		}

		Node current = root;

		while (current.left != null) {
			current = current.left;
		}

		removeElement(current.data);
	}

	/*
	 * Private method to remove all nodes left of a node (could be made public by
	 * creating an accompanying public method to allow outside access, but
	 * unnecessary at the moment because it is only used by methods in this class).
	 */
	private void removeLeftSubtree(Node node) {
		node.setLeft(null);
	}

	/*
	 * Private method to remove all nodes right of a node by setting node's right
	 * pointer to null (could be made public by creating an accompanying public
	 * method to allow outside access, but unnecessary at the moment because it is
	 * only used by methods in this class).
	 */
	private void removeRightSubTree(Node node) {
		node.setRight(null);
	}

	/*
	 * Public method to destroy tree. Sets root to null, JVM garbage collection will
	 * destroy rest of tree
	 */
	public void removeAllElements() {
		root = null;
	}

	/*
	 * Recursive private method to return the node with the passed-in value. Private
	 * because nodes cannot be passed outside the BST, though the method could be
	 * altered to return the data of the located node, allowing for access from
	 * outside.
	 */
	private Node find(int key, Node node) {
		if (node == null) {
			return null;
		} else if (node.data == key) {
			return node;
		} else if (key > node.data) {
			return find(key, node.right);
		} else if (key < node.data) {
			return find(key, node.left);
		}

		return node;
	}

	/*
	 * Public boolean method to return true if an item is contained within the BST.
	 */
	public boolean contains(int key) {
		return containsRecursive(key, this.root);
	}

	/*
	 * Recursive private method to search tree by key and return true when value is
	 * found. If never found, return false
	 */
	private boolean containsRecursive(int key, Node root) {
		if (root == null) {
			return false;
		} else if (key == root.data) {
			return true;
		} else if (key < root.data) {
			return containsRecursive(key, root.left);
		} else if (key > root.data) {
			return containsRecursive(key, root.right);
		}

		return false; // line only reached if never found
	}

	/*
	 * public boolean method to return true if tree is empty. Tree is empty if root
	 * is null because all nodes lead back to tree and JVM garbage collection will
	 * throw out rest of nodes if root is null
	 */
	public boolean isEmpty() {
		return root == null ? true : false;
	}

	/*
	 * Public method to allow access from outside BST to size of BST. Calls
	 * sizeRecursive
	 */
	public int size() {
		return sizeRecursive(root);
	}

	/*
	 * Private recursive method to traverse tree using a preorder traversal and
	 * count number of elements along the way
	 */
	private int sizeRecursive(Node root) {
		return root == null ? 0 : sizeRecursive(root.left) + sizeRecursive(root.right) + 1;
	}

	/*
	 * Method used during insertion to check the balance of a node using AVL
	 * guidelines. Returns the passed in node after any changes made to ensure
	 * proper tree balance.
	 */
	private Node checkBalance(Node root) {
		int avl = findAvl(root);

		if (avl < -1) { // left imbalance
			if (findAvl(root.left) <= -1) { // left imbalance in left child
				root = rotateRight(root);
			} else if (findAvl(root.left) >= 1) { // right imbalance in left child
				root = rotateLeftRight(root);
			}
		}

		if (avl > 1) { // right imbalance
			if (findAvl(root.right) >= 1) { // right imbalance in right child
				root = rotateLeft(root);
			} else if (findAvl(root.right) <= -1) { // left imbalance in right child
				root = rotateRightLeft(root);
			}
		}

		return root;
	}

	/*
	 * Method to find AVL balance by subtracting height of left node from height of
	 * right node
	 */
	private int findAvl(Node node) {
		return getHeight(node.right) - getHeight(node.left);
	}

	/*
	 * Used to get height of a passed-in node, account for node being null and
	 * return -1 if node is null
	 */
	private int getHeight(Node node) {
		return node == null ? -1 : node.height;
	}

	/*
	 * Rotate nodes around the passed-in node, updating parent nodes and heights as
	 * needed. Details in further comments in method. Called when AVL is +2/+1
	 */
	private Node rotateLeft(Node root) {
		// temps
		Node newRoot = root.right;
		Node rightLeft = newRoot.left;

		// reassign pointers
		newRoot.setLeft(root);
		root.setRight(rightLeft);

		// update parents
		updateParent(newRoot, root.parent);
		updateParent(root, newRoot);
		updateParent(rightLeft, root);

		/*
		 * update heights (works because these two nodes are the only ones whose heights
		 * are changed, so can just get max between heights of their new, unchanged
		 * subordinate nodes + 1)
		 */
		root.setHeight(max(getHeight(root.left), getHeight(root.right)) + 1);
		newRoot.setHeight(max(getHeight(newRoot.left), getHeight(root.right)) + 1);

		return newRoot;
	}

	/*
	 * Rotate nodes around the passed-in node, updating parent nodes and heights as
	 * needed. Details in further comments in method. Called when AVL is -2/-1
	 */
	private Node rotateRight(Node root) {
		// temps to preserve pointers that get lost during rotation
		Node newRoot = root.left;
		// only variable in this method that could potentially be null
		Node leftRight = newRoot.right; 

		// reassign pointers
		newRoot.setRight(root);
		root.setLeft(leftRight);

		// update parents
		updateParent(newRoot, root.parent);
		updateParent(root, newRoot);
		updateParent(leftRight, root);

		/*
		 * update heights (works because these two nodes are the only ones whose heights
		 * are changed, so can just get max between heights of their new, unchanged
		 * subordinate nodes + 1)
		 */
		root.setHeight(max(getHeight(root.left), getHeight(root.right)) + 1);
		newRoot.setHeight(max(getHeight(newRoot.left), getHeight(root.right)) + 1);

		return newRoot;
	}

	/*
	 * In the case of a +2/-1 AVl balance, rotate right around the right child of
	 * the passed in root, then perform a left rotation
	 */
	private Node rotateRightLeft(Node root) {
		root.right = rotateRight(root.right);
		root = rotateLeft(root);

		return root;
	}

	/*
	 * In the case of a -2/+1 AVl balance, rotate right around the right child of
	 * the passed in root, then perform a left rotation
	 */
	private Node rotateLeftRight(Node root) {
		root.left = rotateLeft(root.left);
		root = rotateRight(root);

		return root;
	}

	/*
	 * Set parent method that accounts for potential of child being null
	 */
	private void updateParent(Node child, Node parent) {
		if (child == null) {
			return;
		}
		child.setParent(parent);
	}

	/*
	 * Public method to iteratively trace down to leftmost (minimum) node of tree,
	 * then return its data
	 */
	public int findMin() {
		Node current = root;

		while (current.left != null) {
			current = current.left;
		}

		return current.data;
	}

	/*
	 * Public method to iteratively trace down to rightmost (maximum) node of tree,
	 * then return its data
	 */
	public int findMax() {
		Node current = root;

		while (current.right != null) {
			current = current.right;
		}

		return current.data;
	}

	/*
	 * Private method to return maximum value of a subtree specified by a passed-in
	 * node
	 */
	private Node findSubMax(Node node) {
		Node current = node;

		while (current.right != null) {
			current = current.right;
		}

		return current;
	}

	/*
	 * Private method to return minimum value of a subtree specified by a passed-in
	 * node
	 */
	private Node findSubMin(Node node) {
		Node current = node;

		while (current.left != null) {
			current = current.left;
		}

		return current;
	}

	/*
	 * Create an inorder iterator and use it to append all BST elements in proper
	 * order to a string, then return that string
	 */
	public String toStringInorder() {
		String s = "";
		Iterator<Integer> it = this.iteratorInorder();

		while (it.hasNext()) {
			s += it.next() + " ";
		}

		return s;
	}

	/*
	 * Create an preorder iterator and use it to append all BST elements in proper
	 * order to a string, then return that string
	 */
	public String toStringPreorder() {
		String s = "";
		Iterator<Integer> it = this.iteratorPreorder();

		while (it.hasNext()) {
			s += it.next() + " ";
		}

		return s;
	}

	/*
	 * Create an posorder iterator and use it to append all BST elements in proper
	 * order to a string, then return that string
	 */
	public String toStringPostorder() {
		String s = "";
		Iterator<Integer> it = this.iteratorPostorder();

		while (it.hasNext()) {
			s += it.next() + " ";
		}

		return s;
	}

	/*
	 * Create an level order iterator and use it to append all BST elements in
	 * proper order to a string, then return that string
	 */
	public String toStringLevelOrder() {
		String s = "";
		Iterator<Integer> it = this.iteratorLevelOrder();

		while (it.hasNext()) {
			s += it.next() + " ";
		}

		return s;
	}

	/*
	 * Methods to return the specific type of iterator needed
	 */
	public Iterator<Integer> iteratorInorder() {
		return new Itr<Integer>("inorder");
	}

	public Iterator<Integer> iteratorPreorder() {
		return new Itr<Integer>("preorder");
	}

	public Iterator<Integer> iteratorPostorder() {
		return new Itr<Integer>("postorder");
	}

	public Iterator<Integer> iteratorLevelOrder() {
		return new Itr<Integer>("levelOrder");
	}

	/*
	 * Simple Itr object that is used to iterate through an arraylist. Takes in a
	 * String type to stipulate which traversal should be invoked
	 */
	@SuppressWarnings("hiding")
	private class Itr<Integer> implements Iterator<Integer> {
		private int cursor;
		private int size;
		private int lastRet;
		private ArrayList<Node> treeList;
		private String type;

		public Itr(String type) {
			cursor = 0;
			lastRet = -1;
			size = size();
			treeList = new ArrayList<Node>();
			this.type = type;
			if (type.equals("inorder")) {
				treeList = getInorderList(root, treeList);
			}
			if (type.equals("preorder")) {
				treeList = getPreorderList(root, treeList);
			}
			if (type.equals("postorder")) {
				treeList = getPostorderList(root, treeList);
			}
			if (type.equals("levelOrder")) {
				treeList = getLevelOrderList(root);
			}
		}

		@Override
		public boolean hasNext() {
			return cursor != size;
		}

		@Override
		@SuppressWarnings("unchecked")
		public Integer next() {
			int c = cursor;
			if (c >= size)
				throw new NoSuchElementException();
			cursor = c + 1;

			return (Integer) treeList.get(lastRet = c).data;
		}
	}

	/*
	 * Recur all the way left to minimum, then, on recurring back up, add nodes to
	 * inorder list, travelling down the the min of the right subtree whenever
	 * possible 1. Traverse left child 2. Visit Node (add to inorder list) 3.
	 * Traverse right child
	 */
	private ArrayList<Node> getInorderList(Node root, ArrayList<Node> inorder) {
		if (root == null) {
			return inorder;
		}

		getInorderList(root.left, inorder);
		inorder.add(root);
		getInorderList(root.right, inorder);

		return inorder;
	}

	/*
	 * Same recursion order as inorder, but instead of adding nodes on the way back
	 * up in ascending order, add nodes to preorder list as they are visited 1.
	 * Visit Node (add to preorder list) 2. Traverse left child 3. Traverse right
	 * child
	 */
	private ArrayList<Node> getPreorderList(Node root, ArrayList<Node> preorder) {
		if (root == null) {
			return preorder;
		}

		preorder.add(root);
		getPreorderList(root.left, preorder);
		getPreorderList(root.right, preorder);

		return preorder;
	}

	/*
	 * A postorder traversal, starting at the minimum again, adds nodes only when
	 * the given node's left tree is null or has already been added 1. Traverse left
	 * child 2. Traverse right child 3. Visit Node (add to postorder list)
	 */
	private ArrayList<Node> getPostorderList(Node root, ArrayList<Node> postorder) {
		if (root == null) {
			return postorder;
		}

		getPostorderList(root.left, postorder);
		getPostorderList(root.right, postorder);
		postorder.add(root);

		return postorder;
	}

	/*
	 * Level order traverses the list by level, adding to a results ArrayList the
	 * inorder succession of the nodes on the horizontal levels of the BST
	 */
	private ArrayList<Node> getLevelOrderList(Node root) {
		ListQueue<Node> nodes = new ListQueue<Node>();
		ArrayList<Node> results = new ArrayList<Node>();

		nodes.enqueue(root);
		while (!nodes.isEmpty()) {
			Node temp = nodes.dequeue();
			if (temp != null) {
				results.add(temp);
				nodes.enqueue(temp.left);
				nodes.enqueue(temp.right);
			}
		}

		return results;
	}
}