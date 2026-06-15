package com.codekerdos.recursion;

public class RemoveXFromString {


    // Time Complexity O(n^2) and Space Complexity O(n^2) because of substring method which takes O(n) time and space to create a new string. 
    // So overall time complexity is O(n^2) and space complexity is O(n^2)
    public static String removeX(String str) {

        if(str.length()==0){
            return str;
        }
        char ch = str.charAt(0);
        String remaining =  str.substring(1);
        if(ch=='x'){
            return removeX(remaining);

        }else{
            return ch + removeX(remaining);
        }


    }

    public static String removeXBetter(String str){

        return helper(str,0);
    }

    private static String helper(String str, int index){

        if(index == str.length()){
            return "";
        }
        char ch = str.charAt(index);
        String remaining = helper(str, index+1);
        if(ch=='x'){
            return remaining;
        }else{
            return ch + remaining;
        }
    }


}
