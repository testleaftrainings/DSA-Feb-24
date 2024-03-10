package com.dsa.problems.p1_arraysandhashing.classworks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class P_23_LEARN_ComparableComparator {

    /********************************************************************************************************************

     Comparable	Vs Comparator
     1) Comparable provides a single sorting sequence. In other words, we can sort the collection on the basis of a single element such as id, name, and price.
        Whereas, The Comparator provides multiple sorting sequences. In other words, we can sort the collection on the basis of multiple elements such as id, name, and price etc.

     2) Comparable affects the original class, i.e., the actual class is modified.
        Whereas, Comparator doesn't affect the original class, i.e., the actual class is not modified.

     3) Comparable provides compareTo() method to sort elements.
        Whereas, Comparator provides compare() method to sort elements.

     4) Comparable is present in java.lang package.
        Whereas, A Comparator is present in the java.util package.

     5) We can sort the list elements of Comparable type by Collections.sort(List) method.
        Whereas, We can sort the list elements of Comparator type by Collections.sort(List, Comparator) method. or Arrays.sort(array, Comparator) or listObject.sort(Comparator)


     ***** ---> We most of the times use only comparator without modifying the class

     *******************************************************************************************************************/





    // COMPARABLE
    /********************************************************************************************************************

     As Java developers, we often need to sort elements that are grouped together in a collection. Java allows us to implement various sorting algorithms with any type of data.
     For example, we can sort strings in alphabetical order, reverse alphabetical order, or based on length.
     In this tutorial, we'll explore the Comparable interface and its compareTo method, which enables sorting. We'll look at sorting collections that contain objects from both core and custom classes.
     We'll also mention rules for properly implementing compareTo, as well as a broken pattern that needs to be avoided.

     The Comparable Interface:
     The Comparable interface imposes ordering on the objects of each class that implements it.
     The compareTo is the only method defined by the Comparable interface. It is often referred to as the natural comparison method.

     Implementing compareTo:
     The compareTo() method compares the current object with the object sent as a parameter.
     When implementing it, we need to make sure that the method returns:
     -> A positive integer - if the current object is greater than the parameter object
     -> A negative integer - if the current object is less than the parameter object
     -> Zero - if the current object is equal to the parameter object

     ::: So we are building the default sorting of this class objects - which should come first and which should come next
     ::: Anyway the sorting algorithm sorts in ASCENDING ORDER based on our logic

     E.g.

     @Override
     public int compareTo(Integer anotherInteger) {
     return compare(this.value, anotherInteger.value);
     }

     public static int compare (int x, int y) {
     return (x < y) ? -1 : ((x == y) ? 0 : 1);
     }


     This may seem clever, but wrong..

     @Override
     public int compareTo(BankAccount anotherAccount) {
     return this.balance - anotherAccount.balance;
     }

     Why wrong?

     The following will give wrong result
     BankAccount accountOne = new BankAccount(1900000000);
     BankAccount accountTwo = new BankAccount(-2000000000);
     int comparison = accountOne.compareTo(accountTwo);
     assertThat(comparison).isNegative();

     The correct solution is to use comparison instead of subtraction. We may also reuse the correct implementation from the core Integer class:
     @Override
     public int compareTo(BankAccount anotherAccount) {
     return Integer.compare(this.balance, anotherAccount.balance);
     }

     *********************************************************************************************************************/




    // A class 'Movie' that implements Comparable
    static class Movie implements Comparable<Movie>
    {
        private double rating;
        private String name;
        private int year;

        // Used to sort movies by year
        public int compareTo(Movie m) {
            return Integer.compare(this.year, m.year);
        }

        // Constructor
        public Movie(String nm, double rt, int yr) {
            this.name = nm;
            this.rating = rt;
            this.year = yr;
        }

        // Getter methods for accessing private data
        public double getRating() { return rating; }
        public String getName()   {  return name; }
        public int getYear()      {  return year;  }
    }







    // COMPARABLE
    /********************************************************************************************************************

     The Comparator interface defines a compare(arg1, arg2) method with two arguments that represent compared objects, and works similarly to the Comparable.compareTo() method.

     To create a Comparator, we have to implement the Comparator interface.

     public class PlayerRankingComparator implements Comparator<Player> {

    @Override
    public int compare(Player firstPlayer, Player secondPlayer) {
    return Integer.compare(firstPlayer.getRanking(), secondPlayer.getRanking());
    }

    }

     *********************************************************************************************************************/



    // Class to compare Movies by ratings
    static class RatingCompare implements Comparator<Movie>
    {
        public int compare(Movie m1, Movie m2)
        {
            if (m1.getRating() < m2.getRating()) return -1;
            if (m1.getRating() > m2.getRating()) return 1;
            else return 0;
        }
    }

    // Class to compare Movies by name
    static class NameCompare implements Comparator<Movie>
    {
        public int compare(Movie m1, Movie m2)
        {
            return m1.getName().compareTo(m2.getName());
        }
    }







    public static void main(String[] args) {
        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));

        // Sort by rating : (1) Create an object of ratingCompare
        //                  (2) Call Collections.sort
        //                  (3) Print Sorted list
        System.out.println("Sorted by rating");
        RatingCompare ratingCompare = new RatingCompare();
        Collections.sort(list, ratingCompare);
        for (Movie movie: list)
            System.out.println(movie.getRating() + " " +
                               movie.getName() + " " +
                               movie.getYear());


        // Call overloaded sort method with RatingCompare
        // (Same three steps as above)
        System.out.println("\nSorted by name");
        NameCompare nameCompare = new NameCompare();
        Collections.sort(list, nameCompare);
        for (Movie movie: list)
            System.out.println(movie.getName() + " " +
                               movie.getRating() + " " +
                               movie.getYear());

        // Uses Comparable to sort by year
        System.out.println("\nSorted by year");
        Collections.sort(list);
        for (Movie movie: list)
            System.out.println(movie.getYear() + " " +
                               movie.getRating() + " " +
                               movie.getName()+" ");



        // JAVA 8 COMPARATOR

        // 1. Classic Comparator example - Inline
        Comparator<Movie> byName = new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        // 2. Lambda expression equivalent. BEST TO USE ON THE FLY
        Comparator<Movie> byName2 =
            (Movie o1, Movie o2) -> o1.getName().compareTo(o2.getName());

    }

}
