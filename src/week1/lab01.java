package week1;

import java.util.Arrays;

/**
 * COMP 3761 lab1 Q5.
 *
 * @author Jonghooon Jang
 * @version Jan, 2022
 */
public final class lab01 {
    private lab01() {
    }

    /**
     * Insert an integer K into a sorted array of integers in non-decreasing order.
     *
     * @param sortedArray An array
     * @param k Integer
     * @return mergedArray array
     */
    public static Integer[] insertIntegerInSortedArray(final Integer[] sortedArray,
                                                       final Integer k) {
        int newArraySize = sortedArray.length + 1;
        int newArrayIndex = 0;
        boolean isKInserted = false;

        Integer[] newArray = new Integer[newArraySize];

        if (k > sortedArray[sortedArray.length - 1]) {
            newArray[newArraySize - 1] = k;
            isKInserted = true;
        }

        for (Integer integer : sortedArray) {
            if (integer < k) {
                newArray[newArrayIndex++] = integer;
            } else if (!isKInserted) {
                newArray[newArrayIndex++] = k;
                newArray[newArrayIndex++] = integer;
                isKInserted = true;
            } else {
                newArray[newArrayIndex++] = integer;
            }
        }

        return newArray;
    }

    /**
     * Tests the solution.
     *
     * @param args not used
     */
    public static void main(final String[] args) {
        // k is less than the smallest integer in the original array
//        Integer[] allIntegersGreaterThanK = {3, 4, 5, 9, 11};
        Integer[] allIntegersGreaterThanK = {15, 9, 5, 3, 2};
        int k = 1;
        Integer[] mergedArray = insertIntegerInSortedArray(allIntegersGreaterThanK, k);
        System.out.println(Arrays.toString(mergedArray));

        // k is less than the smallest integer in the original array
        Integer[] kIsInBetweenSmallestAndLargest = {3, 4, 5, 9, 11};
        k = 7;
        mergedArray = insertIntegerInSortedArray(kIsInBetweenSmallestAndLargest, k);
        System.out.println(Arrays.toString(mergedArray));

        // k is less than the smallest integer in the original array
        Integer[] allIntegersSmallerThanK = {3, 4, 5, 9, 11};
        k = 20;
        mergedArray = insertIntegerInSortedArray(allIntegersSmallerThanK, k);
        System.out.println(Arrays.toString(mergedArray));
    }
}
