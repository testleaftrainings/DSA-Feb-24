package com.dsa.problems.p2_twopointers.classworks;

public class P_46_Celebrity {

    // MEDIUM
    /********************************************************************************************************************

     Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity.
     The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.

     Now you want to find out who the celebrity is or verify that there is not one.
     The only thing you are allowed to do is to ask questions like:
     "Hi, A. Do you know B?" to get information of whether A knows B.
     You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
     You are given a helper function bool knows(a, b) which tells you whether A knows B.
     Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.

     Note: There will be exactly one celebrity if he/she is in the party.
     Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.

     *******************************************************************************************************************/





    // O(n)T
    // O(1)S
    public int findCelebrity(int n) {

        int left = 0;
        int right = n-1;

        while(left < right) { // --> O(n)T
            if(knows(left, right)) {
                left++;
            } else {
                right--;
            }
        }

        int potCeleb = left;

        // whether pot celeb knows anybody else
        for (int i = 0; i < n; i++) { // --> O(n)T
            if(i != potCeleb && knows(potCeleb, i)) {
                return -1;
            }
        }

        // whether all knows the pot celeb
        for (int i = 0; i < n; i++) { // --> O(n)T
            if(i != potCeleb && !knows(i, potCeleb)) {
                return -1;
            }
        }

        return potCeleb;
    }

    private boolean knows(int i, int j) {
        // i --> j
        // Dummy function
        // does i knows j?
        return true; // this can actually return tru or false based on person i & j
    }



}
