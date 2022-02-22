package algorithms.presorting;

import java.util.ArrayList;

public class FindIntersection {

    public static ArrayList<Integer> findIntersectionUsingBruteForce(int[] A, int[] B) {
        ArrayList<Integer> intersection = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (A[i] == B[j]) {
                    intersection.add(A[i]);
                }
            }
        }
        return intersection;
    }




    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6};
        int[] B = {3, 4, 5, 6, 7, 8};
        System.out.println(findIntersectionUsingBruteForce(A, B));
    }
}
