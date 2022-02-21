package algorithms.presorting;

import java.util.Arrays;

public class FindMode {

    public static int findModeUsingPresort(final int[] array) {
        Arrays.sort(array);
        int i = 0;
        int modeFrequency = 0;
        int modeValue = 0;
        while (i < array.length) {
            int runLength = 1;
            int runValue = array[i];
            while (i + runLength < array.length && array[i + runLength] == runValue) {
                runLength++;
            }
            if (runLength > modeFrequency) {
                modeFrequency = runLength;
                modeValue = runValue;
            }
            i = i + runLength;
        }
        return modeValue;
    }

    public static void main(final String[] args) {
        int[] test = {5, 1, 6, 7, 6, 5, 7, 6};
        System.out.println(findModeUsingPresort(test));
    }

}
