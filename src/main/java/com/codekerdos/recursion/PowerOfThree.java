package com.codekerdos.recursion;

public class PowerOfThree {

    public static boolean isPowerOfThree (int n){

        if(n<=0){
            return false;
        }
        if(n==1){
            return true;
        }
        if(n%3==0){
            return isPowerOfThree(n/3);

        }

        return false;

    }

}
