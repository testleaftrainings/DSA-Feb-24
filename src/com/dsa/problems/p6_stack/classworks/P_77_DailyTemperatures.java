package com.dsa.problems.p6_stack.classworks;

import java.util.Arrays;
import java.util.Stack;

public class P_77_DailyTemperatures {

    // MEDIUM
    // LEETCODE 739
    /********************************************************************************************************************

     Given an array of integers temperatures represents the daily temperatures,
     return an array answer such that answer[i] is the number of days you have to wait
     after the ith day to get a warmer temperature.
     If there is no future day for which this is possible, keep answer[i] == 0 instead.

     Example 1:
     Input: temperatures = [73,74,75,71,69,72,76,73]
     Output: [1,1,4,2,1,1,0,0]

     Example 2:
     Input: temperatures = [30,40,50,60]
     Output: [1,1,1,0]

     Example 3:
     Input: temperatures = [30,60,90]
     Output: [1,1,0]

     *******************************************************************************************************************/


    // O(n)T
    // O(n)S

    public static int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];

        // we push only the index of the temperature to calculate the day count difference
        Stack<Integer> stack = new Stack<>();  // --> O(n)S

        for (int i = temperatures.length-1; i >= 0; i--) { // --> O(n)T

            int currTemp = temperatures[i];

            while(!stack.isEmpty() && temperatures[stack.peek()] <= currTemp) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }

}
