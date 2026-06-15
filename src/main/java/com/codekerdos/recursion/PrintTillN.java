package com.codekerdos.recursion;

public class PrintTillN {

    public static void printTillN(int n) {
        if(n == 0){
            return;
        }else{
            //System.out.println(n);
            printTillN(n-1);
            System.out.println(n);
        }
    }

}
