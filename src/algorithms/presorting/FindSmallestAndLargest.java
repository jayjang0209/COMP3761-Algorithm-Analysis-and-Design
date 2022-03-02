package algorithms.presorting;

import java.util.Arrays;

public class FindSmallestAndLargest {

    public static int[] findSmallestAndLargestUsingBruteForce(int[] array) {
        int[] smallestAndLargest = new int[2];
        int smallest = array[0];
        int largest = array[0];
        for (int number : array) {
            if (number < smallest) {
                smallest = number;
            } else if (number > largest) {
                largest = number;
            }
        }
        smallestAndLargest[0] = smallest;
        smallestAndLargest[1] = largest;
        return smallestAndLargest;
    }

    public static int[] findSmallestAndLargestUsingPresort(int[] array) {
        Arrays.sort(array);
        int[] smallestAndLargest = new int[2];
        smallestAndLargest[0] = array[0];
        smallestAndLargest[1] = array[array.length - 1];
        return smallestAndLargest;
    }

    public static int[] findSmallestAndLargestUsingDivideAndConquer(int[] array) {
        int[] smallestAndLargest = new int[2];




        return smallestAndLargest;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 0, 11, 6, 9, -3};
        System.out.println(Arrays.toString(findSmallestAndLargestUsingBruteForce(array)));
        System.out.println(Arrays.toString(findSmallestAndLargestUsingPresort(array)));
    }
}
