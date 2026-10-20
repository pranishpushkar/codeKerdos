package com.codekerdos.twopointers;

public class Palindrome {

    public boolean checkPalindrome(String s){
        int left= 0;
        int right= s.length()-1;

        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}
