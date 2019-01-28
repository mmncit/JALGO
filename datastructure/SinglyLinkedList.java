package datastructure;
public class SinglyLinkedList {

	public Node head; // pointer to the first node (the dummy node!)

	public SinglyLinkedList(){ // constructor of empty list
		this.head = null; // if no element is inserted while initializing the linked list
	}

	public SinglyLinkedList(Node firstNode){
		this.head = firstNode; // if Linked list is initialized with a first node
	}

    /**
     * public int size()
     * @return the number of elements in this list
     */
    public int size(){

        int index_of_last_elem = 0;
        Node current_node = head;

        if (current_node == null) { // if it is an empty list
            return index_of_last_elem; 
        } else {
            while (current_node.next != null) {
                index_of_last_elem++;
                current_node = current_node.next;
            }
        }
        return index_of_last_elem + 1;
    }

    /**
     * public boolean add (String data)
     * appends the specified element to the end of the linked list
     * @param element - element to be inserted
     * @return true if insertion is successful
     */
    public boolean add (String element){

        if (element.equals("")) return false; //  if the specified element is an empty string return false
        else {
            
            Node new_node = new Node(element, null);
            Node current_node = head;

            if (current_node == null) { // if it is an empty list

                head = new_node;

            } else {
                while (current_node.next != null) {
                    current_node = current_node.next;
                }
                current_node.next = new_node;
            }

            return true;
        }
    }

    /**
     * public boolean add(int index, String element)
     * Inserts the specified element at the specified position in this list. 
     * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     * @param index - index at which the specified element is to be inserted
     * @param element - element to be inserted
     * @return true if insertion is successful
     */
    public boolean add(int index, String element){

        if (element.equals(""))
            return false; // if the specified element is empty string return false

        else if (index < 0 || this.size() < index) { // if the index is out of range
                                                      // then return false
            System.err.println("Index is out of range. \nIndex: " + index
                    + ", Size of Linked List: " + this.size());
            return false;

        } else {
            
            Node new_node = new Node(element, null);
            Node current_node = head;
            
            if (index == 0) { // if specified element is to be inserted at first

                new_node.next = current_node; //just insert the new node at front
                head = new_node; //update the head

            } else {

                int current_index = 0;
                while (current_index < index - 1) {
                    current_node = current_node.next;
                    current_index++;
                }
                new_node.next = current_node.next;
                current_node.next = new_node;
                
            }
            return true;
        }
    }

    /**
     * public String[] toArray() 
     * Returns an array containing all of the elements
     * in this list in proper sequence (from first to last element).
     *
     * @return an array containing all of the elements in this list in proper
     *         sequence
     */
    public String[] toArray() {

        if (this.size() == 0) { // if the list has no node
            String[] arr = new String[1];
            return arr; // just return a blank array
        } else {

            String[] arr = new String[this.size()]; // Initialize array equal to
                                                    // size of Linked list
            int i = 0; // index of first element

            Node current_node = head;

            while (current_node.next != null) {
                arr[i++] = current_node.data;
                current_node = current_node.next;
            }
            arr[i] = current_node.data; // store data of the last element
            return arr;
        }
    }
    
    /**
     * public String remove(int index)
     * Removes the element at the specified position in this list. 
     * Shifts any subsequent elements to the left (subtracts one from their indices). 
     * Returns the element that was removed from the list.
     * @param index - the index of the element to be removed
     * @return the element previously at the specified position
     */
    public String remove(int index){
        if (index < 0 || this.size() <= index) { // if the index is out of range then return false
            System.err.println("Index is out of range. \nIndex: " + index
                    + ", Size of Linked List: " + this.size());
            return null; 

        } else {

            Node current_node = head;
            String element;

            if (index == 0) { // when the first element is to be removed

                element = current_node.data;

                head = current_node.next; // update the head

            } else {

                int current_index = 0;
                while (current_index < index - 1) {
                    current_node = current_node.next;
                    current_index++;
                }
                element = current_node.next.data;
                current_node.next = current_node.next.next;

            }
            return element;
        }
    }
    /**
     * public String get(int index)
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     */
    public String get(int index){
        if (index < 0 || this.size() <= index) { // if the index is out of range
            System.err.println("Index is out of range. \nIndex: " + index
                    + ", Size of Linked List: " + this.size());
            return null;

        } else {

            int current_index = 0; // index of to traverse through the list
            Node current_node = head;

            while (current_index < index) {

                current_node = current_node.next;
                current_index++;
            }
            return current_node.data;
        }
    }
    
    /**
     * public int indexOf(String object)
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     * More formally, returns the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))),
     * or -1 if there is no such index.
     * @param object - element to search for
     * @return the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    public int indexOf(String object) {

        Node current_node = head;

        if (current_node == null)
            return -1; // if it is an empty list
        else {

            int i = 0; // tracker of current index
            boolean pFlag = false; // boolean flag to check presence of element

            while (current_node != null) {
                if (object.equals(current_node.data)) { // break at first occurrence
                    pFlag = true;
                    break;
                }
                current_node = current_node.next;
                i++;
            }

            if (pFlag)
                return i; // if element is present
            else
                return -1;
        }
    }
    /**
     * public boolean remove(String object)
     * Removes the first occurrence of the specified element from this list, if it is present. 
     * If this list does not contain the element, it is unchanged. 
     * Returns true if this list contained the specified element 
     * (or equivalently, if this list changed as a result of the call).
     * @param object - element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    public boolean remove(String object) {

        Node current_node = head;

        if (current_node == null)
            return false; // if it is an empty list
        else {

            boolean pFlag = false; // boolean flag to check presence of element
            Node prev_node = head; // tracker for previous node
            while (current_node != null) {
                if (object.equals(current_node.data)) { // break at first
                                                        // occurrence
                    pFlag = true;
                    if (current_node == head)
                        head = current_node.next; // if specified element is
                                                  // head then update head
                    else
                        prev_node.next = current_node.next;
                    break;
                }
                prev_node = current_node;
                current_node = current_node.next;
            }

            return pFlag;
        }
    }

    /**
     * public String set(int index, String element)
     * Replaces the element at the specified position in this list with the specified element.
     * @param index - index of the element to replace
     * @param element - element to be stored at the specified position
     * @return the element previously at the specified position
     */
    public String set(int index, String element) {
        if (index < 0 || this.size() <= index) { // if the index is out of range
                                                 // then return false
            System.err.println("Index is out of range. \nIndex: " + index
                    + ", Size of Linked List: " + this.size());
            return null;

        } else {

            int current_index = 0; // initialization of index to traverse through the list
            Node current_node = head;

            while (current_index < index) {

                current_node = current_node.next;
                current_index++;
            }
            String prev_elem = current_node.data; // just store the previous element to return (later)
            current_node.data = element; // replace the element in current node with specified value
            return prev_elem;
        }
    }

}
