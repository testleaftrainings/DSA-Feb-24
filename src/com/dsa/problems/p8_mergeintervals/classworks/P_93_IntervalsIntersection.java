package com.dsa.problems.p8_mergeintervals.classworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class P_93_IntervalsIntersection {

    // MEDIUM
    /********************************************************************************************************************

     Given two lists of intervals, find the intersection of these two lists.
     Each list consists of disjoint intervals sorted on their start time.

     Example 1:
     Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
     Output: [2, 3], [5, 6], [7, 7]
     Explanation: The output list contains the common intervals between the two lists.

     Example 2:
     Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
     Output: [5, 7], [9, 10]
     Explanation: The output list contains the common intervals between the two lists.

     *******************************************************************************************************************/


    // O(l1+l2)T
    // O(max (l1, l2))S

    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {

        List<Interval> result = new ArrayList<>(); // --> O(max(l1, l2))S

        int i=0;
        int j =0;

        while(i < arr1.length && j < arr2.length) { // --> O(l1+l2)T
            int a1Start = arr1[i].start;
            int a1End = arr1[i].end;
            int a2Start = arr2[j].start;
            int a2End = arr2[j].end;

            // check if a1 & a2 are overlapping
            if ((a1Start >= a2Start && a1Start <= a2End) || (a2Start >= a1Start && a2Start <= a1End)) {
                Interval intersectingInterval = new Interval(Math.max(a1Start, a2Start), Math.min(a1End, a2End));
                result.add(intersectingInterval);
            }

            // move the pointer which ends early
            if(a1End < a2End) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new Interval[result.size()]);
    }


    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

     public static void main(String[] args) {
        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(5, 6);
        Interval i3 = new Interval(7, 9);
        // List<Interval> input1 = Arrays.asList(i1, i2, i3);

         Interval i4 = new Interval(2, 3);
         Interval i5 = new Interval(5, 7);
         // List<Interval> input2 = Arrays.asList(i4, i5);

        Interval[] output = merge(new Interval[]{i1, i2, i3}, new Interval[]{i4, i5});
        for (Interval interval : output) {
            System.out.println("["+interval.start+", "+interval.end+"]");
        }
    }



}
