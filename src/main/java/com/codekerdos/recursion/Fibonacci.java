package com.codekerdos.recursion;

import java.util.Arrays;

public class Fibonacci {

    public static int fib(int n) {


       int[] dp = new int[n+1];
       Arrays.fill(dp,-1);


       return helper(n,dp);
   }


   private static int helper(int n, int[] dp){


       if(n==0 || n==1){
           return dp[n]=n;
       }else if(dp[n]!=-1){
           return dp[n];
       }else{
           dp[n] = helper(n-1,dp)+helper(n-2,dp);
       }
       return dp[n];
   }
}

