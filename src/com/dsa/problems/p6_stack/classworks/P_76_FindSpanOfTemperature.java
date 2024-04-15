package com.dsa.problems.p6_stack.classworks;

import java.util.Stack;

public class P_76_FindSpanOfTemperature {

    // MEDIUM
    /********************************************************************************************************************

     Given daily temperature, return the span of the temperature for the each day.

     The span of the temperature in one day is the maximum number of consecutive days
     (starting from that day and going backward)
     for which the temperature was less than or equal to the temperature of that day.

     For example, if the temperature in the last four days is [7,2,1,2] and the temperature today is 2,
     then the span of today is 4 because starting from today, the temperature was less than
     or equal 2 for 4 consecutive days.

     Also, if the temperature in the last four days is [7,34,1,2] and the temperature today is 8,
     then the span of today is 3 because starting from today, the temperature was
     less than or equal 8 for 3 consecutive days.

     input : [5,6,77,8,4, 12,45, 0]
     output: [1,2, 3,1,1, 2, 3, 1]

     *******************************************************************************************************************/




    public static int[] findSpanTemperatures(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int span = 1;
            if(!stack.isEmpty() && stack.peek() > array[i]) {
                stack.clear();
            }

            span += stack.size();
            stack.push(array[i]);
            result[i] = span;
        }

        return result;
    }


    public static void main(String[] args) {
        int[] result = findSpanTemperatures(new int[]{5,6,77,8,4, 12,45, 0});
        for(int r:result) {
            System.out.println(r+", ");
        }
    }


}
