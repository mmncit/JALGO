package datastructure;
/*
 * **************************
 * 	ArrayList.java 
 * 
 * ************************** 
 */

/**
 * An array-backed implementation of a list by means of a dynamic array. This is
 * a simplified version of the java.util.ArrayList class.
 * <p>
 * 
 * Adapted from: Chapter: 7 (List and Iterator ADTs) :Data Structures and
 * Algorithms in Java, Sixth Edition Michael T. Goodrich, Roberto Tamassia, and
 * Michael H. Goldwasser
 * <p>
 * 
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @author Md Mamunur Rashid (mmncit@gmail.com)
 * 
 */

public class ArrayList<E> {
    // instance variables
    /** Default array capacity. */
    public static final int CAPACITY = 16; // default array capacity

    /** Generic array used for storage of list elements. */
    private E[] data; // generic array used for storage

    /** Current number of elements in the list. */
    private int size = 0; // current number of elements

    // constructors
    /** Creates an array list with default initial capacity. */
    public ArrayList() {
	this(CAPACITY);
    } // constructs list with default capacity

    /**
     * Constructs list with default capacity.
     * 
     * @param capacity
     *            default capacity
     */
    @SuppressWarnings({ "unchecked" })
    public ArrayList(int capacity) { // constructs list with given capacity
	data = (E[]) new Object[capacity]; // safe cast; compiler may give
					   // warning
    }

    // public methods
    /**
     * Returns the number of elements in the list.
     * 
     * @return number of elements in the list
     */
    public int size() {
	return size;
    }

    /**
     * Tests whether the array list is empty.
     * 
     * @return true if the array list is empty, false otherwise
     */
    public boolean isEmpty() {
	return size == 0;
    }

    /**
     * Returns (but does not remove) the element at index i.
     * 
     * @param i
     *            the index of the element to return
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException
     *             if index &lt; 0 || index &gt;= size()
     */
    public E get(int i) throws IndexOutOfBoundsException {
	checkBoundsExclusive(i);
	return data[i];
    }

    /**
     * Replaces the element at the specified index, and returns the element
     * previously stored.
     * 
     * @param i
     *            the index of the element to replace
     * @param e
     *            the new element to be stored
     * @return the previously stored element
     * @throws IndexOutOfBoundsException
     *             if index &lt; 0 || index &gt;= size()
     */
    public E set(int i, E e) throws IndexOutOfBoundsException {
	checkBoundsExclusive(i);
	E temp = data[i];
	data[i] = e;
	return temp;
    }

    /**
     * Inserts the given element at the specified index of the list, shifting
     * all subsequent elements in the list one position further to make room.
     * 
     * @param i
     *            the index at which the new element should be stored
     * @param e
     *            the new element to be stored
     * @throws IndexOutOfBoundsException
     *             if index &lt; 0 || index &gt; size()
     */
    public void add(int i, E e) throws IndexOutOfBoundsException {
	checkBoundsExclusive(i);
	if (size == data.length) // not enough capacity
	    resize(2 * data.length); // so double the current capacity
	for (int k = size - 1; k >= i; k--)
	    // start by shifting rightmost
	    data[k + 1] = data[k];
	data[i] = e; // ready to place the new element
	size++;
    }

    /**
     * Appends the supplied element to the end of this list. The element, e, can
     * be an object of any type or null.
     * 
     * @param e
     *            the element to be appended to this list
     * @return true, the add will always succeed
     */
    public boolean add(E e) {
	if (size == data.length)
	    resize(2 * data.length); // so double the current capacity
	data[size++] = e;
	return true;
    }

    /**
     * Removes and returns the element at the given index, shifting all
     * subsequent elements in the list one position closer to the front.
     * 
     * @param i
     *            the index of the element to be removed
     * @return the element that had be stored at the given index
     * @throws IndexOutOfBoundsException
     *             if the index is negative or greater than size()
     */
    public E remove(int i) throws IndexOutOfBoundsException {
	checkBoundsExclusive(i);
	E temp = data[i];
	for (int k = i; k < size - 1; k++)
	    // shift elements to fill hole
	    data[k] = data[k + 1];
	data[size - 1] = null; // help garbage collection
	size--;
	return temp;
    }

    // utility methods
    /**
     * Checks that the index is in the range of existing elements (exclusive).
     * 
     * @param index
     *            the index to check
     * @throws IndexOutOfBoundsException
     *             if index &lt; 0 || index &gt;= size
     */
    private void checkBoundsExclusive(int index) {
	if (index < 0 || index >= size)
	    throw new IndexOutOfBoundsException("Illegal index: " + index
		    + ", Size:" + size);
    }

    /** Resizes internal array to have given capacity >= size. */
    @SuppressWarnings({ "unchecked" })
    protected void resize(int capacity) {
	E[] temp = (E[]) new Object[capacity]; // safe cast; compiler may give
					       // warning
	for (int k = 0; k < size; k++)
	    temp[k] = data[k];
	data = temp; // start using the new array
    }

    /**
     * Returns the lowest index at which element appears in this List, or -1 if
     * it does not appear.
     * 
     * @param e
     *            the element whose inclusion in the List is being tested
     * @return the index where e was found
     */
    public int indexOf(Object e) {
	for (int i = 0; i < size; i++)
	    if (e.equals(data[i]))
		return i;
	return -1;
    }

    /**
     * Returns true if element is in this ArrayList.
     * 
     * @param e
     *            the element whose inclusion in the List is being tested
     * @return true if the list contains e
     */
    public boolean contains(Object e) {
	return indexOf(e) != -1;
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder("(");
	for (int j = 0; j < size; j++) {
	    if (j > 0)
		sb.append(", ");
	    sb.append(data[j]);
	}
	sb.append(")");
	return sb.toString();
    }
}