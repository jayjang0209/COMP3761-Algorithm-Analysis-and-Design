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
        Integer[] originalArray = {1,2, 5, 9, 11};
        Integer integerToInsert = 6;
        Integer[] mergedArray = insertIntegerInSortedArray(originalArray, integerToInsert);
        System.out.println(Arrays.toString(mergedArray));
    }
}
