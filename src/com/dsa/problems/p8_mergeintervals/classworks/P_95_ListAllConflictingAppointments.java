package com.dsa.problems.p8_mergeintervals.classworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_95_ListAllConflictingAppointments {

    // MEDIUM
    /********************************************************************************************************************

     Given a list of appointments, find all the conflicting appointments.

     Appointments: [[4,5], [2,3], [3,6], [5,7], [7,8]]
     Output:
     [4,5] and [3,6] conflict.
     [3,6] and [5,7] conflict.

     Output: [4,5] [3,6] [5,7] in any order

     *******************************************************************************************************************/





    // O(n log n)T
    // O(n)S
    public static List<Interval> allConflictingAppointments(Interval[] intervals) {

        List<Interval> result = new ArrayList<>(); // --> O(n)S
        // sort
        Arrays.sort(intervals, (x, y) -> Integer.compare(x.start, y.start)); // --> O(n log n)T


        boolean isPreviousAddedToResult = false;
        int previousEnd = intervals[0].end;

        // loop from left to right
        for (int i = 1; i < intervals.length; i++) { // --> O(n)T

            // if the current is conflicting with the previous:
            if (intervals[i].start < previousEnd) {

                // add current to the result
                result.add(intervals[i]);
                previousEnd = Math.max(previousEnd, intervals[i].end);

                // add previous to the result only if it is not added before
                if (!isPreviousAddedToResult) {
                    result.add(intervals[i-1]);
                    isPreviousAddedToResult = true;
                }
            } else {
                previousEnd = intervals[i].end;
                isPreviousAddedToResult = false;
            }
        }

        return result;

    }

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String toString(){
            return "["+start + ","+ end + "]";
        }
    }


    public static void main(String[] args) {

        // [4,5], [2,3], [3,6], [5,7], [7,8]
        Interval i1 = new Interval(4, 5);
        Interval i2 = new Interval(2, 3);
        Interval i3 = new Interval(3, 6);
        Interval i4 = new Interval(5, 7);
        Interval i5 = new Interval(7, 8);

        Interval[] input = new Interval[]{i1, i2, i3, i4, i5};
        for(Interval interval : allConflictingAppointments(input)) {
            System.out.println("["+interval.start+", "+interval.end+"]");
        }
    }

}
