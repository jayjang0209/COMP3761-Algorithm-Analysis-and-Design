package algorithms.search;

public class BruteForceStringMatch {

    public static int bruteForceStringMatch(String text, String pattern) {
        int textLength = text.length(); // n
        int patternLength = pattern.length(); // m
        char[] textCharArray = text.toCharArray();
        char[] patternCharArray = pattern.toCharArray();

        for (int i = 0; i < textLength - patternLength; i++) {
            int j = 0;
            while (j < patternLength && patternCharArray[j] == textCharArray[i + j]) {
                j++;
            }
            if (j == patternLength) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String text = "This is String match test";
        String pattern = "String";
        String patternNotFound = "Match";
        System.out.println(bruteForceStringMatch(text, pattern));
        System.out.println(bruteForceStringMatch(text, patternNotFound));

    }
}
