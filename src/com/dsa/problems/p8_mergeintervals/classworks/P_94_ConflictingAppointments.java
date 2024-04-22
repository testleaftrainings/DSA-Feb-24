package com.dsa.problems.p8_mergeintervals.classworks;

import java.util.Arrays;

public class P_94_ConflictingAppointments {

    // MEDIUM
    /********************************************************************************************************************

     Given an array of intervals representing ‘N’ appointments,
     find out if a person can attend all the appointments.

     Example 1:
     Appointments: [[1,4], [2,5], [7,9]]
     Output: false
     Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.

     Example 2:
     Appointments: [[6,7], [2,4], [8,12]]
     Output: true
     Explanation: None of the appointments overlap, therefore a person can attend all of them.

     Example 3:
     Appointments: [[4,5], [2,3], [3,6]]
     Output: false
     Explanation: Since [4,5] and [3,6] overlap, a person cannot attend both of these appointments.

     *******************************************************************************************************************/



    // O(n log n)T
    // O(n)S
    public static boolean canAttendAllAppointments(Interval[] intervals) {
        Arrays.sort(intervals, ((x, y)-> x.start-y.start)); // --> O(n log n)T, O(n)S

        for (int i = 0; i < intervals.length-1; i++) { // --> O(n)T
            if(intervals[i].end > intervals[i+1].start) return false;
        }

        return true;
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
        Interval i1 = new Interval(6, 7);
        Interval i2 = new Interval(2, 7);
        Interval i3 = new Interval(8, 12);

        System.out.println("--> "+canAttendAllAppointments(new Interval[]{i1,i2,i3}));

    }

}
