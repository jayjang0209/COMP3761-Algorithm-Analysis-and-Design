package week4;

import java.util.Arrays;

public class Lab4 {

    /**
     * Finds a position of the largest number in the specified array.
     * @param a a array of integers.
     * @param left an integer.
     * @param right an integer.
     */
    static int findMax(int a[], int left, int right)
    {
        // divide by 2. return largest. at the end, compare.
        // base case: size = 0
        if (left == right) {
            return left;
        }

        // base case: size = 1
         if (right - left == 1) {
            if (a[left] > a[right]) {
                return left;
            } else {
                return right;
            }
        }

        else {
            int mid = (left + right) / 2;
            int leftLargestIndex = findMax(a, left, mid);
            int rightLargestIndex = findMax(a, mid + 1, right);
            //compares the largest numbers from L and R, returns the index of the largest number
            return a[leftLargestIndex] > a[rightLargestIndex] ? leftLargestIndex : rightLargestIndex;
        }

    }

    /**
     * Sorts the specified array by recursive mergesort.
     * @param A a array of integers.
     * @throws ArrayIndexOutOfBoundsException if the length of array is less than 1
     */
    static int[] mergeSort(final int[] A) throws ArrayIndexOutOfBoundsException {
        int n = A.length;
        int mid = n / 2;

        // error handler when the size is zero
        if(n == 0) {
            throw new ArrayIndexOutOfBoundsException("Empty array was passed.");
        }

        // Divide and conquer
        if (n > 1) {
            int[] B = Arrays.copyOfRange(A, 0, mid);
            int[] C = Arrays.copyOfRange(A, mid, n);
            mergeSort(B);
            mergeSort(C);
            merge(B, C, A);
        }
        return A;
    }

    /**
     * Merges two sorted arrays into one sorted array.
     * @param B a array of integers.
     * @param C a array of integers.
     * @param A a array of integers.
     */
    static void merge(final int[] B, final int[] C, final int[] A) {
        int i = 0;
        int j = 0;
        int k = 0;
        int p = B.length;
        int q = C.length;

        while (i < p && j < q) {
            if (B[i] <= C[j]) {
                A[k] = B[i];
                i++;
            } else {
                A[k] = C[j];
                j++;
            }
            k++;
        }

        if (i == p) {
            while (j < q) {
                A[k] = C[j];
                j++;
                k++;
            }
        } else {
            while (i < p) {
                A[k] = B[i];
                i++;
                k++;
            }
        }
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

        try {
            mergeSort(b);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        System.out.println("\nAfter sort:");

        for(int i = 0; i < b.length; i++)
            System.out.print(b[i] + ", ");
    }

}
