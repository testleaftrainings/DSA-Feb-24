package com.dsa.problems.p6_stack.classworks;

import java.util.LinkedList;
import java.util.Stack;

public class P_72_MinMaxStack {

    // MEDIUM
    /********************************************************************************************************************

     Design a stack that supports push, pop, top, and retrieving the minimum & max element in constant time.

     Implement the MinMaxStack class:

     MinMaxStack() initializes the stack object.
     void push(int val) pushes the element val onto the stack.
     void pop() removes the element on the top of the stack.
     int top() gets the top element of the stack.
     int getMin() retrieves the minimum element in the stack.
     int getMax() retrieves the minimum element in the stack.
     You must implement a solution with O(1) time complexity for each function.


     Example 1:

     Input
     ["MinMaxStack","push","push","push","getMin","pop","top","getMin", "getMax"]
     [[],[-2],[0],[-3],[],[],[],[],[]]

     Output
     [null,null,null,null,-3,null,0,-2,0]

     Explanation
     MinMaxStack minMaxStack = new MinMaxStack();
     minMaxStack.push(-2);
     minMaxStack.push(0);
     minMaxStack.push(-3);
     minMaxStack.getMin(); // return -3
     minMaxStack.pop();
     minMaxStack.top();    // return 0
     minMaxStack.getMin(); // return -2
     minMaxStack.getMax(); // return 0

     Constraints:
     -231 <= val <= 231 - 1
     Methods pop, top, getMin, getMax operations will always be called on non-empty stacks.
     At most 3 * 104 calls will be made to push, pop, top, and getMin.

     *******************************************************************************************************************/


    // O(1)T for all the actions push, pop top, minsofar & max sofar
    // O(n)S for stack space
    static class StackEntry {
        int entry;
        int minSoFar;
        int maxSoFar;

        StackEntry (int entry, int minSoFar, int maxSoFar) {
            this.entry = entry;
            this.minSoFar = minSoFar;
            this.maxSoFar = maxSoFar;
        }

    }

    static class MinMaxStack {
        Stack<StackEntry> stack = new Stack<>();

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(new StackEntry(val, val, val));
            } else {
                int minSoFar = Math.min(val, stack.peek().minSoFar);
                int maxSoFar = Math.max(val, stack.peek().maxSoFar);
                stack.push(new StackEntry(val, minSoFar, maxSoFar));
            }
        }

        public int pop() {
            return stack.pop().entry;
        }

        public int top() {
            return stack.peek().entry;
        }

        public int getMin() {
            return stack.peek().minSoFar;
        }

        public int getMax() {
            return stack.peek().maxSoFar;
        }
    }


    public static void main(String[] args) {
        MinMaxStack minMaxStack = new MinMaxStack();
        minMaxStack.push(-2);
        minMaxStack.push(0);
        minMaxStack.push(-3);
        System.out.println("---> " + minMaxStack.getMin()); // return -3
        System.out.println("---> " + minMaxStack.pop()); // pops -3
        System.out.println("---> " + minMaxStack.top()); // return 0
        System.out.println("---> " + minMaxStack.getMin()); // return -2
        System.out.println("---> " + minMaxStack.getMax()); // return 0
    }


}
