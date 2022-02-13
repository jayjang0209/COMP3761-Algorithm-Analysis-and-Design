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


    static int[] mergeSort(final int[] A) throws ArrayIndexOutOfBoundsException {
        int n = A.length;
        int mid = n / 2;

        if(n == 0) {
            throw new ArrayIndexOutOfBoundsException("Empty array was passed.");
        }

        if (n > 1) {
            int[] B = Arrays.copyOfRange(A, 0, mid);
            int[] C = Arrays.copyOfRange(A, mid, n);
            mergeSort(B);
            mergeSort(C);
            merge(B, C, A);
        }
        return A;
    }

    static void merge(final int[] B,final int[] C,final int[] A) {
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
            while (j < q - 1) {
                A[k] = C[j];
                j++;
                k++;
            }
        } else {
            while (i < p - 1) {
                A[k] = B[i];
                i++;
                k++;
            }
        }
    }

    public static void main(String[]args)
    {
        int a[] = {2,5,8,3,6,9,1,6,5};
//        int b[] = {3,2,7,6,8};
        int b[] = {};
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
