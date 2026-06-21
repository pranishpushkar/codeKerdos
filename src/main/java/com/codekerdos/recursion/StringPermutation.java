package com.codekerdos.recursion;

import java.util.*;

public class StringPermutation {

    private static List<String> ans = new ArrayList<>();

    public static List<String> getAllPermutations(String str){
        String p= "";
        if(str.length()==0){

            return ans;

        }

        helper(str, p, 0, str.length()-1);

        return ans;

    }
    

    private static void helper(String str, String p, int left, int right){

        if(left>right){
            return;
        }

        if(left==right){
            ans.add(p+str.charAt(left));
        }

        p +=  String.valueOf(str.charAt(left));
        helper(str,p,left+1,right);

        

    }

}
