package com.dsa.problems.p8_mergeintervals.classworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P_92_InsertInterval {

    // MEDIUM
    /********************************************************************************************************************

     Given a list of non-overlapping intervals sorted by their start time, insert a given interval at the correct position and merge
     all necessary intervals to produce a list that has only mutually exclusive intervals.

     Example 1:
     Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
     Output: [[1,3], [4,7], [8,12]]
     Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].

     Example 2:
     Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
     Output: [[1,3], [4,12]]
     Explanation: After insertion, since [4,10] overlaps with [5,7] & [8,12], we merged them into [4,12].

     Example 3:
     Input: Intervals=[[2,3],[5,7]], New Interval=[1,4]
     Output: [[1,4], [5,7]]
     Explanation: After insertion, since [1,4] overlaps with [2,3], we merged them into one [1,4].

     *******************************************************************************************************************/

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    // O(n)T
    // O(n)S

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new LinkedList<>(); // --> O(n)S
        boolean isNewIntervalInserted = false;

        for(Interval currentInterval : intervals) { // --> O(n)T
            // if newInterval is already inserted
            if (isNewIntervalInserted) {
                mergedIntervals.add(currentInterval);
            }

            // case 1: Current Interval, New Interval (no overlap)
            else if (currentInterval.end < newInterval.start) {
                mergedIntervals.add(currentInterval);
            }

            // case 2: New Interval, Current Interval
            else if (newInterval.end < currentInterval.start) {
                mergedIntervals.add(newInterval);
                isNewIntervalInserted = true;
                mergedIntervals.add(currentInterval);
            }

            // case 3; All overlapping cases
            // CurrIntNewInterval
            // NewIntCurrentInterval
            // new interval completely lies within current interval
            // current interval completely lies within new interval
            // current & new are exactly the same
            else {
                newInterval.start = Math.min(currentInterval.start, newInterval.start);
                newInterval.end = Math.max(currentInterval.end, newInterval.end);
            }
        }

        // if the new interval is positioning after the end of the input array of intervals
        if (!isNewIntervalInserted) {
            mergedIntervals.add(newInterval);
        }

        return mergedIntervals;
    }


    public static void main(String[] args) {
        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(5, 7);
        Interval i3 = new Interval(8, 12);
        List<Interval> input = Arrays.asList(i1, i2, i3);

        List<Interval> output = insert(input, new Interval(4, 6));
        for (Interval interval : output) {
            System.out.println("["+interval.start+", "+interval.end+"]");
        }
    }



}
