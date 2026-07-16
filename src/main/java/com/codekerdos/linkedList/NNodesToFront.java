package com.codekerdos.linkedList;

public class NNodesToFront {

    public static ListNode appendLastNToFront(ListNode head, int n) {

        if(n==0){
            return head;
        }
        if(head==null || head.next==null){
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        ListNode tail = null;

        for(int i=0; i<n; i++){

            fast = fast.next;
        }

        if(fast==null){
            return head;
        }

        while(fast != null){
            
            if(fast.next == null){
                tail = fast;
            }
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = null;
        tail.next = head;

        return slow;

    }

}
