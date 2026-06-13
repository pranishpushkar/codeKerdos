package com.codekerdos.recursion;

public class NLastOccurrence {

    public static int getLastOccurrence(int[] arr, int n) {
        
        int result;
        int i =arr.length - 1;

        result=helper(arr,n,i);
        return result;
        
    }

    private static int helper(int[] arr, int n, int i){

        if(arr[i]==n){
            return i;
        }else if(i==0 && arr[i]!=n){
            return -1;
        }else{
            return helper(arr,n,i-1);
        }

    }

}
