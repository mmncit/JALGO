package datastructure;
/**
 * The <code>Vector</code> class implements growable arrays of Objects.
 * Elements in a Vector can be accessed with an index 
 */
public class Vector {
    
    
    private SinglyLinkedList[] elementData; //The internal array used to hold values of a Vector.
    private int elementCount; //the number of elements currently in the vector
    private int capacityIncrement; //The amount the Vector's internal array should be increased in size when a new element is added that exceeds the current size of the array
    
    /**
    * Constructs a Vector with the initial capacity and capacity increment specified.
    *
    * @param initialCapacity the initial size of the Vector's internal array
    * @param capacityIncrement the amount the internal array should be increased by when necessary
    * @throws IllegalArgumentException if initialCapacity &lt; 0
    */
    public Vector(int initialCapacity, int capacityIncrement) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Initial capacity should be greater than 0");
        elementData = new SinglyLinkedList[initialCapacity];
        this.capacityIncrement = capacityIncrement;
    }
    
    /**
     * Adds a new list at the end of vector.
     * 
     * @param newList the element to add to the Vector
     * @return true, as specified by List
     */
    public boolean add(SinglyLinkedList newList) {
        if (newList.head == null)
            return false;
        else {
            if (elementCount == elementData.length) ensureCapacity(elementCount + 1);
            elementData[elementCount++] = newList;
            return true;
        }
    }
    /**
    * Ensures that <code>minCapacity</code> elements can fit within this Vector.
    * If <code>elementData</code> is too small, it is expanded as follows:
    * If the <code>elementCount + capacityIncrement</code> is adequate, that
    * is the new size. If <code>capacityIncrement</code> is non-zero, the
    * candidate size is double the current. If that is not enough, the new
    * size is <code>minCapacity</code>.
    *
    * @param minCapacity the desired minimum capacity, negative values ignored
    */
    public void ensureCapacity(int minCapacity) {
        if (elementData.length >= minCapacity)
            return;

        int newCapacity;
        if (capacityIncrement <= 0)
            newCapacity = elementData.length * 2;
        else
            newCapacity = elementData.length + capacityIncrement;
        
        SinglyLinkedList [] newArray = new SinglyLinkedList[newCapacity];
        
        for(int i = 0; i < elementData.length; i++){
            //copy previous elements into the new array
            newArray[i] = elementData[i];
        }
        elementData = newArray; // update internal array
    }

    /**
     * Returns the number of elements stored in this Vector.
     * 
     * @return the number of elements in this Vector
     */
    public int size() {
        return elementCount;
    }
    
    /**
     * Returns the element at position <code>index</code>.
     * 
     * @param index
     *            the position from which an element will be retrieved
     * @return the element at that position
     * @throws ArrayIndexOutOfBoundsException
     *             index &lt; 0 || index &gt;= size()
     */
   public SinglyLinkedList get(int index){ 
       if (index < 0 || index >= elementCount) 
           throw new ArrayIndexOutOfBoundsException("Given index is less than zero or >= current size of vector");     
       else 
           return elementData[index];
   }
   
   /**
   * Puts <code>element</code> into the Vector at position <code>index</code>
   * and returns the Object that previously occupied that position.
   *
   * @param index the index within the Vector to place the Object
   * @param element the Object to store in the Vector
   * @return the previous object at the specified index
   * @throws ArrayIndexOutOfBoundsException index &lt; 0 || index &gt;= size()
   */
    public SinglyLinkedList set(int index, SinglyLinkedList element) {
        if (index < 0 || index >= elementCount)
            throw new ArrayIndexOutOfBoundsException("Given index is less than zero or >= current size of vector");
        else {
            SinglyLinkedList temp = elementData[index];
            elementData[index] = element;
            return temp;
        }
    }
}
