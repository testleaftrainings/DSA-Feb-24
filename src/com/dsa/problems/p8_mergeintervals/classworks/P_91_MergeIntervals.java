package com.dsa.problems.p8_mergeintervals.classworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class P_91_MergeIntervals {

    // MEDIUM
    /********************************************************************************************************************

     Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.

     Example 1:
     Intervals: [[1,4], [2,5], [7,9]]
     Output: [[1,5], [7,9]]
     Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
     one [1,5].

     Example 2:
     Intervals: [[6,7], [2,4], [5,9]]
     Output: [[2,4], [5,9]]
     Explanation: Since the intervals [6,7] and [5,9] overlap, we merged them into one [5,9].

     Example 3:
     Intervals: [[1,4], [2,6], [3,5]]
     Output: [[1,6]]
     Explanation: Since all the given intervals overlap, we merged them into one.

     *******************************************************************************************************************/

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }



    // O(n log n)T
    // O(n)S
    public static List<Interval> merge_extraSpace(List<Interval> intervals) {

        // [1, 4] [3, 9]
        // 1 - 3 = -2

        // [3, 9] [1, 4]
        // 3 - 1 = 2
        // [1, 4] [3, 9]
        intervals.sort((a, b) -> (a.start - b.start)); // --> O(n log n)T & O(n)S

        List<Interval> result = new ArrayList<>(); // --> O(n)S
        Interval previous = intervals.get(0);
        result.add(previous);

        for (int i = 1; i < intervals.size(); i++) { // --> O(n)T
            Interval current = intervals.get(i);

            if (current.start <= previous.end) {
                previous.end = Math.max(current.end, previous.end);
            } else {
                result.add(current);
                previous = current;
            }
        }

        return result;
    }



    public static List<Interval> merge_inPlace(List<Interval> intervals) {

        // [1, 4] [3, 9]
        // 1 - 3 = -2

        // [3, 9] [1, 4]
        // 3 - 1 = 2
        // [1, 4] [3, 9]
        intervals.sort((a, b) -> (a.start - b.start)); // --> O(n log n)T & O(n)S

        Interval previous = intervals.get(0);
        int previousIdx = 0;

        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);

            if (current.start <= previous.end) {
                previous.end = Math.max(current.end, previous.end);
            } else { // mutually exclusive

                // set the current into next place after previousIdx
                intervals.set(previousIdx+1, current);
                previousIdx++;
                previous = current;
            }
        }

        System.out.println("previousIdx --> "+previousIdx);



        // remove unwanted intervals
        int toBeRemovedCount = intervals.size() - previousIdx - 1;
        System.out.println("toBeRemovedCount --> "+toBeRemovedCount);
        System.out.println("size --> "+intervals.size());

        for (int i = intervals.size()-1; i > previousIdx; i--) {
            intervals.remove(i);
        }

        return intervals;

    }


    public static void main(String[] args) {
        Interval i1 = new Interval(1, 4);
        Interval i2 = new Interval(2, 5);
        Interval i3 = new Interval(7, 9);
        List<Interval> input = new ArrayList<>(Arrays.asList(i1, i3, i2));

        List<Interval> output = merge_inPlace(input);
        for (Interval interval : output) {
            System.out.println("["+interval.start+", "+interval.end+"]");
        }


    }




}
