package datastructure;
import static org.junit.Assert.*;
import org.junit.Test;
/*
 * Implementing a stack as a linked list
 * Adapted from Drozdek - Chapter: 4, page: 147, fig: 4.5
*/
public class LLStack <T>{

    @SuppressWarnings("rawtypes")
    private java.util.LinkedList list = new java.util.LinkedList();

    public LLStack() {
    }

    public void clear() {
        list.clear();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public Object topEl() {
        if (isEmpty())
            throw new java.util.EmptyStackException();
        return list.getLast();
    }

    public Object pop() {
        if (isEmpty())
            throw new java.util.EmptyStackException();
        return list.removeLast();
    }

    @SuppressWarnings("unchecked")
    public void push(Object el) {
        list.addLast(el);
    }

    public String toString() {
        return list.toString();
    }
    
    @Test
    public void stackUnitTest() {

        int[] arrTest = { 10, 5, 17, 12, 20, 2 };
        LLStack<Integer> testStack = new LLStack<>();

        for (int i = 0; i < arrTest.length; i++) {
            testStack.push(arrTest[i]);
        }

        assertEquals("Error in pop()", 2, testStack.pop()); // test pop operation
        
        testStack.pop();
        testStack.pop();
        testStack.pop();
        
        assertEquals("Error in pop()", 5, testStack.pop()); // test pop operation
        
        testStack.push(21);
        
        assertEquals("Error in topEl()", 21, testStack.topEl()); // test top element
        
    }

}


