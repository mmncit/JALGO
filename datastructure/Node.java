package datastructure;
public class Node {
	
	public String data; // node information
	public Node next; // link field (Pointer to the next node) 
	
	public Node(String data, Node next){ //public constructor of Node
		this.data = data;
		this.next = next;
	}
}
