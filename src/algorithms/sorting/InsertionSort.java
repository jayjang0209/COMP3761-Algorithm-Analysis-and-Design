package algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSortIteratively(final Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }


    public static void insertionSortRecursive(final Integer[] array) {

    }

    public static void main(String[] args) {
        Integer[] array = { 2, 1, 4, 6, 3, 5 };
        insertionSortIteratively(array);
        System.out.println(Arrays.toString(array));
    }

}
