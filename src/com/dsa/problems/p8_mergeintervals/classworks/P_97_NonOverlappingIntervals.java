package com.dsa.problems.p8_mergeintervals.classworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_97_NonOverlappingIntervals {

    // MEDIUM
    /********************************************************************************************************************

     Given an array of intervals where intervals[i] = [starti, endi],
     return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

     Example 1:
     Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
     Output: 1
     Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

     Example 2:
     Input: intervals = [[1,2],[1,2],[1,2]]
     Output: 2
     Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.

     Example 3:
     Input: intervals = [[1,2],[2,3]]
     Output: 0
     Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

     *******************************************************************************************************************/





    // O(n log n)T
    // O(n)S for the Time sort which the Arays.sort uses
    public static int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0])); // --> O(n log n)T & O(n)S

        int prevEnd = intervals[0][1];
        int result = 0;

        for (int i = 1; i <intervals.length ; i++) { // --> O(n)T
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (currStart < prevEnd) {
                result++;
                prevEnd = Math.min(currEnd, prevEnd);
            } else {
                prevEnd = currEnd;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        // [1,2],[2,3],[3,4],[1,3]
        int[][] intervals = new int[][]{new int[]{1,2}, new int[]{2,3}, new int[]{3,4}, new int[]{1,3}};
        System.out.println("--> "+ eraseOverlapIntervals(intervals));
    }


}
