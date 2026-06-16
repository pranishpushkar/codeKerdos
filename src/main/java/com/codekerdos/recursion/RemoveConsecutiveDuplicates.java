package com.codekerdos.recursion;

public class RemoveConsecutiveDuplicates {

    public static String removeConsecutiveDuplicates(String str, int index){

        if(index == str.length()-1){
            return str.charAt(index)+"";
        }
        char chLeft = str.charAt(index);
        char chRight = str.charAt(index+1);

        if(chLeft == chRight){
            return removeConsecutiveDuplicates(str, index+1);
        }else{
            return chLeft + removeConsecutiveDuplicates(str, index+1);
        }


    }

}
