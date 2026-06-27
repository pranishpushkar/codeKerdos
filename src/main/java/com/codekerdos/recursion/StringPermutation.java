package com.codekerdos.recursion;

import java.util.*;

public class StringPermutation {

    public static List<String> getAllPermutations(String str){
    
        String p = "";
        String up = str;
        List<String> ans = new ArrayList<>();
        helper(ans, p, up);
        return ans;
    }
    

    private static void helper(List<String> ans, String p, String up){

        if(up.length()==0){
            ans.add(p);
            return;
        }

        for (int i = 0; i < up.length(); i++) {
            char temp = up.charAt(i);
            String remaining = up.substring(0, i) + up.substring(i + 1);
            helper(ans, p + temp, remaining);
        }
    }

}
