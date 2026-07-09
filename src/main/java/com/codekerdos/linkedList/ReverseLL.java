package com.codekerdos.linkedList;

public class ReverseLL {

    public static ListNode reverse(ListNode head){

        if(head == null || head.next == null){

            return head;

        }

        ListNode temp = head;
        ListNode recResult = reverse(head.next);

        temp.next.next = temp;
        temp.next = null;

        return recResult;
    }

}
