package algorithms.sorting;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BubbleSort {

    public static void bubbleSort(Integer[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSortUsingStream(Integer[] array) {
        int length = array.length;
        IntStream.range(0, length - 1)
                .flatMap(i -> IntStream.range(0, length - 1 - i))
                .forEach(j -> {
                    if (array[j + 1] < array[j]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                });
    }




    public static void main(String[] args) {
        Integer[] array = { 2, 1, 4, 6, 3, 5 };
        bubbleSortUsingStream(array);
        System.out.println(Arrays.toString(array));
    }
}
