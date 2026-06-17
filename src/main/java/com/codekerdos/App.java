package com.codekerdos;

import java.util.List;

import com.codekerdos.recursion.Fibonacci;
import com.codekerdos.recursion.NInArrayRecursive;
import com.codekerdos.recursion.RemoveXFromString;
import com.codekerdos.recursion.PrintTillN;
import com.codekerdos.recursion.SubsetsOfArray;
import com.codekerdos.recursion.SubsetsArrayBacktracking;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // System.out.println( Fibonacci.fib(30) );
        // int[] arr = {1, 2, 3, 4, 5};
        // System.out.println( NInArrayRecursive.isNInArray(arr, 10) );
        // System.out.println( RemoveXFromString.removeX("xaxbxcdef") );
        // System.out.println( RemoveXFromString.removeXBetter("xaxbxcdef") );
        // PrintTillN.printTillN(5);

        int[] arr = { 1, 2, 3, 4 };

        List<List<Integer>> subsets = SubsetsArrayBacktracking.getSubsetsInOrder(arr);

        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }

    }
}
