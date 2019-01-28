package datastructure;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Linked list implementation of a Queue
 * Adapted from Drozdek - Chapter: 4, page: 153, fig: 4.5
 */
public class Queue<T> {

    @SuppressWarnings("rawtypes")
    private java.util.LinkedList list = new java.util.LinkedList();

    public Queue() {
    }

    public void clear() {
        list.clear();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public Object firstEl() {
        return list.getFirst();
    }

    public Object dequeue() {
        return list.removeFirst();
    }

    @SuppressWarnings("unchecked")
    public void enqueue(Object el) {
        list.addLast(el);
    }

    public String toString() {
        return list.toString();
    }
    
    @Test
    public void QueueUnitTest() {

        int[] arrTest = { 10, 5, 17, 12, 20, 2 };
        Queue<Integer> testQueue = new Queue<>();

        for (int i = 0; i < arrTest.length; i++) {
            testQueue.enqueue(arrTest[i]);
        }

        assertEquals("Error in dequeue()", 10, testQueue.dequeue()); // test dequeue operation

        testQueue.dequeue();
        testQueue.dequeue();
        
        assertEquals("Error in dequeue()", 12, testQueue.dequeue()); // test dequeue operation
        
        testQueue.clear();
        testQueue.enqueue(15);
        
        assertEquals("Error in firstEl()/enqueue(el)", 15, testQueue.firstEl()); // test first element

    }

}
