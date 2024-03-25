package com.dsa.problems.p3_slidingwindow.classworks;

import java.util.Arrays;

public class P_49_AverageOfSubarrayOfSizeK {

    // EASY
    /********************************************************************************************************************

     Given an array, find the average of all sub arrays of ‘K’ contiguous elements in it.

     Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5

     Here, we are asked to find the average of all sub arrays of ‘5’ contiguous elements in the given array. Let’s solve this:

     For the first 5 numbers (subarray from index 0-4), the average is: (1+3+2+6-1)/5 => 2.2
     (1+3+2+6−1)/5 => 2.2

     The average of next 5 numbers (subarray from index 1-5) is: (3+2+6-1+4)/5 => 2.8
     (3+2+6−1+4)/5 => 2.8

     For the next 5 numbers (subarray from index 2-6), the average is: (2+6-1+4+1)/5 => 2.4
     (2+6−1+4+1)/5 => 2.4

     Here is the final output containing the averages of all sub arrays of size 5:

     Output: [2.2, 2.8, 2.4, 3.6, 2.8]

     *******************************************************************************************************************/





    // O(n)T
    // O(n-K)S

    public static double[] findAverages(int[] arr, int K) {

        double[] result = new double[arr.length - K + 1]; // --> O(n-K)S

        int windowStart = 0;
        int windowSum = 0;

        // grows on right side
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) { // --> O(n)T

            windowSum += arr[windowEnd]; // keep adding the window end element anyways in all iteration
            int windowLen = windowEnd - windowStart + 1;

            if (windowLen == K) {
                double avg = (double) windowSum / (double) K;
                result[windowStart] = avg;

                // for the next iteration
                // adjust your window sum & shrink your window on left
                windowSum -= arr[windowStart++];
            }
        }

        return result;
    }



    public static void main(String[] args) {
        double[] result = findAverages(new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2 }, 5);
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }

}
