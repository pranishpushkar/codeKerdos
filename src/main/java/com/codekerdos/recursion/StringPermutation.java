package com.codekerdos.recursion;

import java.util.*;

public class StringPermutation {

    private static List<String> ans = new ArrayList<>();

    public static List<String> getAllPermutations(String str){
        if(str.length()==0){

            return ans;

        }

        return helper(str, 0, str.length()-1);

    }
    

    private static List<String> helper(String str, int left, int right){

        if(str.length()==0){
            return ans;
        }

        String myAnswer =  String.valueOf(str.charAt(0));
        List<String> recursionAnswer = helper(str.substring(1),left+1,right);

        for(String s : recursionAnswer){
            ans.add(myAnswer + s);
        }


        return ans;

    }

}
