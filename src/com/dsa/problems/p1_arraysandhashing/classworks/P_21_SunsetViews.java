package com.dsa.problems.p1_arraysandhashing.classworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P_21_SunsetViews {

    // MEDIUM
    /********************************************************************************************************************

     Given an array of buildings and a direction that all of the buildings face,
     return an array of the indices of the buildings that can see the sunset.

     A building can see the sunset if it's strictly taller than all of the
     buildings that come after it in the direction that it faces.

     The input array named buildings  contains positive, non-zero
     integers representing the heights of the buildings. A building at index i thus has a height denoted by buildings[i]. All of
     the buildings face the same direction, and this direction is either east or
     west, denoted by the input string named direction, which will
     always be equal to either "EAST" or "WEST". In
     relation to the input array, you can interpret these directions as right for
     east and left for west.

     Important note: the indices in the ouput array should be sorted in ascending
     order.




     Sample Input #1:
     buildings = [3, 5, 4, 4, 3, 1, 3, 2]
     direction = "EAST"

     Sample Output #1:
     [1, 3, 6, 7]

     // Below is a visual representation of the sample input.

     //    _
     //   | |_ _
     //  _| | | |_   _
     // | | | | | | | |_
     // | | | | | |_| | |
     // |_|_|_|_|_|_|_|_|





     Sample Input #2:
     buildings  = [3, 5, 4, 4, 3, 1, 3, 2]
     direction = "WEST"

     Sample Output #2:
     [0, 1]

     // The buildings are the same as in the first sample
     // input, but their direction is reversed.

     *******************************************************************************************************************/


    // O(n)S
    // O(n)T


    public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {

        ArrayList<Integer> result = new ArrayList<>(); // ---> O(n)S
        int tallestSoFar = 0;

        // make sure you track the tallest building so far
        // if the curr building is taller than the tallest so far, it can see
        // update the tallest so far

        // case facing east
        if (direction.equalsIgnoreCase("east")) {
            for (int i = buildings.length-1; i >= 0; i--) { // ---> O(n)T
                int currBuildingHeight = buildings[i];
                System.out.println("currBuildingHeight: "+currBuildingHeight+", tallestSoFar: "+tallestSoFar);
                if (currBuildingHeight > tallestSoFar) {
                    result.add(i);
                    tallestSoFar = currBuildingHeight;
                    System.out.println("Updating the new tallest to --> "+tallestSoFar);
                }
            }

            Collections.reverse(result); // ---> O(n)T
        }

        if (direction.equalsIgnoreCase("west")) {
            for (int i = 0; i < buildings.length; i++) { // ---> O(n)T
                int currBuildingHeight = buildings[i];
                if (currBuildingHeight > tallestSoFar) {
                    result.add(i);
                    tallestSoFar = currBuildingHeight;
                }
            }
        }

        return result;

    }






    // O(n)T
    // O(n)S

    public static ArrayList<Integer> sunsetViews_moreOptimized(int[] buildings, String direction) {
        ArrayList<Integer> result = new ArrayList<>();

        // east
        int startIndex = buildings.length-1;
        int nextStep = -1;

        if (direction.equalsIgnoreCase("west")) {
            startIndex = 0;
            nextStep = 1;
        }

        int i = startIndex;
        int tallestSoFar = 0;

        while (i >= 0 && i < buildings.length) {
            int currBuildingHeight = buildings[i];

            if (currBuildingHeight > tallestSoFar) {
                result.add(i);
                tallestSoFar = currBuildingHeight;
            }

            i = i + nextStep;
        }


        if (direction.equalsIgnoreCase("east")) {
            Collections.reverse(result);
        }

        return result;
    }








    public static void main(String[] args) {
        int[] b = new int[]{3, 5, 4, 4, 3, 1, 3, 2};
        // List<Integer> buildings = Arrays.asList(b);
        sunsetViews(b, "east").forEach(System.out::println);
    }
}
