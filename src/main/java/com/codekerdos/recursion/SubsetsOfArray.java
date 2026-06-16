package com.codekerdos.recursion;

public class SubsetsOfArray {

    public static int[][] getAllSubsets (int[] arr){

        // Edge case for empty array.
        if (arr.length == 0) {
            return new int[][] { {} };
        }

        return helper(arr,0,arr.length-1);

    }

    private static int[][] helper(int[] arr, int left, int right){

        if(left==right){
            int[][] ans = new int[2][];
            int[] first = new int[0];
            int[] second = new int[1];
            second[0] = arr[left];
            ans[0] = first;
            ans[1] = second;

            return ans;
        }
        int[][] myAnswer = new int[2][];
        int[] first = new int[0];
        int[] second = new int[1];
        second[0] = arr[left];
        myAnswer[0] = first;
        myAnswer[1] = second;

        int[][] recursionAnswer = helper(arr,left+1,right);
        int[][] finalAnswer = new int[2*recursionAnswer.length][];

        int ind =0;
        for(int i=0; i<recursionAnswer.length; i++){
            finalAnswer[ind] = concatenateArrays(myAnswer[0], recursionAnswer[i]);
            ind = ind+1;
            finalAnswer[ind] = concatenateArrays(myAnswer[1], recursionAnswer[i]);
            ind = ind+1;
        }

        return finalAnswer;

    }

    private static int[] concatenateArrays(int[] arr1, int[] arr2){

        int[] arr = new int[arr1.length+arr2.length];
        int index = 0;
        for(int i=0;i<arr1.length;i++){
            arr[index] = arr1[i];
            index = index+1;
        }
        for(int j=0; j<arr2.length; j++){
            arr[index] = arr2[j];
            index=index+1;
        }

        return arr;
    }

}
