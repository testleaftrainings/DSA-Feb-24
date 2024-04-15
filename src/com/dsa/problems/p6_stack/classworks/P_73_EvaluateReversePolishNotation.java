package com.dsa.problems.p6_stack.classworks;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class P_73_EvaluateReversePolishNotation {

    // MEDIUM
    // LEETCODE 150
    /********************************************************************************************************************

     Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
     Note that division between two integers should truncate toward zero.
     It is guaranteed that the given RPN expression is always valid.
     That means the expression would always evaluate to a result, and there will not be any
     division by zero operation.

     Example 1:
     Input: tokens = ["2","1","+","3","*"]
     Output: 9
     Explanation: ((2 + 1) * 3) = 9

     Example 2:
     Input: tokens = ["4","13","5","/","+"]
     Output: 6
     Explanation: (4 + (13 / 5)) = 6

     Example 3:
     Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
     Output: 22
     Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
     = ((10 * (6 / (12 * -11))) + 17) + 5
     = ((10 * (6 / -132)) + 17) + 5
     = ((10 * 0) + 17) + 5
     = (0 + 17) + 5
     = 17 + 5
     = 22

     *******************************************************************************************************************/

    // O(n)T
    // O(n)S

    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>(); // --> O(n)S

        Set<String> operands = new HashSet<>();
        operands.add("+");
        operands.add("-");
        operands.add("*");
        operands.add("/");

        for(String token : tokens) { // --> O(n)T
            if (!operands.contains(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int n1 = stack.pop();
                int n2 = stack.pop();

                if ("+".equals(token)) {
                    stack.push(n2 + n1);
                } else if ("-".equals(token)) {
                    stack.push(n2 - n1);
                } else if ("*".equals(token)) {
                    stack.push(n2 * n1);
                } else if ("/".equals(token)) {
                    stack.push(n2 / n1);
                }
            }
        }

        if (stack.size() != 1) {
            return -1;
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String[] input = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(input));
    }

}
