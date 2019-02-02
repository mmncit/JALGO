package algorithms;
/*
 * ArrayOperations
 *
 * A class with basic array methods to
 *  - print the values in an array
 *  - calculate the sum of the values in an array
 *  - calculate the minimum of the values in an array
 *  - calculate the maximum of the values in an array
 *  - calculate the average of the values in an array
 *
 */
public class ArrayOperations {
    /*
     * printArray
     * 
     * Purpose: prints all the values in the array to the console example
     * format: {1,2,3,4}
     * 
     * Parameters: an array of integers
     * 
     * Preconditions: array contains at least one element
     * 
     * Returns: void
     */
    public static void printArray(int[] array) {
	System.out.print("{");
	for (int i = 0; i < array.length - 1; i++)
	    System.out.print(array[i] + ",");

	System.out.println(array[array.length - 1] + "}");
    }

    /*
     * arraySum
     * 
     * Purpose: totals all the values in the input array
     * 
     * Parameters: an array of integers
     * 
     * Preconditions: array contains at least one element
     * 
     * Returns: total of all values in the array
     */
    public static int arraySum(int[] array) {
	int sum = 0;

	for (int i = 0; i < array.length; i++)
	    sum += array[i];

	return sum;
    }

    /*
     * arrayMax
     * 
     * Purpose: finds the maximum value in the input array
     * 
     * Parameters: an array of integers
     * 
     * Preconditions: array contains at least one element
     * 
     * Returns: maximum value in the array
     */
    public static int arrayMax(int[] array) {
	int max = array[0];

	for (int i = 1; i < array.length; i++) {
	    if (array[i] > max)
		max = array[i];
	}

	return max;
    }

    /*
     * arrayMin
     * 
     * Purpose: finds the maximum value in the input array
     * 
     * Parameters: an array of integers
     * 
     * Preconditions: array contains at least one element
     * 
     * Returns: minimum value in the array
     */
    public static int arrayMin(int[] array) {
	int min = array[0];

	for (int i = 1; i < array.length; i++) {
	    if (array[i] < min)
		min = array[i];
	}

	return min;
    }

    /*
     * arrayAvg
     * 
     * Purpose: finds the average of all the values in the input array
     * 
     * Parameters: an array of integers
     * 
     * Preconditions: array contains at least one element
     * 
     * Returns: average of values in the array as a double
     */
    public static double arrayAvg(int[] array) {
	int sum = 0;

	for (int i = 0; i < array.length; i++)
	    sum += array[i];

	return (double) sum / (double) array.length;
    }

    /*
     * arraysEqual
     * 
     * Purpose: determines whether the two arrays are equal where equal means
     * array1 and array2 are the same length and the contain the same values in
     * the same order
     * 
     * Parameters: two arrays of integers
     * 
     * Returns: true if the are equal, false otherwise
     */
    public static boolean arraysEqual(int[] a1, int[] a2) {
	if (a1 == a2) { // compare if elements are of the same array
	    System.out.println("case 1");
	    return true;
	}
	if (null == a1 || null == a2) // if one of the array are null
	    return false;
	// If arrays are of same length, check each element
	if (a1.length == a2.length) {
	    int i = 0;
	    // start checking from the first to last
	    while (i < a1.length) {

		if (a1[i] != a2[i]) {// if difference found then return false
		    return false;
		}
		i++;
	    }
	    return true;
	}
	return false;
    }

}