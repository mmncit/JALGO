package datastructure;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
 * **************************
 * 	BST.java 
 * 
 * ************************** 
 * Generic type implementation of binary search tree 
 * Adapted from Drozdek - Chapter: 6, page: 220
 */
public class BST<T extends Comparable<T>> {

    protected BSTNode<T> root;

    public BST() {
	root = null;
    }

    /**
     * Inserts new element into the BST
     * 
     * @param el
     *            - new element to be added Adapted from Drozdek - Chapter: 6,
     *            page: 240, Fig: 6.23
     */
    public void insert(T el) {
	BSTNode<T> p = root; // current node
	BSTNode<T> parent = null; // assumes root is an instance variable
	while (p != null) { // find a place for inserting new node;
	    parent = p;
	    if ((el.compareTo(p.key)) > 0)
		p = p.right;
	    else
		p = p.left;
	}
	if (root == null) // tree is empty;
	    root = new BSTNode<T>(el);
	else if ((el.compareTo(parent.key)) > 0)
	    parent.right = new BSTNode<T>(el);
	else
	    parent.left = new BSTNode<T>(el);
    }

    /**
     * Searches given key in BST
     * 
     * @param key
     *            - key to be searched
     * @return if element is found then return true, otherwise return false
     * @throws RuntimeException
     *             when the tree is empty
     */
    public boolean search(T key) {
	BSTNode<T> current = root;
	if (current == null) {
	    throw new RuntimeException(
		    "Empty tree. Exception occurred while searching");
	} else {
	    while (current != null) {
		if (key.compareTo(current.key) == 0) { // compare each node
		    return true; // found
		} else if ((key.compareTo(current.key)) < 0) // If the key is
							     // less than the
							     // value, go to the
							     // left and search
		    current = current.left;
		else
		    // else, check the right subtree.
		    current = current.right;
	    }
	    return false; // not found
	}
    }

    /**
     * Recursive function to delete key in BST
     * 
     * @param el
     *            - Element to be deleted
     * @throws RuntimeException
     *             when the element (to be deleted) is not present in the tree
     */
    protected BSTNode<T> delete(BSTNode<T> current, T el) {

	if (current == null)
	    throw new RuntimeException(
		    "Element to be deleted is not present in the tree");
	else if ((el.compareTo(current.key)) < 0) // If the key is less than the
						  // value, go to the left
	    current.left = delete(current.left, el);
	else if ((el.compareTo(current.key)) > 0) // If the key is greater than
						  // the value, go to the right
	    current.right = delete(current.right, el);
	else { // element is matched for deletion

	    // case 1 + 2: the node has 0 or 1 child
	    if (current.right == null) // node has no right child: its left
		current = current.left; // child (if any) is attached to its
					// parent;

	    else if (current.left == null) // node has no left child: its right
		current = current.right; // child is attached to its parent;
	    else {
		// case 3: node with two children
		current.key = getMin(current.right); // get the smallest node in
						     // the right subtree
		current.right = delete(current.right, current.key); // delete
								    // the
								    // in-order
								    // successors
	    }
	}
	return current;
    }

    /**
     * Get the smallest node is the right subtree
     * 
     * @param rootRST
     *            root of right subtree
     * @return smallest value/key in the right subtree
     */
    protected T getMin(BSTNode<T> rootRST) {
	while (rootRST.left != null)
	    // traverse to the left to pick the smallest value
	    rootRST = rootRST.left;
	return rootRST.key;
    }

    /**
     * Deletes the given key in BST
     * 
     * @param el
     *            - Element to be deleted
     * @throws RuntimeException
     *             when the tree is empty
     */
    public void delete(T el) {
	if (root == null) {
	    throw new RuntimeException(
		    "Empty tree. Exception occurred while deletion");
	} else
	    root = delete(root, el);
    }

    /**
     * Prints top-down, left-to-right, breadth-first traversal Adapted from
     * Drozdek - Chapter: 6, page: 224, Fig: 6.10
     */
    @SuppressWarnings("unchecked")
    public void breadthFirst() {
	BSTNode<T> p = root;
	Queue<T> queue = new Queue<>();
	if (p != null) {
	    queue.enqueue(p);
	    while (!queue.isEmpty()) {
		p = (BSTNode<T>) queue.dequeue();
		System.out.println(p.key.toString()); // visit(p)
		if (p.left != null)
		    queue.enqueue(p.left);
		if (p.right != null)
		    queue.enqueue(p.right);
	    }
	}
    }

    /**
     * Recursive depth-first in-order traversal Adapted from Drozdek - Chapter:
     * 6, page: 226, Fig: 6.11
     * 
     * @param current
     *            - the starting node to traverse the tree
     */
    protected void inorder(BSTNode<T> current) {
	if (current == null)
	    return; // base case
	else {
	    inorder(current.left); // L-Traversing the left subtree
	    System.out.println(current.key.toString()); // V - Visiting the node
							// and print
	    inorder(current.right); // R-Traversing the right subtree
	}
    }

    /**
     * Recursive depth-first pre-order traversal Adapted from Drozdek - Chapter:
     * 6, page: 226, Fig: 6.11
     * 
     * @param current
     *            - the starting node to traverse the tree
     */
    protected void preorder(BSTNode<T> current) {
	if (current == null)
	    return; // base case
	else {
	    System.out.println(current.key.toString()); // V - Visiting the node
							// and print
	    preorder(current.left); // L-Traversing the left subtree
	    preorder(current.right); // R-Traversing the right subtree
	}
    }

    /**
     * Recursive depth-first post-order traversal Adapted from Drozdek -
     * Chapter: 6, page: 226, Fig: 6.11
     * 
     * @param current
     *            - the starting node to traverse the tree
     */
    protected void postorder(BSTNode<T> current) {
	if (current == null)
	    return; // base case
	else {
	    postorder(current.left); // L-Traversing the left subtree
	    postorder(current.right); // R-Traversing the right subtree
	    System.out.println(current.key.toString()); // V - Visiting the node
							// and print
	}
    }

    /**
     * prints the result of depth-first traversals according to provided method
     * 
     * @param method
     *            - the string value for calling DFS methods, e.g. inorder,
     *            postorder, preorder
     * @throws IllegalArgumentException
     *             if correct parameter is not set
     */
    public void depthFirst(String method) {
	if (method.equals("inorder"))
	    inorder(root);
	else if (method.equals("preorder"))
	    preorder(root);
	else if (method.equals("postorder"))
	    postorder(root);
	else
	    throw new IllegalArgumentException(
		    "param: "
			    + method
			    + " is not valid. \nList of valid parameters: inorder, postorder, preorder");
    }

    @Test
    public void testBST() {
	int[] arrTest = { 10, 5, 17, 2, 7, 12, 20 };
	BST<Integer> BSTree = new BST<>();

	for (int i = 0; i < arrTest.length; i++) {
	    BSTree.insert(arrTest[i]);
	}
	// test when key is in the tree
	assertEquals("Error in search()", true, BSTree.search(2));
	// test when key is not present in the tree
	assertEquals("Error in search()", false, BSTree.search(11));

	try {
	    System.out.println("Preorder traversal:");
	    BSTree.depthFirst("preorder");
	    System.out.println("Inorder traversal:");
	    BSTree.depthFirst("inorder"); // print nodes in ascending order
	    System.out.println("Postorder traversal:");
	    BSTree.depthFirst("postorder");
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}