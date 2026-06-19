package com.codekerdos;

import java.util.List;

import com.codekerdos.recursion.*;

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

        String str = "abc";
        List<String> list = StringPermutation.getAllPermutations(str);

        for(String s : list){
            System.out.println(s);
        }

    }
}
