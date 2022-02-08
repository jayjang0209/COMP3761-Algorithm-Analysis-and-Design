package algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSortIteratively(final Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) { // basic operation O(n^2)
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }


    public static void insertionSortRecursive(final Integer[] array, final int length) {
        if (length > 1) {
            insertionSortRecursive(array, length - 1);
            int key = array[length - 1];
            int i = length - 2;
            while (i >= 0 && array[i] > key) {
                array[i + 1] = array[i];
                i = i - 1;
            }
            array[i + 1] = key;
        }


    }

    public static void main(String[] args) {
        Integer[] array = { 2, 1, 4, 6, 3, 5 };
        insertionSortRecursive(array, array.length);
        System.out.println(Arrays.toString(array));
    }

}
