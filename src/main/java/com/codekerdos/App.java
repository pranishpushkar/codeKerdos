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

        //System.out.println(MyPower.myPow(2,20));

        // int[] arr = {7,2,5,2,5,6,7};
        // int[] ans = MergeSortArrays.mergeSort(arr);

        // for(int i : ans){
        //     System.out.println(i);
        // }

        // int[] arr = {-100,0,1,12,34};
        // QuickSort.sort(arr,0,arr.length-1);
        // for(int i=0;i<arr.length;i++){
        //     System.out.println(arr[i]);
        // }

        for(String str : StringPermutation.getAllPermutations("abc")){
            System.out.println(str);
        }

    }
}
