package com.dsa.problems.p6_stack.classworks;

import java.util.Stack;

public class P_00_StackBasics {

    // FILO, FILO
    // LIFO
    // Pointer always will be pointing to the next value to be taken out
    // Push, Pop
    // Top element: Peek


    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        stack.push("Panchathaniram");
        stack.push("Gajini");
        stack.push("VTV");
        stack.push("Kabali");
        stack.push("ManjummelBoyz");

        //System.out.println(stack);
        //String myRecentFavMovie = stack.pop();
        //System.out.println("myRecentFavMovie : "+myRecentFavMovie);




        stack.push("Kandukonden Kandukonden");

        System.out.println("The latest CD which I put inside : "+stack.peek());
        System.out.println(stack);
        System.out.println(stack.isEmpty());
        System.out.println("Index of Kabali is " + stack.search("Kabali"));


        // push
        // pop
        // peek
        // isEmpty
        // search :



    }



}
