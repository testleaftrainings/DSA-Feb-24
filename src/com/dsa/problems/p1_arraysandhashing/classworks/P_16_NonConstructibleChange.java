package com.dsa.problems.p1_arraysandhashing.classworks;

import java.lang.reflect.Array;
import java.util.Arrays;

public class P_16_NonConstructibleChange {

    // MEDIUM
    /********************************************************************************************************************

     Given an array of positive integers representing the values of coins in your
     possession, write a function that returns the minimum amount of change (the
     minimum sum of money) that you cannot create. The given coins can have
     any positive integer value and aren't necessarily unique (i.e., you can have
     multiple coins of the same value which will be given in the input).

     For example, if you're given coins = [1, 2, 5], the minimum
     amount of change that you can't create is 4.
     If you're given no coins, the minimum amount of change that you can't create is 1

     Sample Input
     coins = [5, 7, 1, 1, 2, 3, 22]

     Sample Output: 20

     *******************************************************************************************************************/





    // O(n log n)T
    // O(1)S

    public static int nonConstructibleChange(int[] coins) {

        // 1, 1, 2,3,5,99

        Arrays.sort(coins); // --> O(n log n)T

        int possibleAmount = 0;

        for (int i = 0; i < coins.length; i++) { // --> O(n)T

            int lookFor = possibleAmount + 1;
            int currentCoin = coins[i];

            if (currentCoin > lookFor) {
                return lookFor;
            }

            possibleAmount += currentCoin;
        }

        return possibleAmount+1;

    }

    public static void main(String[] args) {
        System.out.println(nonConstructibleChange(new int[] {1, 1, 2,3,5,99}));
    }

}
