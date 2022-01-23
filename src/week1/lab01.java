package week1;

import java.util.Arrays;

public class lab01 {

    public static Integer[] insertIntegerInSortedArray(Integer[] sortedArray, Integer k ) {
        int newArraySize = sortedArray.length + 1;
        int sIndex = 0;
        boolean isKInserted = false;
        Integer[] newArray = new Integer[newArraySize];

        if (k > sortedArray[sortedArray.length - 1]) {
            newArray[newArraySize - 1] = k;
            isKInserted = true;
        }

        for (int i = 0; i < sortedArray.length; i++) {
            if (sortedArray[i] < k) {
                newArray[sIndex] = sortedArray[i];
                sIndex++;
            } else if (!isKInserted) {
                newArray[sIndex] = k;
                sIndex++;
                newArray[sIndex] = sortedArray[i];
                sIndex++;
                isKInserted = true;
            } else {
                newArray[sIndex] = sortedArray[i];
                sIndex++;
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
