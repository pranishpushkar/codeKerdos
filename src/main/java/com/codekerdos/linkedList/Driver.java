package com.codekerdos.linkedList;

public class Driver {
    public static void main(String[] args) {

        // Test 1
        ListNode head1 = ListNode.buildList(new int[]{1, 2, 3, 4, 5});
        ListNode middle1 = MiddleOfLL.middleNode(head1);
        System.out.print("Middle of [1,2,3,4,5]: ");
        ListNode.printList(middle1);   // expected: 3 -> 4 -> 5

        // Test 2
        ListNode head2 = ListNode.buildList(new int[]{1, 2, 3, 4, 5, 6});
        ListNode middle2 = MiddleOfLL.middleNode(head2);
        System.out.print("Middle of [1,2,3,4,5,6]: ");
        ListNode.printList(middle2);   // expected: 4 -> 5 -> 6

        // Test 3
        ListNode head3 = ListNode.buildList(new int[]{1});
        ListNode middle3 = MiddleOfLL.middleNode(head3);
        System.out.print("Middle of [1]: ");
        ListNode.printList(middle3);   // expected: 1

        // Test 4
        ListNode head4 = ListNode.buildList(new int[]{1, 2});
        ListNode middle4 = MiddleOfLL.middleNode(head4);
        System.out.print("Middle of [1,2]: ");
        ListNode.printList(middle4);   // expected: 2
    }

}
