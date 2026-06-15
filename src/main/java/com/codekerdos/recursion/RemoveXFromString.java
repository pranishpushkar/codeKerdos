package com.codekerdos.recursion;

public class RemoveXFromString {

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


}
