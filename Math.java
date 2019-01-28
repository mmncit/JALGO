import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author mmncit
 * 
 */
public class Math {

    /**
     * Returns the greater of set of values.
     * 
     * @author Carrano, F., Prichard, J. (2006). Book: Data abstraction and
     *         problem solving with Java : Walls and mirrors (2nd ed) page: 10
     * 
     * @param numbers
     *            set of given numbers
     * @return the largest of all numbers
     */
    public static int max(int... numbers) {
	int maximum = Integer.MIN_VALUE;
	for (int num : numbers) {
	    if (maximum < num) {
		maximum = num;
	    }
	}
	return maximum;

    }

    @Test
    public void unittests() {

	int[] arr = { 3, 5, 1, 6 };
	// test with an array
	assertEquals("Error in max(int.. numbers)", 6, Math.max(arr));
	// test with values
	assertEquals("Error in max(int.. numbers)", 7, Math.max(4, 5, 7, 1));
    }

}