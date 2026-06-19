package com.codekerdos.recursion;

public class MyPower {

    public static double myPow(double x, int n){

        long N = n;
        if(N<0){
            x = 1/x;
            N=-N;
        }

        return power(x,N);
    }

    private static double power(double x, long n){

        if(n==0){
            return 1;
        }

        double result = power(x,n/2);

        return (n%2==0) ? result*result : x*result*result;

    }

}
