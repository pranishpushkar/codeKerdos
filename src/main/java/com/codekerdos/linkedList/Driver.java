package com.codekerdos.linkedList;

public class Driver {

    public static void main(String[] args) {

        // Test 1
        ListNode head1 = ListNode.buildList(new int[]{1, 2, 3, 4, 5});
        ListNode result1 = NNodesToFront.appendLastNToFront(head1, 3);
        System.out.print("Append last 3 nodes of [1,2,3,4,5]: ");
        ListNode.printList(result1);   // Expected: 3 -> 4 -> 5 -> 1 -> 2

        // Test 2
        ListNode head2 = ListNode.buildList(new int[]{1, 2, 3, 4, 5});
        ListNode result2 = NNodesToFront.appendLastNToFront(head2, 2);
        System.out.print("Append last 2 nodes of [1,2,3,4,5]: ");
        ListNode.printList(result2);   // Expected: 4 -> 5 -> 1 -> 2 -> 3

        // Test 3
        ListNode head3 = ListNode.buildList(new int[]{1, 2, 3, 4, 5});
        ListNode result3 = NNodesToFront.appendLastNToFront(head3, 1);
        System.out.print("Append last 1 node of [1,2,3,4,5]: ");
        ListNode.printList(result3);   // Expected: 5 -> 1 -> 2 -> 3 -> 4

        // Test 4
        ListNode head4 = ListNode.buildList(new int[]{1, 2, 3, 4, 5});
        ListNode result4 = NNodesToFront.appendLastNToFront(head4, 0);
        System.out.print("Append last 0 nodes of [1,2,3,4,5]: ");
        ListNode.printList(result4);   // Expected: 1 -> 2 -> 3 -> 4 -> 5

        // Test 5
        ListNode head5 = ListNode.buildList(new int[]{1, 2, 3, 4, 5});
        ListNode result5 = NNodesToFront.appendLastNToFront(head5, 5);
        System.out.print("Append last 5 nodes of [1,2,3,4,5]: ");
        ListNode.printList(result5);   // Expected: 1 -> 2 -> 3 -> 4 -> 5

        // Test 6
        ListNode head6 = ListNode.buildList(new int[]{1});
        ListNode result6 = NNodesToFront.appendLastNToFront(head6, 1);
        System.out.print("Append last 1 node of [1]: ");
        ListNode.printList(result6);   // Expected: 1

        // Test 7
        ListNode head7 = ListNode.buildList(new int[]{1, 2});
        ListNode result7 = NNodesToFront.appendLastNToFront(head7, 1);
        System.out.print("Append last 1 node of [1,2]: ");
        ListNode.printList(result7);   // Expected: 2 -> 1

        // Test 8
        ListNode head8 = null;
        ListNode result8 = NNodesToFront.appendLastNToFront(head8, 0);
        System.out.print("Append last 0 nodes of []: ");
        ListNode.printList(result8);   // Expected: null
    }
}