package com.dsa.problems.p3_slidingwindow.classworks;

public class P_50_FindMaxSumSubArrayOfSizeK {

    // EASY
    /********************************************************************************************************************

     Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.

     Example 1:

     Input: [2, 1, 5, 1, 3, 2], k=3
     Output: 9
     Explanation: Subarray with maximum sum is [5, 1, 3].


     Example 2:

     Input: [2, 3, 4, 1, 5], k=2
     Output: 7
     Explanation: Subarray with maximum sum is [3, 4].

     *******************************************************************************************************************/


    // O(n)T
    // O(1)S
    public static int findMaxSumSubArray(int K, int[] arr) {

        int maxSum = Integer.MIN_VALUE;// CT
        int windowStart = 0;
        int currSum = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) { // ---> O(n)T
            currSum += arr[windowEnd];
            int windowLen = windowEnd - windowStart + 1;

            if (windowLen == K) {
                maxSum = Math.max(maxSum, currSum);
                currSum -= arr[windowStart++];
            }
        }

        return maxSum;
    }


    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray "
                           + findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray "
                           + findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }



}
