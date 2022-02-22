package algorithms.presorting;

import java.util.ArrayList;
import java.util.Arrays;

public class FindIntersection {

    public static ArrayList<Integer> findIntersectionUsingPresort(int[] A, int[] B) {
        Arrays.sort(A); // O(n*logn)
        Arrays.sort(B);
        ArrayList<Integer> intersection = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i != A.length && j != B.length) {
            if (A[i] == B[j]) {
                intersection.add(A[i]);
                i++;
                j++;
            } else if (A[i] < B[j]) {
                i++;
            } else {
                j++;
            }
        }
        return intersection;
    }




    public static ArrayList<Integer> findIntersectionUsingBruteForce(int[] A, int[] B) {
        ArrayList<Integer> intersection = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) { // O(n^2) basic operation
                    intersection.add(A[i]);
                }
            }
        }
        return intersection;
    }




    public static void main(String[] args) {
        int[] A = {1, 2, 3, 5, 9, 8, 19};
        int[] B = {3, 4, 5, 7, 8, 15, 11, 19};
        System.out.println(findIntersectionUsingBruteForce(A, B));
        System.out.println(findIntersectionUsingPresort(A, B));
    }
}
