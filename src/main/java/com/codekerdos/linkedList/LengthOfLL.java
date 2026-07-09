package com.codekerdos.linkedList;

public class LengthOfLL {

    public static int findLength(ListNode head){
        if(head == null){
            return 0;
        }
            return 1 + findLength(head.next);
        
    }

}
