package algorithms;

import java.util.Comparator;

/**
 * @author mmncit
 * 
 */
public class Sorting {
    /**
     * Merge contents of arrays S1 and S2 into properly sized array S.
     * 
     * @author Goodrich, M., Tamassia, R. (2010). Data structures and algorithms
     *         in Java. (6th ed) Page: 537
     * 
     * @param S1
     *            left sequence containing the first ⌊n/2⌋ elements of S
     * @param S2
     *            right sequence containing the the remaining ⌈n/2⌉ elements of
     *            S
     * @param S
     *            sorted sequence after merging the sorted sequences S1 and S2
     * 
     */
    public static <T> void merge(T[] S1, T[] S2, T[] S, Comparator<T> comp) {
	// merge of two sorted arrays for which S2[j] < S1[i]
    }
}
