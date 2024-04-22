package com.dsa.problems.p8_mergeintervals.classworks;

import java.util.Arrays;

public class P_98_DivideIntervalsIntoMinGroups {

    // MEDIUM
    /********************************************************************************************************************

     You are given a 2D integer array intervals where intervals[i] = [lefti, righti] represents the
     inclusive interval [lefti, righti].

     You have to divide the intervals into one or more groups such that each interval is in exactly one group,
     and no two intervals that are in the same group intersect each other.

     Return the minimum number of groups you need to make.

     Two intervals intersect if there is at least one common number between them.
     For example, the intervals [1, 5] and [5, 8] intersect.

     Example 1:
     Input: intervals = [[5,10],[6,8],[1,5],[2,3],[1,10]]
     Output: 3
     Explanation: We can divide the intervals into the following groups:
     - Group 1: [1, 5], [6, 8].
     - Group 2: [2, 3], [5, 10].
     - Group 3: [1, 10].
     It can be proven that it is not possible to divide the intervals into fewer than 3 groups.

     Example 2:
     Input: intervals = [[1,3],[5,6],[8,10],[11,13]]
     Output: 1
     Explanation: None of the intervals overlap, so we can put all of them in one group.

     *******************************************************************************************************************/


    // O(n log n)T
    // O(n)S
    public int minGroups(int[][] intervals) {

        int n = intervals.length;
        int[] startTimeSorted = new int[n]; // --> O(n)S
        int[] endTimeSorted = new int[n]; // --> O(n)S

        for (int i = 0; i < intervals.length; i++) { // --> O(n)T
            startTimeSorted[i] = intervals[i][0];
            endTimeSorted[i] = intervals[i][1];
        }

        Arrays.sort(startTimeSorted); // --> O(n log n)T
        Arrays.sort(endTimeSorted); // --> O(n log n)T

        int result = 0;

        for (int i = 0, j = 0; i < n; i++) { // --> O(n)T
            if(startTimeSorted[i] <= endTimeSorted[j]) {
                result++;
            } else {
                j++;
            }
        }

        return result;
    }


}
