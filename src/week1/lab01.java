package week1;

import java.util.Arrays;

public class lab01 {

    public static Integer[] insertIntegerInSortedArray(Integer[] sortedArray, Integer k ) {
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

    public static void main(String[] args) {
        // k is less than the smallest integer in the original array
        Integer[] allIntegersGreaterThanK = {3, 4, 5, 9, 11};
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
        mergedArray = insertIntegerInSortedArray(allIntegersGreaterThanK, k);
        System.out.println(Arrays.toString(mergedArray));
    }
}
