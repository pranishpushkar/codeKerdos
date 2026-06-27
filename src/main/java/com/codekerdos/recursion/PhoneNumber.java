package com.codekerdos.recursion;

import java.util.*;

public class PhoneNumber {

    public static String[] letterCombinations(String digits){

        if(digits.length()==0){
            return new String[0];
        }

        Map<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        

        return helper(map,digits,0,digits.length()-1);

    }

    private static String[] helper(Map<Integer,String> map, String digits, int left, int right){

        if(left>=right){
            return new String[]{""};
        }

        String myAnswer = map.get(digits.charAt(left)-'0');
        String[] recursionAnswer = helper(map,digits,left+1,right);

        String[] ans = new String[myAnswer.length()*recursionAnswer.length];
        int index=0;

        for(int i =0; i<myAnswer.length(); i++){
            for(int j=0; j<recursionAnswer.length;j++){
                ans[index] = String.valueOf(myAnswer.charAt(i)) + recursionAnswer[j];
                index++;
            }

        }

        return ans;
    }

}
