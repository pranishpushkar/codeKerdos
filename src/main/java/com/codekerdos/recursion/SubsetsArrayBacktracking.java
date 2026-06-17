package com.codekerdos.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetsArrayBacktracking {

    public static List<List<Integer>> getSubsets(int[] arr){

        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int index = 0;
        helper(arr,index,current,result);

        return result;
    }

    public static List<List<Integer>> getSubsetsInOrder(int[] arr){

        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int index = 0;
        reverseHelper(arr,index,current,result);

        return result;
    }

    private static void helper(int[] arr, int index, List<Integer> current, List<List<Integer>> result){

        if(index==arr.length){
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(arr[index]);
        helper(arr,index+1,current,result);

        current.remove(current.size()-1);
        helper(arr,index+1,current,result);

    }

    private static void reverseHelper(int[] arr, int index, List<Integer> current, List<List<Integer>> result){

        if(index==arr.length){
            result.add(new ArrayList<>(current));
            return;
        }
        reverseHelper(arr,index+1,current,result);

        current.add(arr[index]);
        reverseHelper(arr,index+1,current,result);

        current.remove(current.size()-1);

    }

}
