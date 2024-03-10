package com.dsa.problems.p1_arraysandhashing.classworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class P_22_MinRewards {

    // HARD
    // LEETCODE 135
    /********************************************************************************************************************

     Imagine that you're a teacher who's just graded the final exam in a class. You
     have a list of student scores on the final exam in a particular order (not
     necessarily sorted), and you want to reward your students. You decide to do so
     fairly by giving them arbitrary rewards following two rules:

     1. All students must receive at least one reward.
     2. Any given student must receive strictly more rewards than an adjacent
     student (a student immediately to the left or to the right) with a lower
     score and must receive strictly fewer rewards than an adjacent student with
     a higher score.

     Write a function that takes in a list of scores and returns the minimum number
     of rewards that you must give out to students to satisfy the two rules.

     You can assume that all students have different scores; in other words, the
     scores are all unique.

     Sample Input
     scores = [8, 4, 2, 1, 3, 6, 7, 9, 5]

     Sample Output
     25

     *******************************************************************************************************************/


    // O(n)T
    // O(n)T


    public static int minRewards(int[] scores) {

        // initiators
        int[] rewards = new int[scores.length]; // --> O(n)S

        Arrays.fill(rewards, 1); // Important // --> O(n)T

        // loop from left to right and give rewards for the students in up hill
        for (int i = 1; i < scores.length; i++) { // --> O(n)T
            if (scores[i] > scores[i-1]) {
                rewards[i] = rewards[i-1] + 1;
            }
        }

        // loop from right to left and give rewards for the students in up hill(with a small catch)
        for (int i = scores.length-2; i >= 0; i--) { // --> O(n)T
            if(scores[i] > scores[i+1]) {
                int iamTryingToGive = rewards[i+1] + 1;
                int alreadyExistingReward = rewards[i];
                rewards[i] = Math.max(alreadyExistingReward, iamTryingToGive);
            }
        }

        int result = 0;
        for (int reward : rewards) { // --> O(n)T
            result += reward;
        }

        // return IntStream.of(rewards).sum(); -> easy alternate

        return result;
    }



    public static void main(String[] args) {
        int rew = minRewards(new int[] {8, 4, 2, 1, 3, 6, 7, 9, 5});
        System.out.println(rew);
    }



}
