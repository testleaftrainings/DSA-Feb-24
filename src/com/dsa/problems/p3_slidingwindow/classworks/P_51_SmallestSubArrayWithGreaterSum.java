package com.dsa.problems.p3_slidingwindow.classworks;

public class P_51_SmallestSubArrayWithGreaterSum {

    // MEDIUM
    /********************************************************************************************************************

     Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray
     whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.

     Example 1:
     Input: [2, 1, 5, 2, 3, 2], S=7
     Output: 2
     Explanation: The smallest subarray with a sum greater than or equal to ‘7’ is [5, 2].

     Example 2:
     Input: [2, 1, 5, 2, 8], S=7
     Output: 1
     Explanation: The smallest subarray with a sum greater than or equal to ‘7’ is [8].

     Example 3:
     Input: [3, 4, 1, 1, 6], S=8
     Output: 3
     Explanation: Smallest subarrays with a sum greater than or equal to ‘8’ are [3, 4, 1] or [1, 1, 6].

     *******************************************************************************************************************/


    // O(n)T
    // O(1)S
    public static int findMinSubArray(int S, int[] arr) {

        int windowStart = 0;
        int currSum = 0;
        int smallestLen = Integer.MAX_VALUE;

        // Grow on the right
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) { // -- > O(n)T

            System.out.println();
            System.out.println("*****");
            System.out.println("Growing on the right..");
            System.out.println("Add : " + arr[windowEnd]);

            currSum += arr[windowEnd];
            System.out.println("WindowSum : " + currSum);

            // continuously shrink on the left till your window becomes invalid(currSum < S)
            while(currSum >= S) {
                int winLen = windowEnd - windowStart + 1;
                smallestLen = Math.min(smallestLen, winLen);
                System.out.println(">>>>> SMALLEST WINDOW LENGTH SO FAR <<<<<<" + smallestLen);

                System.out.println("Shrinking on the left..");
                System.out.println("Remove : " + arr[windowStart]);
                currSum -= arr[windowStart++];
                System.out.println("WindowSum after shrinking : " + currSum);
            }
        }

        return smallestLen == Integer.MAX_VALUE ? 0 : smallestLen;

    }






    public static void main(String[] args) {
        //int result = findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        //System.out.println("Smallest subarray length: " + result);
        int result = findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        //result = findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        //System.out.println("Smallest subarray length: " + result);
        //result = findMinSubArray(16, new int[] { 3, 4, 1, 1, 6 });
        //System.out.println("Smallest subarray length: " + result);
    }

}
