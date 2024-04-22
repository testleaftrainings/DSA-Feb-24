package com.dsa.problems.p8_mergeintervals.classworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class P_96_EmployeeFreeTime {

    /********************************************************************************************************************

     For ‘K’ employees, we are given a list of intervals representing the working hours of each employee.
     Our goal is to find out if there is a free interval that is common to all employees.
     You can assume that each list of employee working hours is sorted on the start time.

     Example 1:
     Input: Employee Working Hours=[
                                [[1,3], [5,6]],
                                [[2,3], [6,8]]
                            ]
     Output: [3,5]
     Explanation: Both the employees are free between [3,5].

     Example 2:
     Input: Employee Working Hours=[
                            [[1,3], [9,12]],
                            [[2,4]], [[6,8]]
                        ]
     Output: [4,6], [8,9]
     Explanation: All employees are free between [4,6] and [8,9].


     Example 3:

     Input: Employee Working Hours=[
                                [[1,3]], [[2,4]],
                                [[3,5], [7,9]]
                            ]
     Output: [5,7]
     Explanation: All employees are free between [5,7].

     *******************************************************************************************************************/


    // O(n log n)T where n is the total number of intervals across all employees
    // O(n)S for the sorting & result
    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {

        List<Interval> result = new ArrayList<>(); // -- O(n)S

        List<Interval> allSchedules = new ArrayList<>(); // -- O(n)S
        for(List<Interval> s : schedule) { // -- O(n)T
            allSchedules.addAll(s);
        }

        // sort
        allSchedules.sort((x,y)-> Integer.compare(x.start, y.start));// -->  O(n log n)T & O(n)S

        int previousEnd = allSchedules.get(0).end;
        for (int i = 1; i < allSchedules.size(); i++) { // -- O(n)T

            Interval curr = allSchedules.get(i);

            // if not overlapping
            // [4,7] [9, 12]
            // freetime: [7,9]
            if (curr.start > previousEnd) {
                Interval freeTime = new Interval(previousEnd, curr.start);
                result.add(freeTime);
            }

            previousEnd = Math.max(previousEnd, curr.end);
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
    }


    public static void main(String[] args) {
        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(9, 12);
        Interval i3 = new Interval(2, 4);
        Interval i4 = new Interval(6, 8);

        List l1 = new ArrayList(Arrays.asList(i1, i2));
        List l2 = new ArrayList(Arrays.asList(i3, i4));
        List list = new ArrayList(Arrays.asList(l1, l2));


        List<Interval> result = findEmployeeFreeTime(list);

        for(Interval interval :  result) {
            System.out.println("["+interval.start+", "+interval.end+"]");
        }
    }

}
