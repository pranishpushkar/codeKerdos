package com.codekerdos.linkedList;

public class MiddleOfLL {

    public static ListNode middleNode(ListNode head) {
        int count=0;
        if(head == null || head.next ==null){
            return head;
        }
        ListNode curr = head;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        System.out.println("Count: "+count);
        int mid = (int)Math.ceil(count/2);
        ListNode midNode = head;
        for(int i=0;i<mid;i++){
            midNode = midNode.next;
        }

        return midNode;
        
    } 

}
