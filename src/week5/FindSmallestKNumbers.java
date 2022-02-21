package week5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * COMP3761 lab 5.
 *
 * @author Jonghoon Jang
 * @version Jan, 2022
 */
public final class FindSmallestKNumbers {

    private FindSmallestKNumbers() {
    }

    /**
     * Finds the smallest k numbers (in value) out of n numbers in the array.
     *
     * @param array an array that holds numbers
     * @param k an integer representing the number of numbers to return
     * @return least k numbers as an int array
     *
     * Time Complexity: O(n*logk)
     */
    public static int[] findSmallestKNumbers(final int[] array, final int k) {

        MaxComparator pqMaxComparetor = new MaxComparator();
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, pqMaxComparetor);

        // build max-heap with capacity k
        for (int number: array) {
            if (pq.size() < k) {
                  pq.offer(number);
            } else if (pq.size() > 0 && (number < pq.peek())) {
                pq.poll();
                pq.offer(number);
            }
        }

        // convert max-heap into int array
        Integer[] tempArray = new Integer[k];
        Integer[] smallestKnumbers = pq.toArray(tempArray);

        return Arrays.stream(smallestKnumbers).mapToInt(Integer::intValue).toArray();
    }

    static class MaxComparator implements Comparator<Integer> {
        public int compare(final Integer one, final Integer two) {
            return two - one;
        }
    }


    /**
     * Run the simple tests.
     *
     * @param args unused
     */
    public static void main(final String[] args) {
        int[] numbersA = {4, 5, 1, 6, 2, 7, 3, 8};
        int[] numbersB = {1, 10, 5, 3, 4, 7, 6, 9, 8};
        System.out.println(Arrays.toString(findSmallestKNumbers(numbersA, 3)));
        System.out.println(Arrays.toString(findSmallestKNumbers(numbersB, 3)));
    }


}
