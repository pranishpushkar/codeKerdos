package com.codekerdos.recursion;

public class NInArrayRecursive {

    public static boolean isNInArray(int[] arr, int n) {
        
        boolean result;
        int i =arr.length - 1;

        result=helper(arr,n,i);
        return result;
        
    }

    private static boolean helper(int[] arr, int n, int i){

        if(arr[i]==n){
            return true;
        }else if(i==0 && arr[i]!=n){
            return false;
        }else{
            return helper(arr,n,i-1);
        }

    }

}
