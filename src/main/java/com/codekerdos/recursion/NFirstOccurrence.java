package com.codekerdos.recursion;

public class NFirstOccurrence {

    public static int getFirstOccurrence(int[] arr, int n) {
        
        int result;
        int i =0;

        result=helper(arr,n,i);
        return result;
        
    }

    private static int helper(int[] arr, int n, int i){

        if(arr[i]==n){
            return i;
        }else if(i==arr.length-1 && arr[i]!=n){
            return -1;
        }else{
            return helper(arr,n,i+1);
        }

    }

}
