package com.codekerdos.linkedList;

public class ReversePrintLL {

    public static void printReverse(ListNode head){

        if(head == null){
            return;
        }
        if(head.next != null){
        printReverse(head.next);
        }
        System.out.print(head.val);
    }

}
