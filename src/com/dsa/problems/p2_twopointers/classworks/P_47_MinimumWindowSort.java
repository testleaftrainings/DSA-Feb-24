package com.dsa.problems.p2_twopointers.classworks;

public class P_47_MinimumWindowSort {

    // MEDIUM
    /********************************************************************************************************************

     Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.

     Example 1:

     Input: [1, 2, 5, 3, 7, 10, 9, 12]
     Output: 5
     Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted


     Example 2:

     Input: [1, 3, 2, 0, -1, 7, 10]
            [-1, 0, 1, 2, 3, 7, 10]
     Output: 5
     Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted


     Example 3:

     Input: [1, 2, 3]
     Output: 0
     Explanation: The array is already sorted


     Example 4:

     Input: [3, 2, 1]
     Output: 3
     Explanation: The whole array needs to be sorted.

     *******************************************************************************************************************/


    // O(n)T
    // O(1)S
    public static int sort(int[] arr) {

        int minUnsorted = Integer.MAX_VALUE;
        int maxUnsorted = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) { // --> O(n)T
            if(!isSorted(arr, i)) {
                minUnsorted = Math.min(minUnsorted, arr[i]);
                maxUnsorted = Math.max(maxUnsorted, arr[i]);
            }
        }

        // edge case
        if (minUnsorted == Integer.MAX_VALUE && maxUnsorted == Integer.MIN_VALUE) {
            return 0;
        }

        int left = 0;
        int right = arr.length - 1;

        // find best position for min unsorted
        while(left < arr.length && arr[left] <= minUnsorted) { // --> O(n)T
            left++;
        }

        // find best position for max unsorted
        while(right >= 0 && arr[right] >= maxUnsorted) { // --> O(n)T
            right--;
        }

        return right - left + 1;
    }


    private static boolean isSorted(int[] arr, int i) {

        // first element
        if(i==0)
            return arr[i] <= arr[i+1];

        // last element
        if (i==arr.length-1)
            return arr[i] >= arr[i-1];

        // middle elements
        return arr[i] >= arr[i-1] && arr[i] <= arr[i+1];
    }

}
