package algorithms.presorting;

import java.util.Arrays;

public class PresortElementUniqueness {

    public static boolean presortElementUniqueness(final int[] array) {
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] == array[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] testArray = {1, 2, 3, 4, 5, 6};
        System.out.println("Array has no equal elements? " + presortElementUniqueness(testArray));
        int[] testArraySecond = {1, 6, 2, 3, 4, 5, 6};
        System.out.println("Array has no equal elements? " + presortElementUniqueness(testArraySecond));
    }
}
