package com.codekerdos;

import com.codekerdos.recursion.Fibonacci;
import com.codekerdos.recursion.NInArrayRecursive;
import com.codekerdos.recursion.RemoveXFromString;
import com.codekerdos.recursion.PrintTillN;
import com.codekerdos.recursion.SubsetsOfArray;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( Fibonacci.fib(30) );
        //int[] arr = {1, 2, 3, 4, 5};
        //System.out.println( NInArrayRecursive.isNInArray(arr, 10) );
        //System.out.println( RemoveXFromString.removeX("xaxbxcdef") );
        //System.out.println( RemoveXFromString.removeXBetter("xaxbxcdef") );
        //PrintTillN.printTillN(5);

        int[] arr = {1,2,3,4};

        int[][] allSubsets = SubsetsOfArray.getAllSubsets(arr);

        System.out.println(allSubsets.length);

        for (int i = 0; i < allSubsets.length; i++) {

            System.out.print("[");

            for (int j = 0; j < allSubsets[i].length; j++) {

                System.out.print(allSubsets[i][j]);

                if (j != allSubsets[i].length - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println("]");
        }

    }
}
