package com.codekerdos.recursion;

import java.util.*;

public class PairStar {

    private static Deque<Character> stack = new ArrayDeque<>();

    public static String appendStar(String s){
        if(s.length()<=1){
            return s;
        }
        for(int i =0; i<s.length();i++){
            if(!stack.isEmpty() && s.charAt(i)==stack.peek()){
                stack.push('*');
                stack.push(s.charAt(i));
            }else{
                stack.push(s.charAt(i));
            }
        }
        // StringBuilder to keep time complexity O(n).
        // If String is used order becomes O(n) + O(n^2) i.e. O(n^2).
        StringBuilder ans = new StringBuilder();

        while(!stack.isEmpty()){
            ans.append(stack.pollLast());
        }

        return ans.toString();


    }

}
