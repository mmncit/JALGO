package datastructure;
/************************ BSTNode.java **************************
 * Node for Generic type binary search tree
 * Adapted from Drozdek - Chapter: 6, page: 220
 */
public class BSTNode<T> {
     protected T key;
     protected BSTNode<T> left, right;
     
     //public constructors
     public BSTNode() { // empty
         left = right = null;
     }

     public BSTNode(T el) { // just the parent
         this(el, null, null);
     }

     public BSTNode(T el, BSTNode<T> lt, BSTNode<T> rt) { // parent with children
         key = el;
         left = lt;
         right = rt;
     }
     
 }