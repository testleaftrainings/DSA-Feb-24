package com.dsa.problems.p6_stack.classworks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class P_71_ValidParentheses {

    // EASY
    // LEETCODE 20
    /********************************************************************************************************************

     Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
     determine if the input string is valid.

     An input string is valid if:

     Open brackets must be closed by the same type of brackets.
     Open brackets must be closed in the correct order.
     Every close bracket has a corresponding open bracket of the same type.


     Example 1:
     Input: s = "()"
     Output: true

     Example 2:
     Input: s = "()[]{}"
     Output: true

     Example 3:
     Input: s = "(]"
     Output: false

     Example 4:
     Input: s = "({[]})"
     Output: true

     *******************************************************************************************************************/

    // O(n)T
    // O(n)S

    public static boolean isValid(String s) {

        if ((s.length() % 2) != 0) return false; // ER
        System.out.println("Going beyond the early return");

        Stack<Character> stack = new Stack<>(); // --> O(n)S

        Map<Character, Character> pairs = new HashMap<>(); // --> O(1)S
        pairs.put('(', ')');
        pairs.put('[', ']');
        pairs.put('{', '}');

        for(char c : s.toCharArray()) { // --> O(n)T

            // if the current bracket is open bracket, push it into stack
            if (pairs.containsKey(c)) {
                stack.push(c);
            } else { // it is a closing bracket
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.pop();

                    // if the popped open bracket is not an ideal pair of the current element
                    if (!(pairs.get(top) == c)) {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println("--> "+isValid("()][]"));
    }

}
