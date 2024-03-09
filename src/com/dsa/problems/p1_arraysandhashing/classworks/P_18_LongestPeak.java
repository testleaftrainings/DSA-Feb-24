package com.dsa.problems.p1_arraysandhashing.classworks;

public class P_18_LongestPeak {

    // MEDIUM
    // Leetcode 845
    /********************************************************************************************************************

     Write a function that takes in an array of integers and returns the length of
     the longest peak in the array.

     A peak is defined as adjacent integers in the array that are strictly
     increasing until they reach a tip (the highest value in the peak), at which
     point they become strictly decreasing. At least three integers are required to
     form a peak.

     For example, the integers 1, 4, 10, 2 form a peak, but the
     integers 4, 0, 10 don't and neither do the integers
     1, 2, 2, 0. Similarly, the integers 1, 2, 3 don't
     form a peak because there aren't any strictly decreasing integers after the 3

     Sample Input
     array = [1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3]

     Sample Output: 6 // 0, 10, 6, 5, -1, -3

     *******************************************************************************************************************/



    // O(n)T
    // O(1)S

    public static int longestPeak(int[] array) {

        if (array.length <= 2) return 0;

        // initialize result value
        int longestPeakLength = 0;
        int i = 1;

        // loop through the input values
        while (i < array.length-1) {

            int prev = array[i-1];
            int next = array[i+1];
            int curr = array[i];

            // process only for the tip
            if (prev < curr && curr > next) {
                System.out.println("The Tip is : " + curr);

                int peakLength = 1;

                System.out.println("Traversing left downhill");

                int j = 0;

                // traverse left downhill
                for (j = i-1; j >= 0; j--) {

                    if (array[j] < array[j+1]) {
                        System.out.println("-> "+array[j]);
                        peakLength++;
                    }
                    else break;
                }

                System.out.println("Traversing right downhill");

                // traverse right downhill
                for (j = i+1; j < array.length; j++) {
                    if (array[j] < array[j-1]) {
                        System.out.println("-> "+array[j]);
                        peakLength++;
                    }
                    else break;
                }

                // continuously track the length for the result
                longestPeakLength = Math.max(longestPeakLength, peakLength);

                i = j;
            } else {
                i++;
            }

        }
        return longestPeakLength;
    }





    public static void main(String[] args) {
        System.out.println(longestPeak(new int[] {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3}));
    }

}
