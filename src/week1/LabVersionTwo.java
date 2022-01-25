package week1;

import java.util.Arrays;

/**
 * COMP 3761 lab1 Q5.
 *
 * @author Jonghooon Jang
 * @version Jan, 2022
 */
public class LabVersionTwo {

    /**
     * Insert an integer K into a sorted array of integers.
     *
     * @param sortedArray An array
     * @param k Integer
     * @return mergedArray array
     */
    public static Integer[] insertIntegerInSortedArray(final Integer[] sortedArray,
                                                       final Integer k) {
        int newArraySize = sortedArray.length + 1;
        int originalArrayIndex = 0;
        int insertPointIndex = 0;
        Integer[] newArray = new Integer[newArraySize];
        boolean isNonDecreasingOrder;

        isNonDecreasingOrder = sortedArray[0] < sortedArray[1];

        if ((isNonDecreasingOrder && k > sortedArray[sortedArray.length - 1])
                || !isNonDecreasingOrder && k < sortedArray[sortedArray.length - 1]) {
            insertPointIndex = newArraySize - 1;
        } else {
            for (int j = 0; j < sortedArray.length - 2; j++) {
                if (isNonDecreasingOrder && sortedArray[j] < k && k < sortedArray[j+1]) {
                    insertPointIndex = j + 1;
                } else if (!isNonDecreasingOrder && sortedArray[j] > k && k > sortedArray[j+1]) {
                    insertPointIndex = j + 1;
                }
            }
        }

        for (int i = 0; i < newArraySize; i++) {
            if (i == insertPointIndex) {
                newArray[i] = k;
            } else {
                newArray[i] = sortedArray[originalArrayIndex++];
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
        //k is less than the smallest integer in the original array in non-deceasing order
        Integer[] allIntegersGreaterThanKNonDecreasing = {2, 4, 6, 8, 10};
        int k = -1;
        Integer[] mergedArray = insertIntegerInSortedArray(allIntegersGreaterThanKNonDecreasing, k);
        System.out.println(Arrays.toString(mergedArray));

        // k is greater than the largest integer in the original array in non-deceasing order
        Integer[] kIsInBetweenSmallestAndLargestNonDecreasing = {2, 4, 6, 10};
        k = 100;
        mergedArray = insertIntegerInSortedArray(kIsInBetweenSmallestAndLargestNonDecreasing, k);
        System.out.println(Arrays.toString(mergedArray));

        // k is in-between the smallest int and largest int in the original array in non-deceasing order
        Integer[] allIntegersSmallerThanKNonDecreasing = {2, 4, 6, 10};
        k = 5;
        mergedArray = insertIntegerInSortedArray(allIntegersSmallerThanKNonDecreasing, k);
        System.out.println(Arrays.toString(mergedArray));

        // k is less than the smallest integer in the original array in deceasing order
        Integer[] allIntegersGreaterThanKDecreasing = {10, 8, 4, 2};
        k = -1;
        mergedArray = insertIntegerInSortedArray(allIntegersGreaterThanKDecreasing, k);
        System.out.println(Arrays.toString(mergedArray));

        // k is greater than the largest integer in the original array in deceasing order
        Integer[] kIsInBetweenSmallestAndLargestDecreasing = {10, 8, 4, 2};
        k = 100;
        mergedArray = insertIntegerInSortedArray(kIsInBetweenSmallestAndLargestDecreasing, k);
        System.out.println(Arrays.toString(mergedArray));

        // k is in-between the smallest int and largest int in the original array in non-deceasing order
        Integer[] allIntegersSmallerThanKDecreasing = {10, 8, 6, 4, 2};
        k = 7;
        mergedArray = insertIntegerInSortedArray(allIntegersSmallerThanKDecreasing, k);
        System.out.println(Arrays.toString(mergedArray));

    }
}
