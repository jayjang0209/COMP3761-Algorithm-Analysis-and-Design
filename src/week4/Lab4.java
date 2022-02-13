package week4;

import java.util.Arrays;

public class Lab4 {

    static int findMax(int a[], int left, int right)
    {
        // divide by 2. return largest. at the end, compare.
        if (left == right) {
            return left;
        }


         if (right - left == 1) {
            if (a[left] > a[right] ) {
                return left;
            } else {
                return right;
            }
        }

        else {
            int mid = (left + right) / 2;
            int leftLargestIndex = findMax(a, left, mid);
            int rightLargestIndex = findMax(a, mid + 1, right);
            return a[leftLargestIndex] > a[rightLargestIndex] ? leftLargestIndex : rightLargestIndex;
        }

    }


    static int[] mergeSort(int[] A) {
        if (A.length > 1) {

            // Implement here
//            merge(B, C, A);
        }
        return A;
    }

    static void merge(int[] B, int[] C, int[] A) {
        // Implement here
    }

    public static void main(String[]args)
    {
        int a[] = {2,5,8,3,6,9,1,6,5};
        int b[] = {3,2,7,6,8};
        System.out.printf("Q1) findMax\nMaximum element: position %d\n", findMax(a, 0, a.length - 1) + 1);

        System.out.print("Q2) mergeSort\n");
        System.out.println("Before sort:");

        for(int i = 0; i < b.length; i++)
            System.out.print(b[i] + ", ");

//        mergeSort(b);

        System.out.println("\nAfter sort:");

        for(int i = 0; i < b.length; i++)
            System.out.print(b[i] + ", ");
    }

}
